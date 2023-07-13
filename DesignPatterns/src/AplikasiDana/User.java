package AplikasiDana;

class User implements CloneableUser {
    private String username;
    private String password;
    private double saldo;
    private String nomorKontak;
    private RiwayatTransaksi riwayatTransaksi;

    public User(String username, String password, String nomorKontak) {
        this.username = username;
        this.password = password;
        this.saldo = 0.0;
        this.nomorKontak = nomorKontak;
        this.riwayatTransaksi = new RiwayatTransaksi();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNomorKontak() {
        return nomorKontak;
    }

    public RiwayatTransaksi getRiwayatTransaksi() {
        return riwayatTransaksi;
    }

    @Override
    public User cloneUser() {
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
