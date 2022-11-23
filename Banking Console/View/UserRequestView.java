package View;


import java.util.Scanner;

public class UserRequestView implements UserRequestUI{
    Scanner scannerObj=new Scanner(System.in);
    public void requestSubmissionNotification(String form){
        switch (form) {
            case "credit":
                System.out.println("\nApplication for credit card submitted to Manager");
                break;
            case "debit":
                System.out.println("\nApplication for debit card submitted to Manager");
                break;
            case "loan":
                System.out.println("\nApplication for loan submitted to Manager");
                break;
            case "branchChange":
                System.out.println("\nApplication for branch Change submitted to Manager");
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
        scannerObj.nextLine();
        System.out.println("\nEnter the new branch code");
        return scannerObj.nextLine();
    }


    public void reqAlreadySubmitted() {
        System.out.println("\nApplication is already submitted to Manager");
    }
}
