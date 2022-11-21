package View;

import Model.Account;
import Model.Branch;


import java.util.*;


public class UserInputView implements UserInputUI {
    Scanner scannerObject=new Scanner(System.in);

    public String getUserNameForValidation(){

        System.out.println("\nEnter the user name");
        return scannerObject.nextLine();

    }

    public String getUserPasswordForValidation(){

        System.out.println("\nEnter the user password");
        return scannerObject.nextLine();

    }

    public void inValidUserNotification(){

        System.out.println("\nEnter the valid username and password");

    }
    public void noSuchUserNotification(){

        System.out.println("\nNo such userId exists");

    }

    public void displayAccountStatus(Account account) {

        System.out.println(account);

    }



    public void displayMessages(LinkedList<String> messages) {

        System.out.println("--------------------------------"+
        "\n----------MESSAGES--------------"+
       "\n--------------------------------");

       if(messages.isEmpty())
           System.out.println("No message received");

       for(String message : messages){

            System.out.println(message);
            System.out.println("\n--------------------------------");
     }
    }
    public   void displayBranches(HashMap<String, Branch> branchesList){

        System.out.println    ("------------------ALL BRANCHES------------------\n\n");

        for (Map.Entry<String, Branch> branches : branchesList.entrySet()) {

            System.out.println("Branch Code :" + branches.getValue().getBranchCode());
            System.out.println("Branch Name :" +branches.getValue().getBranchName());
            System.out.println("----------------------------------------------------");
            System.out.println("----------------------------------------------------\n");

        }
    }

    @Override
    public void displayAvailableBalance(long balance) {

        System.out.println("---------------------------------------"+
                             "Available Balance   : Rs "+ balance+
                           "---------------------------------------");
    }
}
