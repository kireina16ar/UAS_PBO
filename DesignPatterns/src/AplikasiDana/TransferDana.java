package AplikasiDana;

// Inheritance TransferDana class
class TransferDana extends Transaksi {
    public TransferDana(User currentUser) {
        super(currentUser);
    }

    public boolean transfer(User receiver, double amount) {
        if (currentUser.getSaldo() >= amount) {
            currentUser.setSaldo(currentUser.getSaldo() - amount);
            receiver.setSaldo(receiver.getSaldo() + amount);

            updateRiwayatTransaksi("Transfer dana: -" + amount + " ke " + receiver.getUsername());

            return true;
        } else {
            return false;
        }
    }

    @Override
    public void updateRiwayatTransaksi(String transaksi) {
        currentUser.getRiwayatTransaksi().tambahTransaksi(transaksi);
    }
}

