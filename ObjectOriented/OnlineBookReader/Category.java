package OnlineBookReader;

import java.util.ArrayList;

public class Category {
    private String name;
    private String description;
    private ArrayList<Book> books;
    public Category(String name, String description) {
        this.name = name;
        this.description = description;
        books=new ArrayList<Book>();
    }
    public void addBook(Book book){
        books.add(book);
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public ArrayList<Book> getBooks() {
        return books;
    }
    
}
