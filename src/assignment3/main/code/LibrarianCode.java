package assignment3.main.code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import assignment3.main.data.*;

//Depends on: MemberCode, BookLendingCode, BookItemCode [requires some data/method from them]
public class LibrarianCode extends UserCode{

    public static void librarianLogin(String email, String password, List<LibrarianData> librarians){
        
        for (LibrarianData librarian : librarians) {
            if(login(email, password, librarian.getEmail(), librarian.getPassword()))
            {
                System.out.println(librarian.getStatus() + ": " + librarian.getName());
                return;
            }   
        }
        System.out.println("Invalid email/password for Librarian");
    }
    
    public static LibraryData banUser(LibraryData library, MemberData member){
        
        Map<String, MemberData> bannedUsers = new HashMap<String, MemberData>();
        bannedUsers.putAll(library.getBlockedMembers());
        
        if(!bannedUsers.containsKey(member.getName()))
        {
            bannedUsers.put(member.getName(), member);
            var newLibrary = new LibraryData(library.getLibrarians(), library.getMembers(), bannedUsers, library.getCatalog());
            return newLibrary;
        }
        
        return library;
    }

    public static LibraryData unbanUser(LibraryData library, MemberData member){
        Map<String, MemberData> bannedUsers = new HashMap<String, MemberData>();
        bannedUsers.putAll(library.getBlockedMembers());
        
        if(bannedUsers.containsKey(member.getName()))
        {
            bannedUsers.remove(member.getName());
            var newLibrary = new LibraryData(library.getLibrarians(), library.getMembers(), bannedUsers, library.getCatalog());
            return newLibrary;
        }
        
        return library;
    }

    public static void displayLentBooks(LibraryData library, MemberData member){

        System.out.println("Books borrowed by: " + member.getName() + " :"); 
        var listOfBorrowIdCodes = MemberCode.ListOfBorrowedBooks(member);
        for (Map.Entry<String, BookData> bookCollection : library.getCatalog().getBookByTitle().entrySet()) {
            bookCollection.getValue().getBooks().forEach((book)->{
                for (String borrowID : listOfBorrowIdCodes) {
                    if(book.getBookLent().getLendOutCode().equals(borrowID)){
                        System.out.println(book.getTitle());
                    }
                }
            });
        }
        
    }
}
