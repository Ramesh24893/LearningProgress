import java.util.Scanner;

public class LoginUser {
    Scanner scannerObject=new Scanner(System.in);
    public User loginUser() {

        RailwayDataBase railwayDataBase=new RailwayDataBase();
        Validation validation=new Validation();
        int userId=getUserIdForValidation();

        if(!checkValidUserId(userId)){
            return null;
        }
        String userName=getUserNameForValidation();
        String userPassword=getAdminPasswordForValidation();
        if(!validation.validateUser(userId,userName,userPassword)){
            System.out.println("Enter the valid username and password");
            return null;
        }
        return railwayDataBase.getUser(userId);
    }
    public int getUserIdForValidation(){
        System.out.println("Enter the user ID");
        return scannerObject.nextInt();
    }
    public String getUserNameForValidation(){
        scannerObject.nextLine();
        System.out.println("Enter the user name");
        return scannerObject.nextLine();
    }
    public String getAdminPasswordForValidation(){
        System.out.println("Enter the user password");
        return scannerObject.nextLine();
    }
    public boolean checkValidUserId(int userId){
        RailwayDataBase server=new RailwayDataBase();
        if(!RailwayDataBase.users.containsKey(userId)) {  //Checks whether userId exists in Users database
            System.out.println("No such userId exists");
            return false;
        }
     return true;
    }
}
