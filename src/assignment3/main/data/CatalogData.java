package assignment3.main.data;

import java.util.List;
import java.util.Map;

import lombok.Value;

/// DON'T NEED TO MAKE ALL DATA IMMUTABLE (i.e if data needs to be frequently updated)

@Value public class CatalogData {
    String type;

    Map<String, BookData> bookByTitle; //given a set string, find book associated to string key
    //List<BookData> Catalog;
}
