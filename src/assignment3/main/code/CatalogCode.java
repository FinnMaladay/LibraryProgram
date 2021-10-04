package assignment3.main.code;

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

    public static void borrow(){
        
    }

    public static void banUser(){

    }

    public static void unbanUser(){

    }

    public static void displayBooks(){

    }

}
