import java.util.Scanner;

public class LoginAdmin {
    Scanner scannerObject=new Scanner(System.in);
    public boolean loginAdmin(){
        Validation validation=new Validation();
        if (!validation.validateAdmin(getAdminUserNameForValidation(), getAdminPasswordForValidation() )){
            System.out.println("Enter the valid username and password");
            return true;
        }
        return false;
    }
    public String getAdminUserNameForValidation(){
        System.out.println("Enter the Admin username");
        return scannerObject.nextLine();
    }
    public int getAdminPasswordForValidation(){
        System.out.println("Enter the Admin password");
        return scannerObject.nextInt();
    }
}
