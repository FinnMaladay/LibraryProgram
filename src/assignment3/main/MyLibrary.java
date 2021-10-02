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
        
        //Members
        var david = new MemberData("David Lenate", "david@email", "password");
        var nick = new MemberData("Nick Star", "nick@email", "password");
        var tory = new MemberData("Tory Victoria", "tory@email", "password");
        var vickie = new MemberData("Vickie Smyth", "vicke@email", "password");

        //Author

        //Books
        
        // Date set for Librarians and Memebers
        List<LibrarianData> librarians = Arrays.asList(susie, tim, jessica, jeff); 

        List<MemberData> members = Arrays.asList(david, nick, tory, vickie);




        //RQ 1 Two users: Librarian and Member
        //RQ 2 Users log in using email and password

        // Login for a librarian
        // Valid login
        email = "susie@email";


        // Login for a memeber
        // Invalid login


        //RQ 3 Members can borrow book

        //RQ 4

        //RQ 5

        //RQ 6

        //RQ 7

    }

}
