package AplikasiDana;

public class UserBuilder {
    private String username;
    private String password;
    private String nomorKontak;

    public UserBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder setNomorKontak(String nomorKontak) {
        this.nomorKontak = nomorKontak;
        return this;
    }

    public User build() {
        return new User(username, password, nomorKontak);
    }
}
