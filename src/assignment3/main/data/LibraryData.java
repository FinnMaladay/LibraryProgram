package assignment3.main.data;

import java.util.List;
import java.util.Map;

import lombok.Value;

@Value public class LibraryData {
    List<LibrarianData> librarians;
    List<MemberData> members;
    Map<String, MemberData> blockedMembers;
    CatalogData catalog;
}
