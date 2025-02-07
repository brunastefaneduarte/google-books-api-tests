package google_api_test;

public class App {
    public String getGreeting() {
        return "Google Api tests";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}
