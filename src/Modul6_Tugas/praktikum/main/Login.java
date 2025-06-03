package Modul6_Tugas.praktikum.main;

import Modul6_Tugas.praktikum.data.Item;
import Modul6_Tugas.praktikum.users.Admin;
import Modul6_Tugas.praktikum.users.Mahasiswa;
import Modul6_Tugas.praktikum.users.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {
    private static List<User> userList = new ArrayList<>();

    public Login() {
        userList.add(new Admin("Admin123", "Password123"));
        userList.add(new Mahasiswa("Derrick Muhammad Hanif", "202410370110383"));
    }


    public static List<User> getUserList() {
        return userList;
    }

    public boolean validateLogin(String username, String password, String role) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                if (role.equals("Admin") && user instanceof Admin) {
                    return true;
                } else if (role.equals("Mahasiswa") && user instanceof Mahasiswa) {
                    return true;
                }
            }
        }
        return false;
    }
}