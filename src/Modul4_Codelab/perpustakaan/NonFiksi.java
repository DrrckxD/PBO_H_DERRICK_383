package Modul4_Codelab.perpustakaan;

public class NonFiksi extends Buku {
    public NonFiksi(String judul, String penulis, String genre) {
        super(judul, penulis, genre);
    }

    @Override
    public void displayInfo() {
        System.out.println("Buku Non-Fiksi: " + judul + " oleh " + penulis + " (Bidang: " + genre + ")");
    }
}