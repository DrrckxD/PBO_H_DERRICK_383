package Modul6_Tugas.praktikum.users;

import Modul6_Tugas.praktikum.actions.MahasiswaActions;
import Modul6_Tugas.praktikum.data.Item;
import Modul6_Tugas.praktikum.main.CentralStorage;

import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {

    public Mahasiswa(String username, String password) {
        super(username, password);
    }

    @Override
    public void displayAppMenu() {
        System.out.println("Selamat datang, Mahasiswa!");
        System.out.println("1. Laporkan Item");
        System.out.println("2. Lihat Daftar Item");
        System.out.print("Pilih menu: ");
        Scanner scanner = new Scanner(System.in);

        try {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    reportItem();
                    break;
                case 2:
                    viewReportedItems();
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Input harus berupa angka! Silakan coba lagi.");
            scanner.nextLine(); // Clear the buffer
        }
    }

    @Override
    public void reportItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama barang: ");
        String itemName = scanner.nextLine();
        System.out.print("Masukkan deskripsi barang: ");
        String description = scanner.nextLine();
        System.out.print("Masukkan lokasi barang: ");
        String location = scanner.nextLine();

        Item item = new Item(itemName, description, location, "Reported");
        CentralStorage.reportedItems.add(item);

        System.out.println("Barang berhasil dilaporkan!");
    }

    @Override
    public void viewReportedItems() {
        if (CentralStorage.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
        } else {
            for (Item item : CentralStorage.reportedItems) {
                if (item.getStatus().equals("Reported")) {
                    System.out.println("Nama Barang: " + item.getItemName());
                    System.out.println("Deskripsi: " + item.getDescription());
                    System.out.println("Lokasi: " + item.getLocation());
                    System.out.println("Status: " + item.getStatus());
                    System.out.println("-----------------------------");
                }
            }
        }
    }
}
