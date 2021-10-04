package assignment3.main.data;

import java.util.List;

import lombok.Value;

@Value public class MemberData {
    String status = "Memeber";
    String name;
    String email;
    String password;
    Boolean isBlocked;
    List<BookLendingData> booksLent;
}
