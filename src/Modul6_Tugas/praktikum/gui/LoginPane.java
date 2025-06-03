package Modul6_Tugas.praktikum.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Modul6_Tugas.praktikum.main.CentralStorage;
import Modul6_Tugas.praktikum.users.Admin;
import Modul6_Tugas.praktikum.users.Mahasiswa;
import Modul6_Tugas.praktikum.users.User;

public class LoginPane {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;
    private JLabel errorMessage;

    public LoginPane() {
        frame = new JFrame("Lost & Found Kampus");
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Login Sistem Lost & Found");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titleLabel.setForeground(new Color(60, 60, 60));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 0, 20, 0);
        frame.add(titleLabel, gbc);

        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        roleComboBox = new JComboBox<>(new String[] { "Mahasiswa", "Admin" });
        roleComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 5, 10);
        frame.add(roleLabel, gbc);

        gbc.gridx = 1;
        frame.add(roleComboBox, gbc);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        usernameField = new JTextField(20);
        usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        usernameField.setPreferredSize(new Dimension(200, 30));
        usernameField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(usernameLabel, gbc);

        gbc.gridx = 1;
        frame.add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordField.setPreferredSize(new Dimension(200, 30));
        passwordField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(passwordLabel, gbc);

        gbc.gridx = 1;
        frame.add(passwordField, gbc);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        loginButton.setBackground(new Color(33, 150, 243));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String role = (String) roleComboBox.getSelectedItem();

                if (validateLoginWithUserList(username, password, role)) {
                    JOptionPane.showMessageDialog(frame, "Login Berhasil!", "Info", JOptionPane.INFORMATION_MESSAGE);
                    if (role.equals("Mahasiswa")) {
                        Mahasiswa mahasiswa = getMahasiswaByUsername(username);
                        new MahasiswaDashboard(mahasiswa);
                    } else {
                        Admin admin = getAdminByUsername(username);
                        new AdminDashboard(admin);
                    }
                    frame.dispose();
                } else {
                    errorMessage.setText("Login gagal, periksa kredensial.");
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(15, 0, 10, 0);
        frame.add(loginButton, gbc);

        errorMessage = new JLabel("");
        errorMessage.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        errorMessage.setForeground(Color.RED);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 0, 10, 0);
        frame.add(errorMessage, gbc);

        frame.setVisible(true);
    }

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

    private Mahasiswa getMahasiswaByUsername(String username) {
        for (User user : CentralStorage.userList) {
            if (user instanceof Mahasiswa && user.getUsername().equals(username)) {
                return (Mahasiswa) user;
            }
        }
        return null;
    }

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