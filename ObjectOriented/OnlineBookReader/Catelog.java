package OnlineBookReader;

import java.util.ArrayList;

public class Catelog {
    private ArrayList<Category> categories=new ArrayList<Category>();
    private ArrayList<Book> books= new ArrayList<Book>();

    public ArrayList<Category> getCategories() {
        return categories;
    }
    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Book> findBookByTitle(String title){
        return null;
    }
    public ArrayList<Category> findCategoryByName(String name){
        return null;
    }
    public ArrayList<Book> findBooksByAuthor(String author){
        return null;
    }

    
}
