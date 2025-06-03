package Modul6_Tugas.praktikum.main;

import Modul6_Tugas.praktikum.data.Item;
import Modul6_Tugas.praktikum.users.Admin;
import Modul6_Tugas.praktikum.users.Mahasiswa;
import Modul6_Tugas.praktikum.users.User;

import java.util.ArrayList;

public class CentralStorage {
    public static ArrayList<Item> reportedItems = new ArrayList<>();
    public static ArrayList<User> userList = new ArrayList<>();

    static {

        Admin admin1 = new Admin("Admin383", "Password383");
        Mahasiswa mahasiswa1 = new Mahasiswa("Derrick", "202410370110383");


        userList.add(admin1);
        userList.add(mahasiswa1);
    }
}
