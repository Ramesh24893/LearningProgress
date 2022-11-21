package Controller;

import Data.BankDataBase;
import Model.*;
import View.UserRequestUI;


public class UserRequestController {

    BankDataBase bankDataObj;
    UserRequestUI requestViewObj;

    public UserRequestController( BankDataBase bankDataObj, UserRequestUI requestViewObj) {

        this.bankDataObj = bankDataObj;
        this.requestViewObj = requestViewObj;
        this.managerObj=bankDataObj.getManager();
    }
    Manager managerObj;

    public void applyForCreditCard(Account account, User userObj) {

        if (account.getCreditCard() == null) {

            CreditCardForm generatedForm = generateCreditCardForm(account, userObj.getUserId());
            submitCreditCardForm(generatedForm);
            requestViewObj.requestSubmissionNotification("credit");
            userObj.getMessages().add("Your application for credit card is submitted");

        }
        else
        {
            requestViewObj.invalidRequestNotification("credit");
        }
    }

    public void applyForDebitCard(Account account, User userObj) {

        if (account.getDebitCard() == null) {

            DebitCardForm generatedForm = generateDebitCardForm(account, userObj.getUserId());
            submitDebitCardForm(generatedForm);
            requestViewObj.requestSubmissionNotification("debit");
            userObj.getMessages().add("Your application for debit card is submitted");
        }
        else {

            requestViewObj.invalidRequestNotification("debit");
        }
    }
    public void applyForLoan(Account account, User userObj) {

        LoanForm generatedLoanForm = generateLoanForm(account, userObj.getUserId());
        submitLoanForm(generatedLoanForm);
        requestViewObj.requestSubmissionNotification("loan");
        userObj.getMessages().add("Application for loan is submitted");

    }
    public void applyForBranchChange(Account account, User userObj) {

        long accountNumber = account.getAccountNumber();
        String currentBranchCode = account.getBranchCode();
        String newBranchCode = requestViewObj.getNewBranchCode();
        BranchChangeForm branchChangeForm = generateBranchChangeForm(accountNumber, currentBranchCode, newBranchCode, userObj.getUserId());
        submitBranchChangeForm(branchChangeForm);
        requestViewObj.requestSubmissionNotification("branchChange");
        userObj.getMessages().add("Application for branch change is submitted");

    }

    public CreditCardForm generateCreditCardForm(Account account, String userName) {

        long accNum = account.getAccountNumber();
        String branchCode = account.getBranchCode();
        String accHolderName = account.getAccHolderName();
        return new CreditCardForm(accNum, branchCode, account.getAccountType(), accHolderName, userName);

    }

    public DebitCardForm generateDebitCardForm(Account account, String userId) {

        long accNum = account.getAccountNumber();
        String branchCode = account.getBranchCode();
        String accHolderName = account.getAccHolderName();
        return new DebitCardForm(accNum, branchCode, account.getAccountType(), accHolderName, userId);    /// why generate form method

    }
    public LoanForm generateLoanForm(Account account, String userId) {

        long amount = requestViewObj.getLoanAmount();

        return new LoanForm(account.getAccountNumber(), account.getBranchCode(), amount, userId);
    }
    public BranchChangeForm generateBranchChangeForm(long accountNumber, String currentBranchCode, String newBranchCode, String userId) {

        return new BranchChangeForm(accountNumber, currentBranchCode, newBranchCode, userId);

    }


    public void submitLoanForm(LoanForm generatedLoanForm) {

        managerObj.getLoansReq().add(generatedLoanForm);

    }
    public void submitBranchChangeForm(BranchChangeForm branchChangeForm) {

        managerObj.getBranchChangeReq().add(branchChangeForm);

    }
    public void submitCreditCardForm(CreditCardForm generatedCreditCardForm){

        managerObj.getCreditCardsReq().add(generatedCreditCardForm);

    }
    public void submitDebitCardForm(DebitCardForm generatedDebitCardForm){

        managerObj.getDebitCardsReq().add(generatedDebitCardForm);

    }

}
