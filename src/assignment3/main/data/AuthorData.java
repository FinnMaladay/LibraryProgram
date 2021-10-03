package assignment3.main.data;

import java.util.List;

import lombok.Value;

@Value public class AuthorData {
    String name;
    List<String> BookIds;
}
