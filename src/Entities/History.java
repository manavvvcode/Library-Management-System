package Entities;

import java.time.LocalDate;

public class History {
    private Book book;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private LocalDate dueDate;
    private HistoryStatus status;

    public History(Book book, LocalDate borrowDate, LocalDate dueDate) {
        this.book = book;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.status = HistoryStatus.BORROWED;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public HistoryStatus getStatus() {
        return status;
    }

    public void setStatus(HistoryStatus status) {
        this.status = status;
    }

    //    public void markReturned(LocalDate returnDate) {
//        this.returnDate = returnDate;
//        this.status = HistoryStatus.RETURNED;
//    }

    public boolean isOverdue() {
        return this.status == HistoryStatus.BORROWED && LocalDate.now().isAfter(this.dueDate);
    }

    public void markReturned() {
        this.setStatus(HistoryStatus.RETURNED);
    }
}
