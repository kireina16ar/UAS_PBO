package AplikasiDana;

public class TransaksiFactory {
    public static Transaksi createTransaksi(String jenisTransaksi, User currentUser) {
        if (jenisTransaksi.equalsIgnoreCase("TopUp")) {
            return new TopUp(currentUser);
        } else if (jenisTransaksi.equalsIgnoreCase("TarikTunai")) {
            return new TarikTunai(currentUser);
        } else if (jenisTransaksi.equalsIgnoreCase("TransferDana")) {
            return new TransferDana(currentUser);
        } else {
            throw new IllegalArgumentException("Jenis transaksi tidak valid!");
        }
    }
}