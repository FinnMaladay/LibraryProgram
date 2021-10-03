package assignment3.main.data;

import lombok.Value;

/// Data for an individual book (Does not include author information)
@Value public class BookItemData {
    String title;
    String bookId;
    Integer publishYear;
    BookLendingData bookLent;
}
