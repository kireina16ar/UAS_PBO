package AplikasiDana;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DanaApp {
    private List<User> users;
    private User currentUser;

    public DanaApp() {
        users = new ArrayList<>();
        currentUser = null;
    }

    public void register(User user) {
        users.add(user);
        System.out.println("Registrasi berhasil!");
    }

    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println("Login berhasil!");
                return true;
            }
        }
        return false;
    }

    public void startApp() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("Selamat datang di Aplikasi Dana");
        System.out.println("================================");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");
            int menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1:
                    System.out.print("Masukkan username: ");
                    String regUsername = scanner.nextLine();
                    System.out.print("Masukkan password: ");
                    String regPassword = scanner.nextLine();
                    System.out.print("Masukkan nomor kontak: ");
                    String regNomorKontak = scanner.nextLine();
                    User newUser = new UserBuilder()
                            .setUsername(regUsername)
                            .setPassword(regPassword)
                            .setNomorKontak(regNomorKontak)
                            .build();
                    register(newUser);
                    break;
                case 2:
                    System.out.print("Masukkan username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Masukkan password: ");
                    String loginPassword = scanner.nextLine();
                    if (login(loginUsername, loginPassword)) {
                        handleLoggedIn();
                    } else {
                        System.out.println("Username atau password salah!");
                    }
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan aplikasi Dana. Sampai jumpa!");
                    return;
                default:
                    System.out.println("Menu yang Anda pilih tidak valid!");
                    break;
            }
        }
    }

    public void handleLoggedIn() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nSelamat datang, " + currentUser.getUsername() + "!");

        while (true) {
            System.out.println("================================");
            System.out.println("\nSilahkan Pilih Menu:");
            System.out.println("1. Lihat Saldo");
            System.out.println("2. Top Up");
            System.out.println("3. Tarik Tunai");
            System.out.println("4. Transfer Dana");
            System.out.println("5. Riwayat Transaksi");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");
            int menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1:
                    System.out.println("Saldo Anda saat ini: " + currentUser.getSaldo());
                    break;
                case 2:
                    System.out.print("Masukkan jumlah top up: ");
                    double topUpAmount = scanner.nextDouble();
                    Transaksi topUp = TransaksiFactory.createTransaksi("TopUp", currentUser);
                    ((TopUp) topUp).topUp(topUpAmount);
                    break;
                case 3:
                    System.out.print("Masukkan jumlah tarik tunai: ");
                    double tarikTunaiAmount = scanner.nextDouble();
                    Transaksi tarikTunai = TransaksiFactory.createTransaksi("TarikTunai", currentUser);
                    ((TarikTunai) tarikTunai).tarik(tarikTunaiAmount);
                    break;
                case 4:
                    System.out.print("Masukkan username penerima: ");
                    String receiverUsername = scanner.nextLine();
                    System.out.print("Masukkan jumlah transfer: ");
                    double transferAmount = scanner.nextDouble();
                    User receiver = null;
                    for (User user : users) {
                        if (user.getUsername().equals(receiverUsername)) {
                            receiver = user;
                            break;
                        }
                    }
                    if (receiver != null) {
                        Transaksi transferDana = TransaksiFactory.createTransaksi("TransferDana", currentUser);
                        boolean transferResult = ((TransferDana) transferDana).transfer(receiver, transferAmount);
                        if (transferResult) {
                            System.out.println("Transfer berhasil!");
                        } else {
                            System.out.println("Saldo Anda tidak mencukupi!");
                        }
                    } else {
                        System.out.println("Username penerima tidak ditemukan!");
                    }
                    break;
                case 5:
                    RiwayatTransaksi riwayatTransaksi = currentUser.getRiwayatTransaksi();
                    if (riwayatTransaksi.isEmpty()) {
                        System.out.println("Belum ada riwayat transaksi.");
                    } else {
                        System.out.println("Riwayat Transaksi:");
                        for (String transaksi : riwayatTransaksi.getTransaksiList()) {
                            System.out.println(transaksi);
                        }
                    }
                    break;
                
                case 6:
                    System.out.println("Terima kasih telah menggunakan aplikasi Dana. Sampai jumpa!");
                    return;
                default:
                    System.out.println("Menu yang Anda pilih tidak valid!");
                    break;
            }
        }
    }
}

