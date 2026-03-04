package Entities;
import java.util.*;

public class Patron {
    private String id;
    private String name;
    private String email;
    private List<History> patronBorrowingHistory;

    public Patron(String email, String name, String id) {
        this.email = email;
        this.name = name;
        this.id = id;
        this.patronBorrowingHistory=new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<History> getPatronBorrowingHistory() {
        return patronBorrowingHistory;
    }
    public void addHistory(History history){
        patronBorrowingHistory.add(history);
    }
    public boolean isBorrowHistoryEmpty(){
        return this.getPatronBorrowingHistory().isEmpty();
    }

    public int borrowCount() {
        int count=0;
        for(History x : patronBorrowingHistory){
            if(x.getStatus()==HistoryStatus.BORROWED){
                count++;
            }
        }
        return count;
    }
    public int overdueCount() {
        int count=0;
        for(History x : patronBorrowingHistory){
            if(x.getStatus()==HistoryStatus.OVERDUE){
                count++;
            }
        }
        return count;
    }
}
