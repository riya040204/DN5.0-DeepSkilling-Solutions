public class LoggerTest {

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        logger1.log("Application started.");

        Logger logger2 = Logger.getInstance();
        logger2.log("Processing data.");

        Logger logger3 = Logger.getInstance();
        logger3.log("Application ended.");

       System.out.println("\n--- Singleton Verification ---");
        System.out.println("logger1 == logger2 : " + (logger1 == logger2));
        System.out.println("logger2 == logger3 : " + (logger2 == logger3));

        if (logger1 == logger2 && logger2 == logger3) {
           System.out.println("Singleton verified! Only ONE instance exists.");
        }
    }
}