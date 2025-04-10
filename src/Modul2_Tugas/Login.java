package Modul2_Tugas;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
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
                user = new Admin();
            } else if (loginChoice == 2) {
                user = new Mahasiswa();
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
            }
        }

        scanner.close();
    }
}
