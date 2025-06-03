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
        // Setup frame
        frame = new JFrame("Dashboard Mahasiswa");
        frame.setLayout(new BorderLayout(20, 20));  // Add margin between components
        frame.setSize(1500, 850);  // Set large size for better visibility
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);  // Center window
        frame.setResizable(false);  // Prevent resizing

        // Welcome Label with improved font and alignment
        JLabel welcomeLabel = new JLabel("Selamat datang, " + mahasiswa.getUsername(), SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        welcomeLabel.setForeground(new Color(33, 150, 243)); // Nice blue color
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Add padding to the label
        frame.add(welcomeLabel, BorderLayout.NORTH);

        // Table setup with Status Column
        String[] columnNames = {"Nama Barang", "Lokasi", "Status"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));  // Set table font
        table.setRowHeight(30);  // Set row height
        table.setSelectionBackground(new Color(33, 150, 243)); // Highlight selection color
        table.setSelectionForeground(Color.WHITE); // Text color when row selected
        JScrollPane scrollPane = new JScrollPane(table);  // Add scroll pane to table
        frame.add(scrollPane, BorderLayout.CENTER);  // Add the table panel to the center of the frame

        // Create a panel for the form and buttons
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2, 10, 10));  // Using GridLayout for form elements

        JLabel itemLabel = new JLabel("Nama Barang:");
        JTextField itemField = new JTextField(20);
        JLabel locationLabel = new JLabel("Lokasi:");
        JTextField locationField = new JTextField(20);

        formPanel.add(itemLabel);
        formPanel.add(itemField);
        formPanel.add(locationLabel);
        formPanel.add(locationField);

        // Panel for the buttons (backButton and reportButton)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));  // Center aligned buttons with margin

        JButton backButton = new JButton("Kembali ke Login");
        backButton.setBackground(new Color(244, 67, 54));  // Red button
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        backButton.setFocusPainted(false);  // Remove border focus
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Kembali ke Menu Login
                frame.dispose();  // Close the current window
                new LoginPane();  // Open Login Window
            }
        });

        JButton reportButton = new JButton("Laporkan");
        reportButton.setBackground(new Color(33, 150, 243));  // Button color
        reportButton.setForeground(Color.WHITE);
        reportButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        reportButton.setFocusPainted(false);  // Remove border focus
        reportButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Button action to add row in the table and store in CentralStorage
        reportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String itemName = itemField.getText();
                String location = locationField.getText();
                if (!itemName.isEmpty() && !location.isEmpty()) {
                    // Create item and add it to CentralStorage
                    Item newItem = new Item(itemName, "No Description", location, "Belum Diclaim");
                    CentralStorage.reportedItems.add(newItem);  // Store in the CentralStorage
                    model.addRow(new Object[]{itemName, location, "Belum Diclaim"});  // Update table
                    itemField.setText("");  // Clear input fields
                    locationField.setText("");
                }
            }
        });

        // Add both buttons (backButton and reportButton) to buttonPanel
        buttonPanel.add(backButton);  // Kembali ke Login button
        buttonPanel.add(reportButton);  // Laporkan button

        // Add the form and button panel to the bottom part of the frame
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(formPanel, BorderLayout.CENTER);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(bottomPanel, BorderLayout.SOUTH);  // Add the bottom panel below the form

        frame.setVisible(true);  // Make frame visible
    }

    public static void main(String[] args) {
        Mahasiswa mahasiswa = new Mahasiswa("Derrick Muhammad Hanif", "202410370110383");  // Example Mahasiswa object
        new MahasiswaDashboard(mahasiswa);  // Pass Mahasiswa object to the dashboard
    }
}
