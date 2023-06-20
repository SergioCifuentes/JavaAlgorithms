package OnlineBookReader;

import java.util.ArrayList;

public class User {
    private String name;
    private int age;
    private ArrayList<Book> booksSaved;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        booksSaved= new ArrayList<>();
    }
    public void addBookToSaved(Book book){
        booksSaved.add(book);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Book> getBooksSaved() {
        return booksSaved;
    }
    
    
    
}
