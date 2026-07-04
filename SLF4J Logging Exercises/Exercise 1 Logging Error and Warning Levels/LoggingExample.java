import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {

        System.out.println("=== SLF4J Logging Demo ===");

        // ERROR - serious problem, application may stop
        logger.error("This is an error message");

        // WARN - something unexpected but app continues
        logger.warn("This is a warning message");

        // INFO - general information about app flow
        logger.info("This is an info message");

        // DEBUG - detailed info for debugging
        logger.debug("This is a debug message");

        // TRACE - most detailed level
        logger.trace("This is a trace message");

        System.out.println("=== Logging with variables ===");

        String username = "Riya";
        int errorCode = 404;

        logger.error("User {} not found. Error code: {}", username, errorCode);
        logger.warn("Low balance warning for user: {}", username);
        logger.info("User {} logged in successfully", username);

        System.out.println("=== Exception Logging ===");

        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("Exception occurred: {}", e.getMessage());
            logger.warn("Attempted division by zero!");
        }

        System.out.println("=== Logging Complete ===");
    }
}
