package AplikasiDana;

// Inheritance TarikTunai class
class TarikTunai extends Transaksi {
    public TarikTunai(User currentUser) {
        super(currentUser);
    }

    public void tarik(double amount) {
        if (currentUser.getSaldo() >= amount) {
            currentUser.setSaldo(currentUser.getSaldo() - amount);
            updateRiwayatTransaksi("Tarik tunai: -" + amount);
            System.out.println("Penarikan tunai berhasil!");
        } else {
            System.out.println("Saldo tidak mencukupi untuk penarikan tunai.");
        }
    }

    @Override
    public void updateRiwayatTransaksi(String transaksi) {
        currentUser.getRiwayatTransaksi().tambahTransaksi(transaksi);
    }
}
