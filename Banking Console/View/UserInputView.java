package View;

import Model.Account;
import Model.Branch;


import java.util.*;


public class UserInputView implements UserInputUI {

    public void displayAccountStatus(Account account) {

        System.out.println(account);

    }
    public void displayMessages(LinkedList<String> messages) {

        System.out.println("-------------------------------------------------"+
                         "\n-----------------------MESSAGES------------------"+
                         "\n-------------------------------------------------");

       if(messages.isEmpty())
           System.out.println("No message received");

       for(String message : messages){

            System.out.println(message);
            System.out.println("\n--------------------------------");
     }
    }
    public   void displayBranches(HashMap<String, Branch> branchesList){

        System.out.println    ("------------------ALL BRANCHES------------------\n");

        for (Map.Entry<String, Branch> branches : branchesList.entrySet()) {

            System.out.println("Branch Code :" + branches.getValue().getBranchCode());
            System.out.println("Branch Name :" +branches.getValue().getBranchName());
            System.out.println("----------------------------------------------------\n");

        }
    }
    public void displayAvailableBalance(long balance) {

        System.out.println("---------------------------------------"+
                             "\n         Available Balance   : Rs "+ balance+
                           "\n---------------------------------------");
    }
}
