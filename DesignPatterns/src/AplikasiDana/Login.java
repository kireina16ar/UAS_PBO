package AplikasiDana;

import java.util.Scanner;
class Login {
    private DanaApp danaApp;
    private Scanner scanner;

    public Login(DanaApp danaApp) {
        this.danaApp = danaApp;
        this.scanner = new Scanner(System.in);
    }

    public void processLogin() {
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        if (danaApp.login(username, password)) {
            System.out.println("Login berhasil!");
        } else {
            System.out.println("Username atau password salah!");
        }
    }
}