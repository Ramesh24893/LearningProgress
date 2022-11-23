package View;
import Model.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ManagerValidationView implements ManagerValidationUI {
    Scanner scannerObj=new Scanner(System.in);

    public String showLoanRequest(LoanForm loanForm) {

        System.out.println("==================================\n"+
                                     loanForm+
                         "\n=================================");
        return validateRequest();
    }
    public String showBranchChangeRequest(BranchChangeForm branchChangeForm) {

        System.out.println("=================================\n"+
                    branchChangeForm+
        "\n=================================");
        return validateRequest();
    }
    public String showDebitCardRequest(DebitCardForm debitCardForm) {
        System.out.println("=================================\n"+
        debitCardForm+
        "\n=================================");
        return validateRequest();
    }
    public String showCreditCardRequest(CreditCardForm creditCardForm) {

        System.out.println("=================================\n"+
        creditCardForm+
        "\n=================================");

        return validateRequest();
    }
    public String validateRequest(){

        String value;
        int count=1;
        do{if(count>1){
            System.out.println("Enter yes or no");
        }
            System.out.println("\nEnter yes to accept request\nEnter no to reject request");
            value=scannerObj.nextLine();
            count++;
        }while(!(value.equalsIgnoreCase("yes")||value.equalsIgnoreCase("no")));
        return value;
    }
    public  void displayAllBranchStats(HashMap<String, Branch> branches) {
        for(Map.Entry<String, Branch> branchMap: branches.entrySet()) {
            Branch branch=branchMap.getValue();
            System.out.println("\n**********************************************"+
            "\nBranch Code       : "+ branch.getBranchCode()+
            "\nBranch Name       : "+ branch.getBranchName()+
            "\nBranch Profit     : "+ branch.getBranchProfit()+
            "\nReserve Amount    : "+ branch.getReserveAmount()+
            "\nAccounts present  : "+ branch.getAccounts().size()+
            "\n**********************************************");
        }
    }
    public void formAcceptedNotification(){
        System.out.println("Application is accepted");
    }
    public void formRejectedNotification(){
        System.out.println("Application is rejected");
    }

    public void noRequestAvailNotification() {
        System.out.println("No Requests received");
    }
}
