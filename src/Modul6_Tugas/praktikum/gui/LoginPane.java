package Modul6_Tugas.praktikum.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Modul6_Tugas.praktikum.main.CentralStorage;
import Modul6_Tugas.praktikum.main.Login;
import Modul6_Tugas.praktikum.users.Admin;
import Modul6_Tugas.praktikum.users.Mahasiswa;
import Modul6_Tugas.praktikum.users.User;
import java.util.List;

public class LoginPane {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;
    private JLabel errorMessage;

    public LoginPane() {
        // Setup frame
        frame = new JFrame("Lost & Found Kampus");
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center window

        // Title label
        JLabel titleLabel = new JLabel("Login Sistem Lost & Found");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titleLabel.setForeground(new Color(60, 60, 60)); // Soft gray color
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 0, 20, 0); // Top margin
        frame.add(titleLabel, gbc);

        // Role Label and Combo Box
        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        roleComboBox = new JComboBox<>(new String[] { "Mahasiswa", "Admin" });
        roleComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 5, 10); // Top margin for role section
        frame.add(roleLabel, gbc);

        gbc.gridx = 1;
        frame.add(roleComboBox, gbc);

        // Username label and text field
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        usernameField = new JTextField(20);
        usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        usernameField.setPreferredSize(new Dimension(200, 30)); // Set width
        usernameField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Border styling

        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(usernameLabel, gbc);

        gbc.gridx = 1;
        frame.add(usernameField, gbc);

        // Password label and password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordField.setPreferredSize(new Dimension(200, 30)); // Set width
        passwordField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Border styling

        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(passwordLabel, gbc);

        gbc.gridx = 1;
        frame.add(passwordField, gbc);

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        loginButton.setBackground(new Color(33, 150, 243)); // Light blue
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String role = (String) roleComboBox.getSelectedItem();

                // Validate login credentials
                if (validateLoginWithUserList(username, password, role)) {
                    JOptionPane.showMessageDialog(frame, "Login Berhasil!", "Info", JOptionPane.INFORMATION_MESSAGE);
                    // Navigate to appropriate dashboard
                    if (role.equals("Mahasiswa")) {
                        Mahasiswa mahasiswa = getMahasiswaByUsername(username);
                        new MahasiswaDashboard(mahasiswa); // Pass Mahasiswa object
                    } else {
                        Admin admin = getAdminByUsername(username);
                        new AdminDashboard(admin); // Pass Admin object
                    }
                    frame.dispose(); // Close login frame
                } else {
                    errorMessage.setText("Login gagal, periksa kredensial.");
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(15, 0, 10, 0); // Add some space before button
        frame.add(loginButton, gbc);

        // Error message label
        errorMessage = new JLabel("");
        errorMessage.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        errorMessage.setForeground(Color.RED);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 0, 10, 0);
        frame.add(errorMessage, gbc);

        // Show the frame
        frame.setVisible(true);
    }

    // Validate login credentials from user list
    private boolean validateLoginWithUserList(String username, String password, String role) {
        for (User user : CentralStorage.userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                if (role.equals("Admin") && user instanceof Admin) {
                    return true;
                } else if (role.equals("Mahasiswa") && user instanceof Mahasiswa) {
                    return true;
                }
            }
        }
        return false;
    }

    // Helper method to get Mahasiswa by username
    private Mahasiswa getMahasiswaByUsername(String username) {
        for (User user : CentralStorage.userList) {
            if (user instanceof Mahasiswa && user.getUsername().equals(username)) {
                return (Mahasiswa) user;
            }
        }
        return null;
    }

    // Helper method to get Admin by username
    private Admin getAdminByUsername(String username) {
        for (User user : CentralStorage.userList) {
            if (user instanceof Admin && user.getUsername().equals(username)) {
                return (Admin) user;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new LoginPane();
    }
}


