package AplikasiDana;

// Inheritance
class TopUp extends Transaksi {
    public TopUp(User currentUser) {
        super(currentUser);
    }

    @Override
    public void updateRiwayatTransaksi(String transaksi) {
        riwayatTransaksi.tambahTransaksi(transaksi);
    }

    public void topUp(double amount) {
        currentUser.setSaldo(currentUser.getSaldo() + amount);
        updateRiwayatTransaksi("Top Up: +" + amount);
        System.out.println("Top up berhasil!");
    }
}
