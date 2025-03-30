package Modul3_Codelab1;

class KarakterGame {
    private String nama;
    private int kesehatan;

    public KarakterGame(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    public String getNama() {
        return nama;
    }

    public int getKesehatan() {
        return kesehatan;
    }

    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    public void serang(KarakterGame target) { //Method ini nantinya akan di override oleh subclass
    }
}

/*
 * Kelas KarakterGame merupakan superclass yang digunakan untuk membuat karakter umum dalam game.
 * Yang dimana setiap karakter memiliki nama dan jumlah kesehatan (hp).
 */