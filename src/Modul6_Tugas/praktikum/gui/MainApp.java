package Modul6_Tugas.praktikum.gui;

import javax.swing.*;

public class MainApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginPane();
            }
        });
    }
}