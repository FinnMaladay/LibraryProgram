package assignment3.main.data;

import java.util.List;

import lombok.Value;

@Value public class LibraryData {
    List<LibrarianData> librarians;
    List<MemberData> members;
    //List<MemberData> blockedMembers;
    //CatalogData catalog;
}
