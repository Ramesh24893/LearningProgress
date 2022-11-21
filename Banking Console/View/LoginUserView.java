package View;

import Model.User;

import java.util.Scanner;

public class LoginUserView implements LoginUserUI{
    Scanner scannerObject=new Scanner(System.in);

    public String getUserNameForValidation(){

        System.out.println("\nEnter the user name");
        return scannerObject.nextLine();

    }

    public String getUserPasswordForValidation(){

        System.out.println("\nEnter the user password");
        return scannerObject.nextLine();

    }
    public void userRegisteredNotification(User user){

        System.out.println("\nYour account is created\nACCOUNT DETAILS");
        System.out.println(user);

    }
    public void inValidUserNotification(){

        System.out.println("\nEnter the valid username and password");

    }
    public void noSuchUserNotification(){

        System.out.println("\nNo such userId exists");

    }

}
