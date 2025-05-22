package Modul5_Tugas.com.praktikum.users;

import Modul5_Tugas.com.praktikum.data.Item;
import Modul5_Tugas.com.praktikum.main.CentralStorage;
import Modul5_Tugas.com.praktikum.actions.AdminActions;

import java.util.Iterator;
import java.util.Scanner;

public class Admin extends User implements AdminActions {

    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void displayAppMenu() {
        System.out.println("Selamat datang, Admin!");
        System.out.println("1. Kelola Laporan Barang");
        System.out.println("2. Kelola Pengguna");
        System.out.print("Pilih menu: ");

        Scanner scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    manageItems();
                    break;
                case 2:
                    manageUsers();
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Input harus berupa angka! Silakan coba lagi.");
            scanner.nextLine();
        }
    }

    @Override
    public void manageItems() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Lihat Semua Laporan");
        System.out.println("2. Tandai Barang Telah Diambil (Claimed)");
        System.out.print("Pilih sub-menu: ");

        try {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    viewAllReports();
                    break;
                case 2:
                    markItemAsClaimed();
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Input harus berupa angka! Silakan coba lagi.");
            scanner.nextLine();
        }
    }

    private void viewAllReports() {
        if (CentralStorage.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
        } else {
            for (Item item : CentralStorage.reportedItems) {
                System.out.println("Nama Barang: " + item.getItemName());
                System.out.println("Deskripsi: " + item.getDescription());
                System.out.println("Lokasi: " + item.getLocation());
                System.out.println("Status: " + item.getStatus());
                System.out.println("-----------------------------");
            }
        }
    }

    private void markItemAsClaimed() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Menampilkan semua item dengan status 'Reported':");
        int index = 0;
        for (Item item : CentralStorage.reportedItems) {
            if (item.getStatus().equals("Reported")) {
                System.out.println(index + ". Nama Barang: " + item.getItemName());
                System.out.println("Deskripsi: " + item.getDescription());
                System.out.println("Lokasi: " + item.getLocation());
                System.out.println("Status: " + item.getStatus());
                System.out.println("-----------------------------");
                index++;
            }
        }

        if (index == 0) {
            System.out.println("Tidak ada barang yang statusnya 'Reported'.");
            return;
        }

        try {
            System.out.print("Masukkan nomor indeks barang yang ingin ditandai sebagai 'Claimed': ");
            int itemIndex = scanner.nextInt();

            if (itemIndex >= 0 && itemIndex < CentralStorage.reportedItems.size()) {
                Item selectedItem = CentralStorage.reportedItems.get(itemIndex);
                if (selectedItem.getStatus().equals("Reported")) {
                    selectedItem.setStatus("Claimed");
                    System.out.println("Barang berhasil ditandai sebagai 'Claimed'.");
                } else {
                    System.out.println("Status item sudah 'Claimed'.");
                }
            } else {
                System.out.println("Indeks tidak valid!");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Input harus berupa angka! Silakan coba lagi.");
            scanner.nextLine();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Indeks yang dimasukkan tidak valid! Pastikan angka yang dimasukkan ada dalam daftar.");
        }
    }

    @Override
    public void manageUsers() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Hapus Mahasiswa");
        System.out.print("Pilih sub-menu: ");

        try {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addMahasiswa();
                    break;
                case 2:
                    removeMahasiswa();
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Input harus berupa angka! Silakan coba lagi.");
            scanner.nextLine();
        }
    }


    public void addMahasiswa() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Nama Mahasiswa: ");
        String name = scanner.nextLine();
        System.out.print("Masukkan NIM Mahasiswa: ");
        String nim = scanner.nextLine();

        Mahasiswa mahasiswa = new Mahasiswa(name, nim);
        CentralStorage.userList.add(mahasiswa);
        System.out.println("Mahasiswa berhasil ditambahkan!");
    }


    public void removeMahasiswa() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
        String nimToDelete = scanner.nextLine();

        Iterator<User> iterator = CentralStorage.userList.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user instanceof Mahasiswa && user.getUsername().equals(nimToDelete)) {
                iterator.remove();
                System.out.println("Mahasiswa dengan NIM " + nimToDelete + " berhasil dihapus.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Mahasiswa dengan NIM " + nimToDelete + " tidak ditemukan.");
        }
    }
}
