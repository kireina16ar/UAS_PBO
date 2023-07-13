package AplikasiDana;

// DanaAppSingleton class
public class DanaAppSingleton {
    private static DanaAppSingleton instance;
    private DanaApp danaApp;

    private DanaAppSingleton() {
        danaApp = new DanaApp();
    }

    public static DanaAppSingleton getInstance() {
        if (instance == null) {
            synchronized (DanaAppSingleton.class) {
                if (instance == null) {
                    instance = new DanaAppSingleton();
                }
            }
        }
        return instance;
    }

    public DanaApp getDanaApp() {
        return danaApp;
    }
}
