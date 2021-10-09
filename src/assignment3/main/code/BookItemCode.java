package assignment3.main.code;

import java.util.Arrays;
import java.util.Map;

import assignment3.main.data.*;

public class BookItemCode {
    
    public static void searchByTitle(Map<String, BookData> bookByTitle, String title)
    {
        try {
            System.out.println(bookByTitle.get(title).getBooks().get(0).getTitle() +
            ", published: " + bookByTitle.get(title).getBooks().get(0).getPublishYear() +
            " Authors: " + Arrays.toString(bookByTitle.get(title).getAuthorName().toArray()).toUpperCase());
        } catch (Exception e) {
            System.out.println(title + " does not exist in library system");
        }
        
    }

    public static void searchByAuthor(CatalogData catalog, String author)
    {
        try {
            
            System.out.println("Books authored by: " + catalog.getAuthorByName().get(author).getName());
            for (String book : catalog.getAuthorByName().get(author).getBookIds()) {
                System.out.println(catalog.getBookById().get(book).getBooks().get(0).getTitle().toUpperCase());
            }
            
        } catch (Exception e) {
            System.out.println(author + " does not exist in library system");
        }  
    }
}
