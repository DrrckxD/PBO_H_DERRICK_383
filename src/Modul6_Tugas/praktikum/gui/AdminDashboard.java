package Modul6_Tugas.praktikum.gui;

import Modul6_Tugas.praktikum.users.Admin;
import Modul6_Tugas.praktikum.main.CentralStorage;
import Modul6_Tugas.praktikum.data.Item;
import Modul6_Tugas.praktikum.users.Mahasiswa;
import Modul6_Tugas.praktikum.users.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.util.Iterator;

public class AdminDashboard {
    private JFrame frame;
    private JTable table;
    private JTable userTable;
    private DefaultTableModel itemModel;
    private DefaultTableModel userModel;

    public AdminDashboard(Admin admin) {
        frame = new JFrame("Dashboard Admin");
        frame.setLayout(new BorderLayout(20, 20));
        frame.setSize(950, 850);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);

        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Halo, Administrator " + admin.getUsername(), SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        welcomePanel.add(welcomeLabel, BorderLayout.CENTER);
        frame.add(welcomePanel, BorderLayout.NORTH);

        String[] columnNames = {"Nama", "Lokasi", "Status", "Claimed"};
        itemModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(itemModel);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(30);
        table.setSelectionBackground(new Color(33, 150, 243));
        table.setSelectionForeground(Color.WHITE);
        JScrollPane itemScrollPane = new JScrollPane(table);

        TableColumn claimedColumn = table.getColumnModel().getColumn(3);
        claimedColumn.setCellEditor(new DefaultCellEditor(new JCheckBox()));

        String[] userColumnNames = {"Username", "Password"};
        userModel = new DefaultTableModel(userColumnNames, 0);
        userTable = new JTable(userModel);
        userTable.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        userTable.setRowHeight(30);
        JScrollPane userScrollPane = new JScrollPane(userTable);

        JPanel hboxPanel = new JPanel();
        hboxPanel.setLayout(new BoxLayout(hboxPanel, BoxLayout.X_AXIS));
        hboxPanel.add(itemScrollPane);
        hboxPanel.add(Box.createHorizontalStrut(20));
        hboxPanel.add(userScrollPane);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        table.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                if (column == 3) {
                    boolean isClaimed = (boolean) itemModel.getValueAt(row, column);
                    Item item = CentralStorage.reportedItems.get(row);
                    item.setStatus(isClaimed ? "Claimed" : "Belum Diclaim");
                }
            }
        });

        JPanel vboxPanel = new JPanel();
        vboxPanel.setLayout(new BoxLayout(vboxPanel, BoxLayout.Y_AXIS));
        vboxPanel.add(hboxPanel);
        vboxPanel.add(Box.createVerticalStrut(20));
        vboxPanel.add(controlPanel);

        JPanel userPanel = new JPanel();
        userPanel.setLayout(new FlowLayout());

        JButton addUserButton = new JButton("Add Mahasiswa");
        JButton removeUserButton = new JButton("Remove Mahasiswa");

        addUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = JOptionPane.showInputDialog("Enter Mahasiswa Username:");
                String password = JOptionPane.showInputDialog("Enter Mahasiswa Password:");
                if (username != null && password != null) {
                    Mahasiswa newMahasiswa = new Mahasiswa(username, password);
                    CentralStorage.userList.add(newMahasiswa);
                    userModel.addRow(new Object[]{username, password});
                }
            }
        });

        removeUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = userTable.getSelectedRow();
                if (selectedRow != -1) {
                    String username = (String) userModel.getValueAt(selectedRow, 0);
                    for (Iterator<User> iterator = CentralStorage.userList.iterator(); iterator.hasNext();) {
                        User user = iterator.next();
                        if (user instanceof Mahasiswa) {
                            Mahasiswa mahasiswa = (Mahasiswa) user;
                            if (mahasiswa.getUsername().equals(username)) {
                                iterator.remove();
                                break;
                            }
                        }
                    }
                    userModel.removeRow(selectedRow);
                }
            }
        });

        userPanel.add(addUserButton);
        userPanel.add(removeUserButton);

        JPanel backPanel = new JPanel();
        JButton backButton = new JButton("Kembali ke Login");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new LoginPane();
            }
        });
        backPanel.add(backButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(vboxPanel, BorderLayout.CENTER);
        mainPanel.add(userPanel, BorderLayout.SOUTH);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(backPanel, BorderLayout.SOUTH);

        loadReportedItems();
        loadUsers();

        frame.setVisible(true);
    }

    private void loadReportedItems() {
        itemModel.setRowCount(0);
        for (Item item : CentralStorage.reportedItems) {
            itemModel.addRow(new Object[]{item.getItemName(), item.getLocation(), item.getStatus(), false});
        }
    }

    private void loadUsers() {
        userModel.setRowCount(0);
        for (User user : CentralStorage.userList) {
            if (user instanceof Mahasiswa) {
                Mahasiswa mahasiswa = (Mahasiswa) user;
                userModel.addRow(new Object[]{mahasiswa.getUsername(), mahasiswa.getPassword()});
            }
        }
    }

    public static void main(String[] args) {
        Admin admin = new Admin("Admin383", "Admin383");
        new AdminDashboard(admin);
    }
}
