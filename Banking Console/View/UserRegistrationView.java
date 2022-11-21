package View;

import Model.User;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistrationView implements UserRegistrationUI{
    Scanner scannerObject=new Scanner(System.in);

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
        while(!validateUserName(name));
        return name;

    }
    public String getNewPassword(){

        System.out.println("Enter the new password");
        String name;
        int count=1;
        do{
            if(count>1){
                System.out.println("Enter the valid password");
                System.out.println("Length of password 8 to 30.\n" +
                        "Must contain at least one digit,one upper case and lower case alphabet.\n" +
                        "Allowed special characters !@#$%&*()-+=^.\n");

            }
            name=scannerObject.nextLine();
            count++;
        }
        while(!validateUserName(name));
        return name;

    }
    public void userRegisteredNotification(User user){

        System.out.println("\nYour account is created\nACCOUNT DETAILS");
        System.out.println(user);

    }

    public boolean validatePassword(String name){

        Pattern pattern=Pattern.compile("^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$");

        Matcher matcher= pattern.matcher(name);
        return matcher.matches();

    }
    public boolean validateUserName(String name){

        Pattern pattern=Pattern.compile("^[A-Za-z][A-Za-z0-9_@]{7,29}$");
        Matcher matcher= pattern.matcher(name);
        return matcher.matches();

    }
}
