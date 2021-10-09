package assignment3.main.data;


import lombok.Value;

@Value public class BookLendingData {
    Boolean isOut;
    String lendOutCode;
    // See if there is a way to combine all these
    Integer dueYear;
    Integer dueMonth;
    Integer dueDay;

    Integer lentYear;
    Integer lentMonth;
    Integer lentDay;
}
