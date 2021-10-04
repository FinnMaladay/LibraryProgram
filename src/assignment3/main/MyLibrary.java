package assignment3.main;

import java.util.List;
import java.util.Map;

import assignment3.main.code.*;
import assignment3.main.data.*;


public class MyLibrary {
    
    public static String name;
    public static String email;


    public static Boolean loggedIn;
    public static String currentUser;
    public static String currentUserStatus = "Guest";

    public static void main(String[] args) {

        //Test Data
        //Empty data: for default data (e.g BookLendingData when a book hasn't been lent or when a user hasn't borrowed a book)
        var bookNotBorrow = new BookLendingData(false, 0, 0, 0, 0, 0, 0);// default data for when a book hasn't been loaned out
        var bookBorrowed = new BookLendingData(true, 2021, 10, 18, 2021, 10, 4);// default data for when a book has been loaned out
        List<BookLendingData> borrowedBooks = List.of();
        Map<String, MemberData> blockedMembers = Map.of();

        //Librarians
        var susie = new LibrarianData("Susie Q", "susie@email", "password");
        var tim = new LibrarianData("Tim C", "tim@email", "password");
        var jessica = new LibrarianData("Jessica", "jessica@email", "password");
        var jeff = new LibrarianData("Jeff", "jeff@email", "password");
        
        List<LibrarianData> librarians = List.of(susie, tim, jessica, jeff);
        //Members
        var david = new MemberData("David Lenate", "david@email", "password", false, borrowedBooks);
        var nick = new MemberData("Nick Star", "nick@email", "password", false, borrowedBooks);
        var tory = new MemberData("Tory Victoria", "tory@email", "password", true, borrowedBooks);
        var vickie = new MemberData("Vickie Smyth", "vicke@email", "password",false, borrowedBooks);

        List<MemberData> members = List.of(david, nick, tory, vickie);
        //BookIDs
        String spidermanBookId = "900012-3124"; //authors: Stan Lee, Steve Ditko; 
        String avengersBookId = "900012-3202"; //authors: Stan Lee
        String sherlockBookId = "900012-1023"; //authors: Arthur Conan Doyle
        String winneBookId = "900012-0001"; //authors: A. A. Milne
        String myheroBookId = "900012-2200"; //authors: Kohei Horikoshi
        String designPatternBookId = "900012-0044"; //authors: Erich Gamma; Richard Helm; Ralph Johnson · John Vlissides
        String flashBookId = "900012-1101"; //authors: Jeremy Adams 
        String stripedPyjamas = "900012-1303"; //authors: John Boyne

        //Author
        var stan = new AuthorData("Stan-Lee", List.of(spidermanBookId, avengersBookId));
        var steve = new AuthorData("Steve-Ditko", List.of(spidermanBookId));

        //Books
        var spiderman = new BookItemData("Spider-Man", spidermanBookId, 1965, bookNotBorrow);
        var copiesofSpiderman = new BookData(List.of(stan.getName(), steve.getName()), List.of(spiderman, spiderman, spiderman));
        var avengers = new BookItemData("Avengers", avengersBookId, 1963, bookNotBorrow);
        var copiesofAvengers = new BookData(List.of(stan.getName()), List.of(avengers));

        // Library
        var catalog = new CatalogData("books", Map.of("Spider-Man", copiesofSpiderman, "Avengers", copiesofAvengers), 
        Map.of(spidermanBookId, copiesofSpiderman, avengersBookId, copiesofAvengers), 
        Map.of("Stan-Lee", stan, "Steve-Ditko", steve));

        var library = new LibraryData(librarians, members, blockedMembers, catalog);


        
        //RQ 1 Two users: Librarian and Member
        //RQ 2 Users log in using email and password

        // Login for a librarian
        // Valid login
        LibrarianCode.librarianLogin("jessica@email", "password", library.getLibrarians());

        // Login for a memeber
        // valid login
        MemberCode.MemberLogin("david@email", "password", library.getMembers());



        //RQ 3 Members can borrow book
        //must ensure that it is a member who is logged in to allow for a borrowed book
        currentUser = nick.getName();
        loggedIn = true;
        currentUserStatus = nick.getStatus();
        if(loggedIn && currentUserStatus.toLowerCase().equals("member"))
        {
            library = CatalogCode.borrow(library, nick, "Spider-Man");
        }
        else{
            System.out.println("Current user is not a Member: please log in as a member");
        }
        

        

        //RQ 4 Librarians and Members can Search for books
        // Search by title
        CatalogCode.search("title", catalog, "Spider-Man");

        // Search by Author
        CatalogCode.search("author", catalog, "Stan-Lee");


        //RQ 5

        //RQ 6

        //RQ 7 Multiple books can exist

        // print out entire library to show the multiple copies of a book exists
        

    }

}

/***Developer notes
 * 
 * var david = new MemberData("David Lenate", "david@email", "password", false);

        var nick = new MemberData("Nick Star", "nick@email", "password", false);
        david = nick; //can use this for overwritten immutable data (without needing to make Data classes mutable)
 */