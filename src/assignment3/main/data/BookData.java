package assignment3.main.data;

import java.util.List;

import lombok.Value;

//collection of a single book and it's authors
@Value public class BookData {
    List<String> authorName;
    List<BookItemData> books;
}
