package Services;

import Entities.Book;
import Utils.InvalidIdException;

import java.util.HashMap;
import java.util.Map;

public class BookService {

    public Map<String, Book> bookMap = new HashMap<>();

    public void addBook(Book book) {
        bookMap.put(book.getIsbn(), book);
    }

    public void deleteBook(String id) throws InvalidIdException {
        if (bookMap.containsKey(id)) {
            bookMap.remove(id);
            return;
        }
        throw new InvalidIdException("Book id doesn't exist");
    }
    public void returnAllBooks(){
        for(Map.Entry<String,Book>mapElement : bookMap.entrySet()){
            String key = mapElement.getKey();
            Book book = mapElement.getValue();
            System.out.println("Book id - "+key);
            System.out.println("Book info -");
            System.out.println("Book name - "+book.getTitle());
            System.out.println("Book author - "+book.getAuthor());
            System.out.println("Book publication year - "+book.getPublicationYear());
            System.out.println("Book borrow count - "+book.getBorrowCount());
            System.out.println("--------------------------------------------------------------");
        }
    }

    public void bookById(String id) throws InvalidIdException {
        if (bookMap.containsKey(id)) {
            System.out.println("Title - " + bookMap.get(id).getTitle());
            System.out.println("Author - " + bookMap.get(id).getAuthor());
            System.out.println("status - " + bookMap.get(id).getStatus());
            System.out.println("--------------------------------------------------------------");
            return;
        }
        throw new InvalidIdException("Book id doesn't exist.");
    }

    public Book returnbookById(String id) throws InvalidIdException {
        if (bookMap.containsKey(id)) {
            return bookMap.get(id);
        }
        throw new InvalidIdException("Book id doesn't exist.");
    }
}
