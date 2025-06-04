package JavaGuiGuide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiExample {

    public static void main(String[] args) {
        // Membuat frame utama
        JFrame frame = new JFrame("GUI Tutorial dengan HBox dan VBox");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat panel utama
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));  // Menggunakan VBox (Vertical)

        // Membuat label
        JLabel label = new JLabel("Selamat datang di GUI!");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);  // Agar label berada di tengah
        mainPanel.add(label);

        // Membuat panel untuk HBox (Horizontal)
        JPanel hboxPanel = new JPanel();
        hboxPanel.setLayout(new BoxLayout(hboxPanel, BoxLayout.X_AXIS));  // Menggunakan HBox (Horizontal)

        // Membuat tombol
        JButton button = new JButton("Klik Saya!");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        hboxPanel.add(button);

        // Membuat input teks (Entry)
        JTextField textField = new JTextField();
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        hboxPanel.add(textField);

        // Menambahkan hboxPanel ke mainPanel
        mainPanel.add(hboxPanel);

        // Tombol untuk menampilkan nilai input
        JButton showButton = new JButton("Tampilkan Input");
        showButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(showButton);

        // Membuat radio button
        JRadioButton radioButton1 = new JRadioButton("Option 1");
        radioButton1.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(radioButton1);

        JRadioButton radioButton2 = new JRadioButton("Option 2");
        radioButton2.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(radioButton2);

        // Mengelompokkan radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);

        // Membuat combo box
        String[] options = {"Pilih Warna", "Merah", "Hijau", "Biru"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(comboBox);

        // Membuat checkbox
        JCheckBox checkBox = new JCheckBox("Setuju dengan syarat");
        checkBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(checkBox);

        // Menambahkan event listener untuk tombol
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Tombol telah diklik!");
            }
        });

        // Event listener untuk tombol "Tampilkan Input"
        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userInput = textField.getText();
                String radioSelection = radioButton1.isSelected() ? "Option 1" : (radioButton2.isSelected() ? "Option 2" : "Tidak ada pilihan");
                String comboSelection = (String) comboBox.getSelectedItem();
                boolean isChecked = checkBox.isSelected();

                JOptionPane.showMessageDialog(frame,
                        "Input yang dimasukkan: " + userInput +
                                "\nPilihan Radio: " + radioSelection +
                                "\nComboBox: " + comboSelection +
                                "\nCheckbox: " + (isChecked ? "Setuju" : "Tidak Setuju"));
            }
        });

        // Menampilkan frame
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
