package assignment3.main.code;

import java.util.Map;
import java.util.function.Consumer;

import assignment3.main.data.*;

public class BookItemCode {
    
    public static void searchByTitle(Map<String, BookData> bookByTitle, String title)
    {
        var book = bookByTitle.get(title);
        var bookTitle = book.getBooks().get(0).getTitle();

        var yearPublished = book.getBooks().get(0).getPublishYear();
        System.out.println(bookTitle + ", Published: " + yearPublished + ", authors: ");
        book.getAuthorName().forEach( (name)->{System.out.println(name);} );
    }

    public static void searchByAuthor(CatalogData catalog, String author)
    {
        var bookID = catalog.getAuthorByName().get(author).getBookIds();
    }
}
