import Services.BookService;
import Services.LibraryService;
import Services.PatronService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        BookService bookService= new BookService();
        PatronService patronService = new PatronService();

        LibraryService libraryService = new LibraryService(bookService,patronService);


    }
}