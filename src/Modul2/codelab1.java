package Modul2;

    class Hewan { // Atribut
    String Nama;
    String Jenis;
    String Suara;

    Hewan(String Nama, String Jenis, String Suara) { // Constructor
        this.Nama = Nama;
        this.Jenis = Jenis;
        this.Suara = Suara;
    }

    void tampilkanInfo() { // Metode untuk menampilkan informasi
        System.out.println("Nama: " + Nama);
        System.out.println("Jenis: " + Jenis);
        System.out.println("Suara: " + Suara);
        System.out.println();
    }
}

    public class codelab1 {
        public static void main(String[] args) {
            // Membuat objek hewan1 dan hewan2
            Hewan hewan1 = new Hewan("Kucing", "Mamalia", "Nyann~~");
            Hewan hewan2 = new Hewan("Anjing", "Mamalia", "Woof-Woof!!");

            // Memanggil metode tampilkanInfo untuk kedua objek
            hewan1.tampilkanInfo();
            hewan2.tampilkanInfo();
        }
    }
