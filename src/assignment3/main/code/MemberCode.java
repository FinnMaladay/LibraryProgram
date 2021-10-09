package assignment3.main.code;

import java.util.ArrayList;
import java.util.List;

import assignment3.main.data.*;

//Depends on: BookItem

public class MemberCode extends UserCode{
    

    public static MemberData MemberInfo(LibraryData library, String name)
    {
        Integer index = -1;
        for (var members : library.getMembers()) {
            if(members.getName().equals(name)){
                index = library.getMembers().indexOf(members);
                break;
            }
        }
        return library.getMembers().get(index);
    }

    public static void MemberLogin(String email, String password, List<MemberData> members){

        for (MemberData member : members) {
            if(login(email, password, member.getEmail(), member.getPassword()))
            {
                System.out.println(member.getStatus() + ": " + member.getName());
                return;
            }
        }
        System.out.println("Invalid email/password for memeber");
    }

    public static List<MemberData> UpdateMember(MemberData member, BookLendingData bookBorrowed, LibraryData library)
    {
        //Update the info users in Library
        

        List<BookLendingData> userBorrowedBooks = new ArrayList<BookLendingData>();
        userBorrowedBooks.addAll(member.getBooksLent());
        userBorrowedBooks.add(bookBorrowed);

        
        var newMember = new MemberData(member.getName(), member.getEmail(), member.getPassword(), member.getIsBlocked(), userBorrowedBooks);
        
        List<MemberData> newMemberList = new ArrayList<MemberData>();
        newMemberList.addAll(library.getMembers());
        Integer memberIndex = newMemberList.indexOf(member);
        newMemberList.set(memberIndex, newMember);
        
        return newMemberList;
    }
}
