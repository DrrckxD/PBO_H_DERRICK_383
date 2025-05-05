package Modul4_Codelab.perpustakaan;

public class Fiksi extends Buku {
    public Fiksi(String judul, String penulis, String genre) {
        super(judul, penulis, genre);
    }

    @Override
    public void displayInfo() {
        System.out.println("Buku Fiksi: " + judul + " oleh " + penulis + " (Genre: " + genre + ")");
    }
}