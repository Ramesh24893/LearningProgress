import java.util.Scanner;

public class Registration {
    public void registerUser(){
        Scanner sc=new Scanner(System.in);
        sc.nextLine();
        System.out.println("Enter the new username ");
        String newUserName = sc.nextLine();
        System.out.println("Enter the password");
        String password = sc.nextLine();
        User user=new User(newUserName,password);
        RailwayDataBase.users.put(user.getUserId(),user);
        System.out.println("Your account is created\nACCOUNT DETAILS");
        System.out.println(user);
    }
}
