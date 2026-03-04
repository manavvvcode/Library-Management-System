import Entities.Book;
import Entities.Patron;
import Services.BookService;
import Services.LibraryService;
import Services.PatronService;
import Utils.InvalidIdException;

public class Main {
    public static void main(String[] args) throws InvalidIdException {
        //System.out.println("Hello, World!");

        BookService bookService = new BookService();
        PatronService patronService = new PatronService();

        LibraryService libraryService = new LibraryService(bookService, patronService);
        //added 6 books for testing
        bookService.addBook(new Book("ISBN101", "Clean Code", "Robert C. Martin", 2008));
        bookService.addBook(new Book("ISBN102", "Effective Java", "Joshua Bloch", 2018));
        bookService.addBook(new Book("ISBN103", "Design Patterns", "Erich Gamma", 1994));
        bookService.addBook(new Book("ISBN104", "Atomic Habits", "James Clear", 2018));
        bookService.addBook(new Book("ISBN105", "Deep Work", "Cal Newport", 2016));
        bookService.addBook(new Book("ISBN106", "The Pragmatic Programmer", "Andrew Hunt", 1999));
        //added 3 patrons for test
        patronService.addPatron(new Patron("manav@example.com", "Manav", "P101"));
        patronService.addPatron(new Patron("rahul@example.com", "Rahul", "P102"));
        patronService.addPatron(new Patron("rahul@example.com", "Sneha", "P103"));
        try {
            libraryService.borrowBook("P101", "ISBN101");
            libraryService.borrowBook("P101", "ISBN102");
            libraryService.borrowBook("P101", "ISBN103");
            //patronService.patronSummary("P101");
            //patronService.searchPatronById("P101");
            libraryService.returnBook("P101", "ISBN101");
            patronService.searchPatronById("P101");

            //libraryService.borrowBook("P101", "ISBN101");
            // patronService.listAllPatrons();
            //patronService.refreshAllOverdues();
            //patronService.patronSummary("P101");
        } catch (InvalidIdException e) {
            System.out.println(e.getMessage());
        }
    }
}