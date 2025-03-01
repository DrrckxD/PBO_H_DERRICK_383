import java.util.Scanner;

public class tugas1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Displaying login options
        System.out.println("Pilih login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan: ");
        int loginChoice = scanner.nextInt();

        // Handling invalid choices
        if (loginChoice != 1 && loginChoice != 2) {
            System.out.println("Pilihan tidak valid.");
        } else {
            scanner.nextLine(); // Consume the newline character

            // Admin login
            if (loginChoice == 1) {
                System.out.print("Masukkan username: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String password = scanner.nextLine();

                // Checking Admin credentials
                if (username.equals("Admin383") && password.equals("Password383")) {
                    System.out.println("Login Admin berhasil!");
                } else {
                    System.out.println("Login gagal! Username atau password salah.");
                }
            }
            // Mahasiswa login
            else if (loginChoice == 2) {
                System.out.print("Masukkan Nama: ");
                String name = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = scanner.nextLine();

                // Checking Mahasiswa credentials
                if (name.equals("Derrick Muhammad Hanif") && nim.equals("202410370110383")) {
                    System.out.println("Login Mahasiswa berhasil!");
                    System.out.println("Nama: " + name);
                    System.out.println("NIM: " + nim);
                } else {
                    System.out.println("Login gagal! Nama atau NIM salah.");
                }
            }
        }    

        scanner.close();
    }
}
