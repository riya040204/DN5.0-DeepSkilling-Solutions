import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApplication {

    public static void main(String[] args) {

        System.out.println("=== Starting Spring Application Context ===");

        // Load Spring context from XML config
        ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("=== Spring Context Loaded Successfully ===");

        // Get BookService bean from Spring container
        BookService bookService = (BookService) context.getBean("bookService");

        System.out.println("\n=== Library Management System ===");

        // Test the application
        bookService.addBook("Spring in Action");
        System.out.println();

        bookService.searchBook("Spring in Action");
        System.out.println();

        bookService.removeBook("Spring in Action");

        System.out.println("\n=== Application Finished ===");

        // Close context
        ((ClassPathXmlApplicationContext) context).close();
    }
}
