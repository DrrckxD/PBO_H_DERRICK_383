package Modul4_Codelab.perpustakaan;

public interface Peminjaman {
    void anggotaId();
    void pinjamBuku(Buku buku, int durasi);
    void kembalikanBuku(Buku buku);
}