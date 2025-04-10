package Modul3_Codelab;

class Attacker extends KarakterGame {
    public Attacker(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    public void serangMematikan(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Orbital Strike!");
        target.setKesehatan(target.getKesehatan() - 1000);
        if (target.getKesehatan() <= 0) {
            System.out.println(target.getNama() + " telah Meninggoy!");
            System.out.print("==========================================\n");
        } else {
            System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
            System.out.print("==========================================\n");
        }
    }

    @Override
    public void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Molly");
        target.setKesehatan(target.getKesehatan() - 20);
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
 * Kelas Attacker merupakan subclass dari KarakterGame.
 * Yang dimana memiliki method untuk mengurangi kesehatan lawan dan juga menampilkan kesehatan lawan setelahnya.
 * Jika kesehatan lawan <= 0 maka akan ditampilkan "(nama karakter) telah meninggoy
 */