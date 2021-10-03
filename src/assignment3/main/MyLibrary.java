package assignment3.main;

import java.util.Arrays;
import java.util.List;

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
        
        //Librarians
        var susie = new LibrarianData("Susie Q", "susie@email", "password");
        var tim = new LibrarianData("Tim C", "tim@email", "password");
        var jessica = new LibrarianData("Jessica", "jessica@email", "password");
        var jeff = new LibrarianData("Jeff", "jeff@email", "password");
        
        List<LibrarianData> librarians = List.of(susie, tim, jessica, jeff);
        //Members
        var david = new MemberData("David Lenate", "david@email", "password", false);
        var nick = new MemberData("Nick Star", "nick@email", "password", false);
        var tory = new MemberData("Tory Victoria", "tory@email", "password", true);
        var vickie = new MemberData("Vickie Smyth", "vicke@email", "password",false);

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


        // Library
        
        var library = new LibraryData(librarians, members);


        //library.getLibrarians().
        //RQ 1 Two users: Librarian and Member
        //RQ 2 Users log in using email and password

        // Login for a librarian
        // Valid login
        LibrarianCode.librarianLogin("jessica@email", "password", library.getLibrarians());

        // Login for a memeber
        // valid login
        MemberCode.MemberLogin("david@email", "password", library.getMembers());



        //RQ 3 Members can borrow book

        //RQ 4

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