package Modul3;

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

    public void serang(KarakterGame target) {
    }
}

class Pahlawan extends KarakterGame {
    public Pahlawan(String nama, int kesehatan) {
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

class Musuh extends KarakterGame {
    public Musuh(String nama, int kesehatan) {
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

public class codelab1 {
    public static void main(String[] args) {
        KarakterGame NPC = new KarakterGame("NPC", 100);
        Pahlawan brimstone = new Pahlawan("Brimstone", 150);
        Musuh viper = new Musuh("Viper", 150);

        System.out.println("Status awal:");
        System.out.println(brimstone.getNama() + " memiliki kesehatan: " + brimstone.getKesehatan());
        System.out.println(viper.getNama() + " memiliki kesehatan: " + viper.getKesehatan());
        System.out.print("==========================================\n");

        brimstone.serang(viper);
        viper.serang(brimstone);
        brimstone.serangMematikan(viper);
    }
}