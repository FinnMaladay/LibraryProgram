package assignment3.main.data;

import java.util.Map;

import lombok.Value;

/// DON'T NEED TO MAKE ALL DATA IMMUTABLE (i.e if data needs to be frequently updated)

@Value public class CatalogData {
    String type;

    Map<String, BookData> bookByTitle; //given a string title, find book associated to string key
    Map<String, BookData> bookById; //give an id value, find book associated to it (used for search by author)
    Map<String, AuthorData> authorByName; //given a string name, find author associated to string key
}
