package AplikasiDana;

// RiwayatTransaksi class
import java.util.ArrayList;
import java.util.List;

class RiwayatTransaksi {
    private List<String> transaksiList;

    public RiwayatTransaksi() {
        transaksiList = new ArrayList<>();
    }

    public void tambahTransaksi(String transaksi) {
        transaksiList.add(transaksi);
    }

    public List<String> getTransaksiList() {
        return transaksiList;
    }

    public boolean isEmpty() {
        return transaksiList.isEmpty();
    }
}