package Modul4_Codelab.perpustakaan;

import org.w3c.dom.ls.LSOutput;

public class Anggota implements Peminjaman {
    private String nama;
    private String idAnggota;

    public Anggota(String nama, String idAnggota) {
        this.nama = nama;
        this.idAnggota = idAnggota;
    }

    @Override
    public void anggotaId() {
        System.out.println("Anggota: " + nama + " (ID: " + idAnggota + ")");
    }

    @Override
    public void pinjamBuku(Buku buku, int durasi) {
        System.out.println(nama + " meminjam buku berjudul: " + buku.getJudul() + " selama " + durasi + " hari.");
    }

    @Override
    public void kembalikanBuku(Buku buku) {
        System.out.println(nama + " mengembalikan buku berjudul: " + buku.getJudul());
    }
}