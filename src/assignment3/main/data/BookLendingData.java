package assignment3.main.data;

import lombok.Value;

@Value public class BookLendingData {
    Boolean isOut;
    Integer dueDate;
    Integer dataLent;
    String bookId;
}
