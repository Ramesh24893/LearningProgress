package View;

import Model.Account;
import Model.Branch;
import Model.User;

import java.util.*;

public class UserView{
    Scanner scannerObject=new Scanner(System.in);
    public int getUserIdForValidation(){
        System.out.println("\nEnter the user ID");
        while(!scannerObject.hasNextInt()){
            System.out.println("\nuser id exists only in integer");
            System.out.println("\nEnter the user ID");
            scannerObject.next();
        }
        return scannerObject.nextInt();
    }
    public String getUserNameForValidation(){
        scannerObject.nextLine();
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
    public String getNewUserName() {
        System.out.println("\nEnter the new username ");
        return  scannerObject.nextLine();
    }

    public String getNewPassword() {
        System.out.println("\nEnter the password");
        return scannerObject.nextLine();
    }



    public void displayNotification(String message) {
        System.out.println(message);
    }

    public void displayAccountStatus(Account account) {
        System.out.println(account);
    }

    public void displayMessages(LinkedList<String> messages) {
        System.out.println("--------------------------------"+
        "\n----------MESSAGES--------------"+
       "\n--------------------------------");
        for(String message : messages){
            System.out.println(message);
         System.out.println("--------------------------------");
     }
    }
    public   void displayBranches(HashMap<String, Branch> branchesList){
        System.out.println    ("\n\n------------------ALL BRANCH STATS------------------");
        for (Map.Entry<String, Branch> branches : branchesList.entrySet()) {
            System.out.println("\n\nBranch Code :" + branches.getValue().getBranchCode());
            System.out.println("Branch Name :" +branches.getValue().getBranchName());
            System.out.println("----------------------------------------------------");
            System.out.println("----------------------------------------------------");
        }
    }

}





//    public void showTransactionHistory(ArrayList<String> transactions){
//        for(String transaction: transactions){
//            System.out.println(transaction);
//            System.out.println("***********************");
//        }
//    }

//    public int getAmountForWithdraw(){
//        System.out.println("Enter the withdraw amount");
//        return scannerObject.nextInt();
//    }
//
//    public long getAccNumber(){
//        System.out.println("Enter the receiver Account number");
//        return scannerObject.nextLong();
//    }
//
//    public int getAmountForDeposit(){
//        System.out.println("Enter teh withdraw amount");
//        return scannerObject.nextInt();
//    }





//    public String getPanNumber() {
//        System.out.println("Enter the Pan Number");
//        return scannerObject.nextLine();
//    }