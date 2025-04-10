package Modul3_Codelab;

public class Main {
    public static void main(String[] args) {
        KarakterGame bot = new KarakterGame("Bot", 100);
        Attacker brimstone = new Attacker("Brimstone", 150);
        Defender viper = new Defender("Viper", 150);

        System.out.println("Status awal:");
        System.out.println(bot.getNama() + " memiliki kesehatan: " + bot.getKesehatan());
        System.out.println(brimstone.getNama() + " memiliki kesehatan: " + brimstone.getKesehatan());
        System.out.println(viper.getNama() + " memiliki kesehatan: " + viper.getKesehatan());
        System.out.print("==========================================\n");

        brimstone.serang(viper);
        viper.serang(brimstone);
        brimstone.serangMematikan(viper);
    }
}

/*
 * Kelas Main disini digunakan untuk menjalankan program.
 * Di sini tempat kita membuat beberapa karakter dan menguji interaksi antar karakter.
 */