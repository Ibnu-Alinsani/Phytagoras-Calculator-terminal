import application.Application;

public class App {
    public static void main(String[] args) throws Exception {

        // ScannerLine scan = new ScannerLine();
        // scan.run();

        Application app = new Application();
        app.choice();
    }

    public static String testFunction(String str) {
        String argumen = str;
        return "Parameter " + argumen;
    }
}
