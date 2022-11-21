package View;

import java.util.Scanner;

public class MainMenuView implements MainMenuUI {

    public int MainMenuView(){
        Scanner scannerObj=new Scanner(System.in);
        int count =1;
        do {
            if(count>1){
                scannerObj.next();
                System.out.println("Enter valid data");
            }
            System.out.println("\n||*******************************************************************************||"+
            "\n||                                                                               ||" +
           "\n||                             1. User                                           ||"+
            "\n||                             2. Manager                                        ||"+
            "\n||                             3. Register User                                  ||"+
            "\n||                             4. Exit                                           ||"+
            "\n||                                                                               ||" +
            "\n||===============================================================================||");
            count++;
        }
        while(!scannerObj.hasNextInt());
        return scannerObj.nextInt();
    }
}
