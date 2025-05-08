package Modul4_Tugas.com.praktikum.users;

import java.util.Scanner;

public abstract class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean validateCredentials(String correctUsername, String correctPassword) {
        return this.username.equals(correctUsername) && this.password.equals(correctPassword);
    }

    public abstract void displayAppMenu();
}