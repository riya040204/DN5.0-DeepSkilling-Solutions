import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApplication {

    public static void main(String[] args) {

        System.out.println("=== Loading Spring Application Context ===\n");

        ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\n=== Testing Constructor Injection ===");
        BookService serviceConstructor =
            (BookService) context.getBean("bookServiceConstructor");
        serviceConstructor.addBook("Clean Code");
        serviceConstructor.searchBook("Clean Code");

        System.out.println("\n=== Testing Setter Injection ===");
        BookService serviceSetter =
            (BookService) context.getBean("bookServiceSetter");
        serviceSetter.addBook("Design Patterns");
        serviceSetter.searchBook("Design Patterns");
        serviceSetter.removeBook("Design Patterns");

        System.out.println("\n=== Dependency Injection Verified! ===");

        ((ClassPathXmlApplicationContext) context).close();
    }
}
