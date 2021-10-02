package assignment3.main.code;

public class UserCode {

    public static Boolean login(String email, String password, String emails, String passwords)
    {
        
        if(emails.equals(email) & passwords.equals(password))
        {
            return true;
        }
        else
        {
            return false;
        }
    } 

}
