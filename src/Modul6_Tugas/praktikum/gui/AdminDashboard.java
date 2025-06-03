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
import java.util.Iterator;

public class AdminDashboard {
    private JFrame frame;
    private JTable table;
    private JTable userTable;
    private DefaultTableModel itemModel;
    private DefaultTableModel userModel;

    public AdminDashboard(Admin admin) {
        frame = new JFrame("Dashboard Admin");
        frame.setLayout(new BorderLayout(20, 20));  // Add margin between components
        frame.setSize(950, 850);  // Set large size for better visibility
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);  // Center the window
        frame.setResizable(false);  // Prevent resizing

        // Panel to hold the welcome message
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Halo, Administrator " + admin.getUsername(), SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        welcomePanel.add(welcomeLabel, BorderLayout.CENTER);
        frame.add(welcomePanel, BorderLayout.NORTH);

        // Data barang yang dilaporkan (Displaying reported items)
        String[] columnNames = {"Nama", "Lokasi", "Status"};
        itemModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(itemModel);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));  // Set table font
        table.setRowHeight(30);  // Set row height
        table.setSelectionBackground(new Color(33, 150, 243)); // Highlight selection color
        table.setSelectionForeground(Color.WHITE); // Text color when row selected
        JScrollPane itemScrollPane = new JScrollPane(table);

        // Data Mahasiswa (Displaying users)
        String[] userColumnNames = {"Username", "Password"};
        userModel = new DefaultTableModel(userColumnNames, 0);
        userTable = new JTable(userModel);
        userTable.setFont(new Font("Segoe UI", Font.PLAIN, 14));  // Set table font
        userTable.setRowHeight(30);  // Set row height
        JScrollPane userScrollPane = new JScrollPane(userTable);

        // Panel for control buttons
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        JButton claimButton = new JButton("Tandai Claimed");
        claimButton.setBackground(new Color(33, 150, 243));  // Button color
        claimButton.setForeground(Color.WHITE);
        claimButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        claimButton.setFocusPainted(false);  // Remove border focus
        claimButton.setCursor(new Cursor(Cursor.HAND_CURSOR));


        // Action to mark item as claimed
        claimButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // Update the status to "Claimed" in both the table and CentralStorage
                    itemModel.setValueAt("Claimed", selectedRow, 2);
                    // Update status in CentralStorage
                    Item item = CentralStorage.reportedItems.get(selectedRow);
                    item.setStatus("Claimed");
                }
            }
        });

        controlPanel.add(claimButton);  // Add claim button to the control panel

        // Panel for managing users
        JPanel userPanel = new JPanel();
        userPanel.setLayout(new FlowLayout());

        JButton addUserButton = new JButton("Add Mahasiswa");
        JButton removeUserButton = new JButton("Remove Mahasiswa");

        // Action to add Mahasiswa to the user table
        addUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = JOptionPane.showInputDialog("Enter Mahasiswa Username:");
                String password = JOptionPane.showInputDialog("Enter Mahasiswa Password:");
                if (username != null && password != null) {
                    Mahasiswa newMahasiswa = new Mahasiswa(username, password);
                    CentralStorage.userList.add(newMahasiswa);  // Add to CentralStorage
                    userModel.addRow(new Object[]{username, password});  // Add to table
                }
            }
        });

        // Action to remove Mahasiswa from the user table
        removeUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = userTable.getSelectedRow();
                if (selectedRow != -1) {
                    String username = (String) userModel.getValueAt(selectedRow, 0);
                    // Remove from CentralStorage using an iterator
                    for (Iterator<User> iterator = CentralStorage.userList.iterator(); iterator.hasNext();) {
                        User user = iterator.next();
                        // Check if the user is an instance of Mahasiswa before casting
                        if (user instanceof Mahasiswa) {
                            Mahasiswa mahasiswa = (Mahasiswa) user;
                            if (mahasiswa.getUsername().equals(username)) {
                                iterator.remove();  // Remove the Mahasiswa object from the list
                                break;
                            }
                        }
                    }
                    userModel.removeRow(selectedRow);  // Remove from table
                }
            }
        });

        userPanel.add(addUserButton);
        userPanel.add(removeUserButton);

        // Panel for back button
        JPanel backPanel = new JPanel();
        JButton backButton = new JButton("Kembali ke Login");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();  // Close the current window
                new LoginPane();  // Open Login window
            }
        });
        backPanel.add(backButton);  // Add back button to backPanel

        // Adding panels to the frame
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(controlPanel, BorderLayout.NORTH);
        bottomPanel.add(userPanel, BorderLayout.CENTER);
        bottomPanel.add(backPanel, BorderLayout.SOUTH);

        // Adjusting panel sizes to prevent large gaps
        bottomPanel.setPreferredSize(new Dimension(800, 200));  // Reduce panel size

        frame.add(bottomPanel, BorderLayout.SOUTH);  // Add the bottom panel below the table

        frame.add(itemScrollPane, BorderLayout.WEST);  // Add the table of items (reported items)
        frame.add(userScrollPane, BorderLayout.EAST);  // Add the table of users (Mahasiswa)

        // Load the reported items and users into their respective tables
        loadReportedItems();
        loadUsers();

        frame.setVisible(true);  // Make the frame visible
    }

    // Load reported items from CentralStorage into the table
    private void loadReportedItems() {
        // Clear the existing rows before loading the data
        itemModel.setRowCount(0);

        // Add items from CentralStorage.reportedItems to the table
        for (Item item : CentralStorage.reportedItems) {
            itemModel.addRow(new Object[]{item.getItemName(), item.getLocation(), item.getStatus()});
        }
    }

    // Load users from CentralStorage into the table
    private void loadUsers() {
        // Clear the existing rows before loading the data
        userModel.setRowCount(0);

        // Add users from CentralStorage.userList to the table
        for (User user : CentralStorage.userList) {
            if (user instanceof Mahasiswa) {  // Only add Mahasiswa objects to the table
                Mahasiswa mahasiswa = (Mahasiswa) user;  // Safely cast to Mahasiswa
                userModel.addRow(new Object[]{mahasiswa.getUsername(), mahasiswa.getPassword()});
            }
        }
    }

    public static void main(String[] args) {
        Admin admin = new Admin("admin123", "admin123");  // Example admin data
        new AdminDashboard(admin);  // Send the Admin object to the dashboard
    }
}
