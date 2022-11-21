package View;

import java.util.Scanner;

public class UserMenuView implements UserMenuUI{
    static Scanner scannerObj=new Scanner(System.in);
    public  int UserMenuView(){

        int count =1;
        do {
            if(count>1){
                scannerObj.next();
                System.out.println("Enter valid data");
            }
            System.out.println("==========================================="+
                     "\n||           User Features                ||"+
                    "\n============================================"  +
                    "\n||       1. Withdraw                      ||"+
                    "\n||       2. Deposit                       ||"+
                    "\n||       3. Transfer                      ||"+
                    "\n||       4. Apply  Credit Card            ||"+
                    "\n||       5. Apply Debit Card              ||"+
                    "\n||       6. Apply Loan                    ||"+
                    "\n||       7. Change Branch                 ||"+
                    "\n||       8. Delete account                ||"+
                    "\n||       9. Show Transaction History      ||"+
                    "\n||       10. Account status               ||"+
                    "\n||       11. Open Inbox                   ||"+
                    "\n||       12. Balance Enquiry              ||"+
                    "\n||       13. Exit                         ||"+
                    "\n===========================================");

            count++;
        }
        while(!scannerObj.hasNextInt());
        return scannerObj.nextInt();

    }
    public  int accountSelectionView(){
        int count =1;
        do{
            if (count > 1) {
                scannerObj.next();
                System.out.println("Enter valid data");
            }

            System.out.println("\n\n1. Create new Current Account ");
            System.out.println("2. Create new Savings Account");
            System.out.println("3. Link with existing account");
            System.out.println("4. Exit");
            count++;
        }
            while(!scannerObj.hasNextInt());
            return scannerObj.nextInt();
    }
    public  void invalidDataNotification() {
        System.out.println("\nEnter valid data");
    }
}
