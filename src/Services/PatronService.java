package Services;

import Entities.History;
import Entities.HistoryStatus;
import Entities.Patron;
import Utils.InvalidIdException;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class PatronService {

    public Map<String, Patron> patronMap = new HashMap<>();

    public void addPatron(Patron patron) {
        patronMap.put(patron.getId(), patron);
    }

    public void deletePatron(String id) throws InvalidIdException {
        if (patronMap.containsKey(id)) {
            patronMap.remove(id);
            return;
        }
        throw new InvalidIdException("Patron id doesn't exist!");
    }

    public void listAllPatrons() {
        for (Map.Entry<String, Patron> mapElement : patronMap.entrySet()) {
            String key = mapElement.getKey();
            Patron patron = mapElement.getValue();
            System.out.println("Patron id - " + patron.getId());
            System.out.println("Patron name - " + patron.getName());
            System.out.println("Patron email - " + patron.getEmail());
            System.out.println("Here is the patron's borrow History");
            System.out.println("patron's borrow count is - " + patron.borrowCount());
            System.out.println("patron's overdue count is - " + patron.overdueCount());
            System.out.println("--------------------------------------------------------------");
        }
    }

    public void searchPatronById(String id) throws InvalidIdException {
        if (patronMap.containsKey(id)) {
            System.out.println("Here is the information for patron id " + id);
            System.out.println("Name - " + patronMap.get(id).getName());
            System.out.println("Email - " + patronMap.get(id).getEmail());
            System.out.println("patron's borrow count is - " + patronMap.get(id).borrowCount());
            System.out.println("patron's overdue count is - " + patronMap.get(id).overdueCount());
            System.out.println("Borrowing history:");
            if (patronMap.get(id).getPatronBorrowingHistory().isEmpty()) {
                System.out.println(patronMap.get(id).getName() + " doesnt have a borrowing history.");
            } else {
                for (History h : patronMap.get(id).getPatronBorrowingHistory()) {
                    System.out.println("Book issued - " + h.getBook().getTitle());
                    System.out.println("Borrow date - " + h.getBorrowDate());
                    System.out.println("Return date - " + h.getReturnDate());
                    System.out.println("Due date - " + h.getDueDate());
                    if (h.isOverdue()) {
                        h.setStatus(HistoryStatus.OVERDUE);
                    }
                    System.out.println("Status - " + h.getStatus());
                    System.out.println("----------x-------------");
                }

            }
            return;
        }
        throw new InvalidIdException("Patron id doesn't exist");
    }

    //huuyu
    public Patron returnPatronById(String id) throws InvalidIdException {
        if (patronMap.containsKey(id)) {
            return patronMap.get(id);
        }
        throw new InvalidIdException("Patron id doesn't exist");
    }

    public void refreshAllOverdues() {
        for (Patron p : patronMap.values()) {
            for (History h : p.getPatronBorrowingHistory()) {
                if (h.getStatus() == HistoryStatus.BORROWED && LocalDate.now().isAfter(h.getDueDate())) {
                    h.setStatus(HistoryStatus.OVERDUE);
                }
            }
        }
    }

    public void patronSummary(String id) throws InvalidIdException {
        if (patronMap.containsKey(id)) {
            if (patronMap.get(id).isBorrowHistoryEmpty()) {
                System.out.println("borrow history is empty.");
                return;
            }
            for (History x : patronMap.get(id).getPatronBorrowingHistory()) {
                System.out.println("Book borrowed - " + x.getBook().getTitle());
                System.out.println("Book borrow date - " + x.getBorrowDate());
                System.out.println("Book return date - " + x.getReturnDate());
                System.out.println("Book due date - " + x.getDueDate());
                System.out.println("Book status - " + x.getStatus());
            }
            return;
        }
        throw new InvalidIdException("patron id doesn't exist.");
    }

}
