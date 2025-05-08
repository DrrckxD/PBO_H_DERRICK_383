package Modul4_Tugas.com.praktikum.main;

import Modul4_Tugas.com.praktikum.users.Admin;
import Modul4_Tugas.com.praktikum.users.Mahasiswa;
import Modul4_Tugas.com.praktikum.users.User;

import java.util.Scanner;

public abstract class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        User admin = new Admin("Admin383", "Password383");
        User mahasiswa = new Mahasiswa("DERRICK MUHAMMAD HANIF", "202410370110383");


        while (true) {
            System.out.println("Pilih Login");
            System.out.println("1.Admin");
            System.out.println("2.Mahasiswa");
            System.out.println("3.Keluar");
            System.out.print("Masukkan pilihan: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Masukkan username Admin: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan password Admin: ");
                String password = scanner.nextLine();

                if (admin.validateCredentials(username, password)) {
                    System.out.println("Login Admin berhasil!");
                    admin.displayAppMenu();
                } else {
                    System.out.println("Login gagal! Username atau password salah.");
                }

            } else if (choice == 2) {
                System.out.print("Masukkan Nama Mahasiswa: ");
                String username = scanner.nextLine().toUpperCase();
                System.out.print("Masukkan NIM Mahasiswa: ");
                String password = scanner.nextLine();

                if (mahasiswa.validateCredentials(username, password)) {
                    System.out.println("Login Mahasiswa berhasil!");
                    mahasiswa.displayAppMenu();
                } else {
                    System.out.println("Login gagal! Nama atau NIM salah.");
                }

            } else if (choice == 3) {
                System.out.println("Terima kasih! Program berhenti.");
                break;
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }

        scanner.close();
    }
}
