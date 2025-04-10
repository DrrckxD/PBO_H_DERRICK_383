package Modul3_Codelab;

class Defender extends KarakterGame {
    public Defender(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override
    public void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Snake Bite!");
        target.setKesehatan(target.getKesehatan() - 15);
        if (target.getKesehatan() <= 0) {
            System.out.println(target.getNama() + " telah Meninggoy!");
            System.out.print("==========================================\n");
        } else {
            System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
            System.out.print("==========================================\n");
        }
    }
}

/*
 * Kelas Defender merupakan subclass dari KarakterGame.
 * Yang dimana memiliki method untuk mengurangi kesehatan lawan dan juga menampilkan kesehatan lawan setelahnya.
 * Jika kesehatan lawan <= 0 maka akan ditampilkan "(nama karakter) telah meninggoy*
 */