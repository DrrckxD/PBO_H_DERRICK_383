package Modul3_Tugas;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Admin admin = new Admin("Admin383", "Password383");
        Mahasiswa mahasiswa = new Mahasiswa("DERRICK MUHAMMAD HANIF", "202410370110383");

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nPilih login:");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan: ");
            int loginChoice = scanner.nextInt();

            User user = null;

            if (loginChoice == 1) {
                scanner.nextLine();
                System.out.print("Masukkan username Admin: ");
                String adminUsername = scanner.nextLine();
                System.out.print("Masukkan password Admin: ");
                String adminPassword = scanner.nextLine();
                user = new Admin(adminUsername, adminPassword);
            } else if (loginChoice == 2) {
                scanner.nextLine();
                System.out.print("Masukkan Nama Mahasiswa: ");
                String mahasiswaUsername = scanner.nextLine();
                System.out.print("Masukkan NIM Mahasiswa: ");
                String mahasiswaPassword = scanner.nextLine();
                user = new Mahasiswa(mahasiswaUsername, mahasiswaPassword);
            } else if (loginChoice == 3) {
                System.out.println("Terima kasih! Program berhenti.");
                isRunning = false;
                continue;
            } else {
                System.out.println("Pilihan tidak valid.");
                continue;
            }

            if (user != null) {
                user.login(scanner);
                user.displayInfo();
            }
        }

        scanner.close();
    }
}
