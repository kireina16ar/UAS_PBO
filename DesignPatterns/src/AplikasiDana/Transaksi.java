package AplikasiDana;

// Abstract Transaksi class
public abstract class Transaksi {
    protected User currentUser;
    protected RiwayatTransaksi riwayatTransaksi;

    public Transaksi(User currentUser) {
        this.currentUser = currentUser;
        this.riwayatTransaksi = currentUser.getRiwayatTransaksi();
    }

    public abstract void updateRiwayatTransaksi(String transaksi);
}