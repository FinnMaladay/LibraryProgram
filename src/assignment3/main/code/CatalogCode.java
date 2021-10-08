package assignment3.main.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static LibraryData borrow(LibraryData library, MemberData member, String title){
        
        if(member.getIsBlocked()) //if the member searching is blocked...
        {
            System.out.println(member.getName() + " is blocked from library system");
            return library; //...return current library system
        }

        //check that the book in interest hasn't been borrowed yet
        var bookSet = library.getCatalog().getBookByTitle().get(title).getBooks(); //get current set of copies for book
        Integer index = BookLendingCode.bookedLentOut(bookSet); //check to see if any copies of desired book are avaliable
        if(index > -1) // if index returns -1, no copies are valiable 
        {
            //Create new book lending data
            var bookBorrowed = new BookLendingData(true, 2021, 10, 18, 2021, 10, 4);

            var book = bookSet.get(index);
            //Update Book Item Data
            var updateBookItemData = new BookItemData(title, book.getBookId(), book.getPublishYear(), bookBorrowed);
            
            //Update Book Data (update list of copies)
            var updateBookData = BookLendingCode.updatedBookData(updateBookItemData, library, title, index);

            //Update Catalog
            // Find Map with Key = title, replace data with updateBookData
            library.getCatalog().getBookByTitle().replace(title, updateBookData);

            // BookId need to be updated as well
            String bookId = bookSet.get(0).getBookId();
            library.getCatalog().getBookById().replace(bookId, updateBookData);

            //Update Member Data
            var newMemberList = MemberCode.UpdateMember(member, bookBorrowed, library);
            
            //Update Library and Return new Library
            var newLibrary = new LibraryData(library.getLibrarians(), newMemberList, library.getBlockedMembers(), library.getCatalog());
            return newLibrary;
            
        }else
        {
            System.out.println("All copies of Book have been lent out");
            return library;
        }

    }

    public static void banUser(){

    }

    public static void unbanUser(){

    }

    public static void displayCollections(){
        //displays all books and 
    }

}
