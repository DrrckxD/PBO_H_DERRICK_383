package Modul2;

class RekeningBank {
    // Atribut
    String nomorRekening;
    String namaPemilik;
    double saldo;

    // Konstruktor
    RekeningBank(String nomorRekening, String namaPemilik, double saldo) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    }

    // Menampilkan informasi rekening
    void tampilkanInfo() {
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: Rp" + saldo);
        System.out.println();
    }

    // Menyimpan uang
    void setorUang(double jumlah) {
        saldo += jumlah;
        System.out.println(namaPemilik + " menyetor Rp" + jumlah + ". Saldo sekarang: Rp" + saldo);
        System.out.println();
    }

    // Menarik uang
    void tarikUang(double jumlah) {
        if (jumlah > saldo) {
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Gagal, Saldo tidak mencukupi) Saldo saat ini: Rp" + saldo);
            System.out.println();
        } else {
            saldo -= jumlah;
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Berhasil) Saldo sekarang: Rp" + saldo);
            System.out.println();
        }
    }
}

public class codelab2 {
    public static void main(String[] args) {
        // Membuat objek rekening1 dan rekening2
        RekeningBank rekening1 = new RekeningBank("202410370110383", "Derrick", 2000000.0);
        RekeningBank rekening2 = new RekeningBank("202410370110357", "Nabil", 1000000.0);

        // Menampilkan informasi awal
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();

        // Melakukan transaksi
        rekening1.setorUang(200000.0);
        rekening2.setorUang(500000.0);

        rekening1.tarikUang(800000.0);
        rekening2.tarikUang(3000000.0);

        // Menampilkan informasi akhir
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();
    }
}

