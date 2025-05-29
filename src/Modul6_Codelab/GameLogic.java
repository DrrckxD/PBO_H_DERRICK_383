package Modul6_Codelab;

import java.util.Random;

public class GameLogic {
    private int angkaRahasia;
    private int jumlahPercobaan;
    private boolean sudahBenar;

    public GameLogic() {
        resetGame();
    }

    public void resetGame() {
        angkaRahasia = new Random().nextInt(100) + 1;
        jumlahPercobaan = 0;
        sudahBenar = false;
    }

    public String cekTebakan(int tebakan) {
        jumlahPercobaan++;
        if (tebakan < angkaRahasia) return "Terlalu kecil!";
        else if (tebakan > angkaRahasia) return "Terlalu besar!";
        else {
            sudahBenar = true;
            return "Tebakan benar!";
        }
    }

    public int getJumlahPercobaan() {
        return jumlahPercobaan;
    }

    public boolean isSudahBenar() {
        return sudahBenar;
    }
}
