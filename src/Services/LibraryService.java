package Services;

import Entities.Book;
import Entities.BookStatus;
import Entities.History;
import Entities.Patron;
import Utils.InvalidIdException;

import java.time.LocalDate;

public class LibraryService {

    private BookService bookService;
    private PatronService patronService;

    public LibraryService(BookService bookService, PatronService patronService) {
        this.bookService = bookService;
        this.patronService = patronService;
    }

    public void borrowBook(String pId, String isbn) throws InvalidIdException {
        Book book = bookService.returnbookById(isbn);
        Patron patron = patronService.returnPatronById(pId);
        if (!book.getStatus().equals(BookStatus.AVAILABLE)) {
            throw new RuntimeException("Book is not available");
        }
        book.incrementBorrowCount();
        book.setStatus(BookStatus.BOOKED);
        for (History x : patron.getPatronBorrowingHistory()) {
            if (x.getBook().getIsbn().equals(isbn) && x.getReturnDate() == null) {
                System.out.println(patron.getName() + " already has " + x.getBook().getTitle());
                return;
            }
        }
        patron.addHistory(new History(book, LocalDate.now(), LocalDate.now().plusWeeks(2)));
    }

    public void returnBook(String pId, String isbn) throws InvalidIdException {
        Book book = bookService.returnbookById(isbn);
        Patron patron = patronService.returnPatronById(pId);
        book.setStatus(BookStatus.AVAILABLE);
        for (History x : patron.getPatronBorrowingHistory()) {
            if (x.getBook().getIsbn().equals(isbn) && x.getReturnDate() == null) {
                x.setReturnDate(LocalDate.now());
                x.markReturned();
            }
        }
    }
}
