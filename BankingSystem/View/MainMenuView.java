package View;

import java.util.Scanner;

public class MainMenuView {

    public static  int MainMenuView(){
        Scanner scannerObj=new Scanner(System.in);
        int count =1;
        do {
            if(count>1){
                scannerObj.next();
                System.out.println("Enter valid data");
            }
            System.out.println("**********************************************************************************");
            System.out.println("||                                                                               ||");
            System.out.println("||                                                                               ||");
            System.out.println("||                          WELCOME to ZOHO BANK                                 ||");
            System.out.println("||                                                                               ||");
            System.out.println("||                                                                               ||");
            System.out.println("**********************************************************************************");
            System.out.println("||                                                                               ||" );
            System.out.println("||                             1. User                                           ||");
            System.out.println("||                             2. Admin                                          ||");
            System.out.println("||                             3. Register User                                  ||");
            System.out.println("||                                                                               ||" );
            System.out.println("||===============================================================================||");
            count++;
        }
        while(!scannerObj.hasNextInt());
        return scannerObj.nextInt();
    }
}
