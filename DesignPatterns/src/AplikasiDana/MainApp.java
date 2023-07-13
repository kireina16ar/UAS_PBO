package AplikasiDana;

// MainApp class
public class MainApp {
    public static void main(String[] args) {
        DanaApp danaApp = DanaAppSingleton.getInstance().getDanaApp();
        danaApp.startApp();
    }
}