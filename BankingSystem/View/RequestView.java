package View;

import Model.*;


import java.util.Scanner;

public class RequestView {
    Scanner scannerObj=new Scanner(System.in);


    public void requestSubmissionNotification(String form){
        switch (form) {
            case "credit":
                System.out.println("\nApplication for credit card submitted");
                break;
            case "debit":
                System.out.println("\nApplication for debit card submitted");
                break;
            case "loan":
                System.out.println("\nApplication for loan submitted");
                break;
            case "branchChange":
                System.out.println("\nApplication for branch Change submitted");
                break;
        }
    }
    public long getLoanAmount() {
        System.out.println("\nEnter the loan amount");
        return scannerObj.nextLong();
    }



    public void invalidRequestNotification(String cardType) {
        if(cardType.equals("credit")){
            System.out.println("\nCredit card access is already available");
        } else if (cardType.equals("debit")) {
            System.out.println("\nDebit card access is already available");
        }
    }
    public String getNewBranchCode(){
        System.out.println("\nEnter the new branch code");
        return scannerObj.nextLine();
    }
}










//    public long getAccountNumberForTermination() {
//        System.out.println("Enter account number for termination");
//        return scannerObj.nextLong();
//    }
//    public void showLoanRequests(LinkedList<LoanForm> forms) {
//        for(LoanForm form: forms){
//            System.out.println("********************");
//            System.out.println(form);
//        }
//    }
//
//    public void showBranchChangeRequests(LinkedList<BranchChangeForm> forms) {
//        for(BranchChangeForm form: forms){
//            System.out.println("********************");
//            System.out.println(form);
//        }
//    }
//
//    public void showDebitCardRequests(LinkedList<DebitCardForm> forms) {
//        for(DebitCardForm form: forms){
//            System.out.println("********************");
//            System.out.println(form);
//        }
//    }
//
//    public void showCreditCardRequests(LinkedList<CreditCardForm> forms) {
//        for(CreditCardForm form: forms){
//            System.out.println("********************");
//            System.out.println(form);
//        }
//
//    }



//    public long getMobileNumber() {
//        System.out.println("Enter mobile number for loan verification");
//        while(!scannerObj.hasNextLong()){
//            System.out.println("Only numbers allowed");
//            System.out.println("Enter mobile number for loan verification");
//            scannerObj.next();
//        }
//        return scannerObj.nextLong();
//    }