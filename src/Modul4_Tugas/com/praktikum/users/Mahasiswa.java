package Modul4_Tugas.com.praktikum.users;

import Modul4_Tugas.com.praktikum.actions.MahasiswaActions;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {

    public Mahasiswa(String username, String password) {
        super(username, password);
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu Mahasiswa:");
        System.out.println("1. Laporkan Barang Temuan/Hilang");
        System.out.println("2. Lihat Daftar Laporan");
        System.out.println("0. Logout");
        System.out.print("Masukkan pilihan: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                reportItem();
                break;
            case 2:
                viewReportedItems();
                break;
            case 0:
                System.out.println("Logout");
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    @Override
    public void reportItem() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Nama Barang: ");
        String itemName = scanner.nextLine();

        System.out.print("Masukkan Deskripsi Barang: ");
        String itemDescription = scanner.nextLine();

        System.out.print("Masukkan Lokasi Terakhir/Ditemukan: ");
        String lastLocation = scanner.nextLine();

        System.out.println("\nLaporan Barang:");
        System.out.println("Nama Barang: " + itemName);
        System.out.println("Deskripsi Barang: " + itemDescription);
        System.out.println("Lokasi Terakhir/Ditemukan: " + lastLocation);
        System.out.println("Laporan barang berhasil dikirim!");
    }

    @Override
    public void viewReportedItems() {
        System.out.println("Fitur Lihat Daftar Laporan Belum Tersedia");
    }
}