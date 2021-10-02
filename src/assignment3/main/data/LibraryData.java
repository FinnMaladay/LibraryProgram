package assignment3.main.data;

import java.util.List;

import lombok.val;

@val public class LibraryData {
    List<LibrarianData> librarians;
    List<MemberData> members;
    CatalogData catalog;
}
