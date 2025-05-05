package Modul4_Codelab.perpustakaan;

public abstract class Buku {
    protected String judul;
    protected String penulis;
    protected String genre;

    public Buku(String judul, String penulis, String genre) {
        this.judul = judul;
        this.penulis = penulis;
        this.genre = genre;
    }

    public abstract void displayInfo();

    public String getJudul(){
        return this.judul;
    }
}