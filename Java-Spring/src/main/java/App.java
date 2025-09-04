import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BookService;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService)ctx.getBean("bookService");
        bookService.save();
    }
}
