package Modul4_Tugas.com.praktikum.users;

import Modul4_Tugas.com.praktikum.actions.AdminActions;
import java.util.Scanner;

public class Admin extends User implements AdminActions {

    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu Admin:");
        System.out.println("1. Kelola Laporan Barang");
        System.out.println("2. Kelola Data Mahasiswa");
        System.out.println("0. Logout");
        System.out.print("Masukkan pilihan: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                manageItems();
                break;
            case 2:
                manageUsers();
                break;
            case 0:
                System.out.println("Logout");
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    @Override
    public void manageItems() {
        System.out.println("Fitur Kelola Barang Belum Tersedia");
    }

    @Override
    public void manageUsers() {
        System.out.println("Fitur Kelola Mahasiswa Belum Tersedia");
    }
}