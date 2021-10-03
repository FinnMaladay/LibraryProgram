package assignment3.main.code;

import java.util.List;

import assignment3.main.data.*;

//Depends on: BookItem

public class MemberCode extends UserCode{
    
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

    public static void BorrowBook()
    {
        
    }
}
