package Modul5_Codelab;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);
        boolean keluar = false;

        while (!keluar) {
            System.out.println("\n==== Menu ====");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama barang: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan stok awal barang: ");

                    try {
                        int stok = scanner.nextInt();
                        scanner.nextLine();
                        daftarBarang.add(new Barang(nama, stok));
                        System.out.println("Barang berhasil ditambahkan.");
                    } catch (InputMismatchException e) {
                        System.out.println("Input stok harus berupa angka!");
                        scanner.nextLine();
                    }
                    break;

                case 2:
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok barang kosong.");
                    } else {
                        Iterator<Barang> iterator = daftarBarang.iterator();
                        while (iterator.hasNext()) {
                            Barang barang = iterator.next();
                            System.out.println("Nama: " + barang.getNama() + ", Stok: " + barang.getStok());
                        }
                    }
                    break;

                case 3:
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok barang kosong.");
                        break;
                    }


                    System.out.println("Daftar Barang:");
                    for (int i = 0; i < daftarBarang.size(); i++) {
                        Barang barang = daftarBarang.get(i);
                        System.out.println(i + ". " + barang.getNama() + " - Stok: " + barang.getStok());
                    }

                    System.out.print("Pilih nomor barang untuk dikurangi stoknya: ");
                    try {
                        int indeks = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Masukkan jumlah stok yang akan diambil: ");
                        int jumlahDiambil = scanner.nextInt();
                        scanner.nextLine();

                        if (indeks < 0 || indeks >= daftarBarang.size()) {
                            System.out.println("Indeks tidak valid.");
                            break;
                        }

                        Barang barang = daftarBarang.get(indeks);

                        if (jumlahDiambil > barang.getStok()) {
                            throw new Exception("Stok untuk " + barang.getNama() + " hanya tersisa " + barang.getStok());
                        }

                        barang.setStok(barang.getStok() - jumlahDiambil);
                        System.out.println("Stok barang " + barang.getNama() + " berhasil dikurangi.");
                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka!");
                        scanner.nextLine();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Indeks barang tidak valid.");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Terima kasih!");
                    keluar = true;
                    break;

                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
                    break;
            }
        }

        scanner.close();
    }
}
