package View;

import java.util.Scanner;

public class MangerMenuView implements ManagerMenuUI {
    public int ManagerMenuView(){
        Scanner scannerObj=new Scanner(System.in);
        int count =1;
        do {
            if(count>1){
                scannerObj.next();
                System.out.println("Enter valid data");
            }
            System.out.println("\n\n=============================================="+
                    "\n||           Manager Features                ||"+
                    "\n==============================================="  +
                    "\n||       1. Show Branches stats              ||"+
                    "\n||       2. Validate credit card requests    ||"+
                    "\n||       3. Validate debit card requests     ||"+
                    "\n||       4. Validate loan requests           ||"+
                    "\n||       5. Validate branch change requests  ||"+
                    "\n||       6. Exit                             ||"+
                    "\n===============================================");
            count++;
        }
        while(!scannerObj.hasNextInt());
        return scannerObj.nextInt();
    }
}











