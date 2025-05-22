package Modul5_Tugas.com.praktikum.main;

import Modul5_Tugas.com.praktikum.data.Item;
import Modul5_Tugas.com.praktikum.users.Admin;
import Modul5_Tugas.com.praktikum.users.Mahasiswa;
import Modul5_Tugas.com.praktikum.users.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();

    public static void main(String[] args) {
        userList.add(new Admin("Admin123", "Password123"));
        userList.add(new Mahasiswa("Derrick Muhammad Hanif", "202410370110383"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Masukkan Pilihan: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        loginAsAdmin(scanner);
                        break;
                    case 2:
                        loginAsMahasiswa(scanner);
                        break;
                    case 3:
                        System.out.println("Keluar dari program...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Pilihan tidak valid! Silakan pilih kembali.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Input harus berupa angka! Silakan coba lagi.");
                scanner.nextLine();
            }
        }
    }

    public static void loginAsAdmin(Scanner scanner) {
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();

        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        User user = validateLogin(username, password, "Admin");
        if (user != null) {
            user.displayAppMenu();
        } else {
            System.out.println("Username atau password salah!");
        }
    }

    public static void loginAsMahasiswa(Scanner scanner) {
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();

        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        User user = validateLogin(username, password, "Mahasiswa");
        if (user != null) {
            user.displayAppMenu();
        } else {
            System.out.println("Username atau password salah!");
        }
    }

    public static User validateLogin(String username, String password, String role) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                if (role.equals("Admin") && user instanceof Admin) {
                    return user;
                } else if (role.equals("Mahasiswa") && user instanceof Mahasiswa) {
                    return user;
                }
            }
        }
        return null;
    }
}

