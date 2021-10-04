package assignment3.main.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import assignment3.main.data.*;

//Depends on: LibrarianCode

public class CatalogCode {
    public static void login(){

    }
    public static void search(String type, CatalogData catalog, String name){
        if (type.toLowerCase().equals("title"))
        {
            BookItemCode.searchByTitle(catalog.getBookByTitle(), name);
        }
        else if (type.toLowerCase().equals("author"))
        {
            BookItemCode.searchByAuthor(catalog, name);
        }
    }

    //will need to return book data
    public static void updatedBookData(BookItemData singleBook, LibraryData library, String title)
    {
        /**
        * 
            BookData(List.of(stan.getName(), steve.getName()), List.of(spiderman, spiderman, spiderman));
        */

        //List of authors to current book
        List<String> authors = new ArrayList<String>();
        List<String> listofBooks = new ArrayList<String>();
       
        
        

        authors.addAll(library.getCatalog().getBookByTitle().get(title).getAuthorName());
        
         
    }

    public static LibraryData borrow(LibraryData library, MemberData member, String title){
        
        if(member.getIsBlocked())
        {
            System.out.println(member.getName() + " is blocked from library system");
            return library; //return old library system
        }

        //check that the book in interest hasn't been borrowed yet
        var bookSet = library.getCatalog().getBookByTitle().get(title).getBooks();
        Integer index = BookLendingCode.bookedLentOut(bookSet); //check to see if any copies of desired book are avaliable
        if(index > -1)
        {
            //Create new book lending data
            var bookBorrowed = new BookLendingData(true, 2021, 10, 18, 2021, 10, 4);

            var book = bookSet.get(index);
            //Update Book Item Data
            var updateBook = new BookItemData(title, book.getBookId(), book.getPublishYear(), bookBorrowed);
            updatedBookData(updateBook, library, title);
            //Update Book Data var bookData = 


            //Update Catalog
            //var catalog = new CatalogData("books", Map.of("Spider-Man", copiesofSpiderman, "Avengers", copiesofAvengers), 
            

            //Update Member Data

            

        }else
        {
            System.out.println("All copies of Book have been lent out");
            return library;
        }

        return library;
    }

    public static void banUser(){

    }

    public static void unbanUser(){

    }

    public static void displayCollections(){
        //displays all books and 
    }

}
