package assignment3.main.code;

import java.util.List;

import assignment3.main.data.*;

public class BookLendingCode {
    public static void displayLentBooks(){

    }

    public static Integer bookedLentOut(List<BookItemData> bookSet)
    {
        //check if the book has been lent out at all
        for (BookItemData book : bookSet) {
            
            if(!book.getBookLent().getIsOut())
            {
                return bookSet.indexOf(book);
            }
        }

        return -1;
    }


    public static Boolean isBookOverDue(){
        return false;
    }
}
//Calendar.getInstance().get(Calendar.YEAR);

        // var bookLent = new BookLendingData(true, 2021, 10, 18, 2021, 10, 4);

        // return bookLent;