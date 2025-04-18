package Modul3_Tugas;

import java.util.Scanner;

class Mahasiswa extends User {

    public Mahasiswa(String username, String password) {
        super(username, password);
    }

    @Override
    public void login(Scanner scanner) {
        scanner.nextLine();

        System.out.print("Masukkan Nama: ");
        String inputUsername = scanner.nextLine().toUpperCase();

        System.out.print("Masukkan NIM: ");
        String inputPassword = scanner.nextLine();

        if (inputUsername.equals(this.getUsername()) && inputPassword.equals(this.getPassword())) {
            System.out.println("Login Mahasiswa berhasil!");
            System.out.println("Nama: " + inputUsername);
            System.out.println("NIM: " + inputPassword);
        } else {
            System.out.println("Login gagal! Nama atau NIM salah.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Informasi Mahasiswa: Login berhasil!");
    }
}
