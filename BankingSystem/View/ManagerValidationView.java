package View;

import Model.BranchChangeForm;
import Model.CreditCardForm;
import Model.DebitCardForm;
import Model.LoanForm;

import java.util.Scanner;

public class ManagerValidationView {
    Scanner scannerObj=new Scanner(System.in);

    public String showLoanRequest(LoanForm loanForm) {

        System.out.println("********************");
        System.out.println(loanForm);
        System.out.println("********************");
        return validateRequest();
    }


    public String showBranchChangeRequest(BranchChangeForm branchChangeForm) {

        System.out.println("********************");
        System.out.println( branchChangeForm);
        System.out.println("********************");
        return validateRequest();


    }

    public String showDebitCardRequest(DebitCardForm debitCardForm) {

        System.out.println("********************");
        System.out.println(debitCardForm);
        System.out.println("********************");
        return validateRequest();

    }

    public String showCreditCardRequest(CreditCardForm creditCardForm) {

        System.out.println("********************");
        System.out.println(creditCardForm);
        System.out.println("********************");

        return validateRequest();
    }

    public String validateRequest(){

        String value;
        int count=1;
        do{if(count>1){
            System.out.println("Enter yes or no");
        }
            System.out.println("Enter yes to accept request");
            System.out.println("Enter no to reject request");
            value=scannerObj.nextLine();
            count++;
        }while(!(value.equalsIgnoreCase("yes")||value.equalsIgnoreCase("no")));
        return value;
    }
}
