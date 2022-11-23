package View;

import Model.User;
import java.util.Scanner;


public class UserRegistrationView implements UserRegistrationUI{
    Scanner scannerObject=new Scanner(System.in);
    Validation validObj=new Validation();

    public String getNewUserName(){

        System.out.println("Enter the new username");
        String name;
        int count=1;
        do{
            if(count>1){
                System.out.println("Enter the valid user name");
                System.out.println("1. User name can be alphanumeric\n2. start with alphabet and range of letters 8 to 30 \n3.Allowed special characters @,_ ");

            }
            name=scannerObject.nextLine();
            count++;
        }
        while(!validObj.validateUserName(name));
        return name;

    }
    public String getNewPassword(){

        System.out.println("Enter the new password");
        String name;
        int count=1;
        do{
            if(count>1){
                System.out.println("Enter the valid password");
                System.out.println("Length of password greater than 8");

            }
            name=scannerObject.nextLine();
            count++;
        }
        while(!validObj.validatePassword(name));
        return name;

    }
    public void userRegisteredNotification(User user){

        System.out.println("\nYour account is created\nACCOUNT DETAILS");
        System.out.println(user);

    }

    public void userIdExistNotification() {
        System.out.println("\nUser Id already exists");
    }


}
