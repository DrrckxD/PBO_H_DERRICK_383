package Modul2_Tugas;

import java.util.Scanner;

abstract class User {
    String username;
    String password;

    public abstract void login(Scanner scanner);
}
