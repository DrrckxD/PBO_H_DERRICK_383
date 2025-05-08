package Modul2_Tugas;

import java.util.Scanner;

public class Admin extends User {

    @Override
    public void login(Scanner scanner) {
        scanner.nextLine();

        System.out.print("Masukkan username: ");
        username = scanner.nextLine();

        System.out.print("Masukkan password: ");
        password = scanner.nextLine();

        if (username.equals("Admin383") && password.equals("Password383")) {
            System.out.println("Login Admin berhasil!");
        } else {
            System.out.println("Login gagal! Username atau password salah.");
        }
    }
}
