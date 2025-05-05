package Modul4_Codelab.app;

import Modul4_Codelab.perpustakaan.Anggota;
import Modul4_Codelab.perpustakaan.Buku;
import Modul4_Codelab.perpustakaan.Fiksi;
import Modul4_Codelab.perpustakaan.NonFiksi;

public class Main {
    public static void main(String[] args) {
        Buku buku1 = new NonFiksi ("Madilog", "Tan Malaka", "Sejarah & Ilmu Pengetahuan");
        Buku buku2 = new Fiksi ("Pulang", "Tere Liye", "Dongeng");

        buku1.displayInfo();
        buku2.displayInfo();
        System.out.println();

        Anggota anggota1 = new Anggota("Derrick M. Hanif", "H383");
        Anggota anggota2 = new Anggota("Nabil Sahsada S.", "H357");

        anggota1.anggotaId();
        anggota2.anggotaId();
        System.out.println();

        anggota1.pinjamBuku(buku1, 7);
        anggota2.pinjamBuku(buku2, 10);
        System.out.println();

        anggota1.kembalikanBuku(buku1);
        anggota2.kembalikanBuku(buku2);
    }

    public static void tampilkanInfoBuku(Buku buku) {
        buku.displayInfo();
    }
}