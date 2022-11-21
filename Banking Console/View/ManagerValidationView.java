package View;

import Model.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ManagerValidationView implements ManagerValidationUI {
    Scanner scannerObj=new Scanner(System.in);

    public String showLoanRequest(LoanForm loanForm) {

        System.out.println("==================================");
        System.out.println(loanForm);
        System.out.println("=================================");
        return validateRequest();
    }
    public String showBranchChangeRequest(BranchChangeForm branchChangeForm) {

        System.out.println("=================================");
        System.out.println( branchChangeForm);
        System.out.println("=================================");
        return validateRequest();
    }
    public String showDebitCardRequest(DebitCardForm debitCardForm) {
        System.out.println("=================================");
        System.out.println(debitCardForm);
        System.out.println("=================================");
        return validateRequest();
    }
    public String showCreditCardRequest(CreditCardForm creditCardForm) {

        System.out.println("=================================\n");
        System.out.println(creditCardForm);
        System.out.println("\n=================================");

        return validateRequest();
    }
    public String validateRequest(){

        String value;
        int count=1;
        do{if(count>1){
            System.out.println("Enter yes or no");
        }
            System.out.println("\nEnter yes to accept request");
            System.out.println("Enter no to reject request");
            value=scannerObj.nextLine();
            count++;
        }while(!(value.equalsIgnoreCase("yes")||value.equalsIgnoreCase("no")));
        return value;
    }
    public  void displayAllBranchStats(HashMap<String, Branch> branches) {
        for(Map.Entry<String, Branch> branchMap: branches.entrySet()) {
            Branch branch=branchMap.getValue();
            System.out.println("\n**********************************************");
            System.out.println("Branch Code       : "+ branch.getBranchCode());
            System.out.println("Branch Name       : "+ branch.getBranchName());
            System.out.println("Branch Profit     : "+ branch.getBranchProfit());
            System.out.println("Reserve Amount    : "+ branch.getReserveAmount());
            System.out.println("Accounts present  : "+ branch.getAccounts().size());
            System.out.println("**********************************************");
        }
    }
    public void formAcceptedNotification(){
        System.out.println("Application is accepted");
    }
    public void formRejectedNotification(){
        System.out.println("Application is rejected");
    }

}
