package assignment3.main.data;

import java.util.Calendar;

import lombok.Value;

@Value public class BookLendingData {
    Boolean isOut;

    // See if there is a way to combine all these
    Integer dueYear;
    Integer dueMonth;
    Integer dueDay;

    Integer lentYear;
    Integer lentMonth;
    Integer lentDay;

    String bookId; 
}
