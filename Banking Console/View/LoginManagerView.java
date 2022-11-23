package View;
import java.util.Scanner;

public class LoginManagerView implements LoginManagerUI {
    Scanner scannerObject=new Scanner(System.in);

    public String getManagerUserNameForValidation(){
        System.out.println("Enter the Manager username");
        return scannerObject.nextLine();
    }
    public String getManagerPasswordForValidation(){
        System.out.println("Enter the Manager password");
        return scannerObject.nextLine();
    }
    public void invalidManagerLoginNotification(){
        System.out.println("Invalid manager login data");
    }

    public void invalidDataNotification(){
        System.out.println("Enter valid data");
    }

}
