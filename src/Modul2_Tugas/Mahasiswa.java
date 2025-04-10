package Modul2_Tugas;

import java.util.Scanner;

class Mahasiswa extends User {

    @Override
    public void login(Scanner scanner) {
        scanner.nextLine();

        System.out.print("Masukkan Nama: ");
        username = scanner.nextLine().toUpperCase();

        System.out.print("Masukkan NIM: ");
        password = scanner.nextLine();

        if (username.equals("DERRICK MUHAMMAD HANIF") && password.equals("202410370110383")) {
            System.out.println("Login Mahasiswa berhasil!");
            System.out.println("Nama: " + username);
            System.out.println("NIM: " + password);
        } else {
            System.out.println("Login gagal! Nama atau NIM salah.");
        }
    }
}
