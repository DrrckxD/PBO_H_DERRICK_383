package Modul3_Tugas;

import java.util.Scanner;

class Admin extends User {

    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void login(Scanner scanner) {
        scanner.nextLine();

        System.out.print("Masukkan username: ");
        String inputUsername = scanner.nextLine();

        System.out.print("Masukkan password: ");
        String inputPassword = scanner.nextLine();

        if (inputUsername.equals(this.getUsername()) && inputPassword.equals(this.getPassword())) {
            System.out.println("Login Admin berhasil!");
        } else {
            System.out.println("Login gagal! Username atau password salah.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Informasi Admin: Login berhasil!");
    }
}
