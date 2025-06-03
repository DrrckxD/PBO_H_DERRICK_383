package Modul6_Tugas.praktikum.gui;

import Modul6_Tugas.praktikum.users.Mahasiswa;
import Modul6_Tugas.praktikum.data.Item;
import Modul6_Tugas.praktikum.main.CentralStorage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class MahasiswaDashboard {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;

    public MahasiswaDashboard(Mahasiswa mahasiswa) {
        frame = new JFrame("Dashboard Mahasiswa");
        frame.setSize(1500, 850);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        frame.add(contentPanel, BorderLayout.CENTER);

        JLabel welcomeLabel = new JLabel("Selamat datang, " + mahasiswa.getUsername(), SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        welcomeLabel.setForeground(new Color(33, 150, 243));
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPanel.add(welcomeLabel);

        // Table for displaying reported items
        String[] columnNames = {"Nama Barang", "Lokasi", "Deskripsi", "Status"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(30);
        table.setSelectionBackground(new Color(33, 150, 243));
        table.setSelectionForeground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(table);
        contentPanel.add(scrollPane);

        // Form panel for adding new items
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel itemLabel = new JLabel("Nama Barang:");
        JTextField itemField = new JTextField(20);
        JLabel locationLabel = new JLabel("Lokasi:");
        JTextField locationField = new JTextField(20);

        JLabel descriptionLabel = new JLabel("Deskripsi:");
        JRadioButton kecilButton = new JRadioButton("Kecil");
        JRadioButton sedangButton = new JRadioButton("Sedang");
        JRadioButton besarButton = new JRadioButton("Besar");

        ButtonGroup descriptionGroup = new ButtonGroup();
        descriptionGroup.add(kecilButton);
        descriptionGroup.add(sedangButton);
        descriptionGroup.add(besarButton);

        formPanel.add(itemLabel);
        formPanel.add(itemField);
        formPanel.add(locationLabel);
        formPanel.add(locationField);
        formPanel.add(descriptionLabel);
        JPanel radioPanel = new JPanel();
        radioPanel.add(kecilButton);
        radioPanel.add(sedangButton);
        radioPanel.add(besarButton);
        formPanel.add(radioPanel);

        contentPanel.add(formPanel);

        JPanel gapPanel = new JPanel();
        gapPanel.setPreferredSize(new Dimension(10, 20));
        contentPanel.add(gapPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton backButton = new JButton("Kembali ke Login");
        backButton.setBackground(new Color(244, 67, 54));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        backButton.setFocusPainted(false);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new LoginPane();
            }
        });

        JButton reportButton = new JButton("Laporkan");
        reportButton.setBackground(new Color(33, 150, 243));
        reportButton.setForeground(Color.WHITE);
        reportButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        reportButton.setFocusPainted(false);
        reportButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        reportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String itemName = itemField.getText();
                String location = locationField.getText();
                String description = "No Description";

                if (kecilButton.isSelected()) {
                    description = "Kecil";
                } else if (sedangButton.isSelected()) {
                    description = "Sedang";
                } else if (besarButton.isSelected()) {
                    description = "Besar";
                }

                if (!itemName.isEmpty() && !location.isEmpty()) {
                    Item newItem = new Item(itemName, description, location, "Belum Diclaim");
                    CentralStorage.reportedItems.add(newItem);
                    model.addRow(new Object[]{itemName, location, description, "Belum Diclaim"});
                    itemField.setText("");
                    locationField.setText("");
                    descriptionGroup.clearSelection();
                }
            }
        });

        buttonPanel.add(backButton);
        buttonPanel.add(reportButton);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(formPanel, BorderLayout.CENTER);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        contentPanel.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);

        // Load existing items from CentralStorage
        loadItems();
    }

    private void loadItems() {
        model.setRowCount(0);  // Clear existing rows
        for (Item item : CentralStorage.reportedItems) {
            model.addRow(new Object[]{item.getItemName(), item.getLocation(), item.getDescription(), item.getStatus()});
        }
    }

    public static void main(String[] args) {
        Mahasiswa mahasiswa = new Mahasiswa("Derrick Muhammad Hanif", "202410370110383");
        new MahasiswaDashboard(mahasiswa);
    }
}
