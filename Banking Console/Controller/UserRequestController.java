package Controller;

import Data.BankDataBase;
import Model.*;
import View.UserRequestUI;


public class UserRequestController {

    private BankDataBase bankDataObj;
    private UserRequestUI userRequestUI;

    public UserRequestController( BankDataBase bankDataObj, UserRequestUI userRequestUI) {

        this.bankDataObj = bankDataObj;
        this.userRequestUI = userRequestUI;
        this.managerObj=bankDataObj.getManager();
    }
    Manager managerObj;

    void applyForCreditCard(Account account, User userObj) {
        if(managerObj.getCreditCardsReq().containsKey(userObj.getUserId())){
            userRequestUI.reqAlreadySubmitted();
            return;
        }
        if (account.getCreditCard() == null) {

            CreditCardForm generatedForm = generateCreditCardForm(account, userObj.getUserId());
            submitCreditCardForm(generatedForm, userObj.getUserId());
            userRequestUI.requestSubmissionNotification("credit");
            userObj.getMessages().add("Your application for credit card is submitted");

        }
        else
        {
            userRequestUI.invalidRequestNotification("credit");
        }
    }

     void applyForDebitCard(Account account, User userObj) {
        if(managerObj.getDebitCardsReq().containsKey(userObj.getUserId())){
            userRequestUI.reqAlreadySubmitted();
            return;
        }
        if (account.getDebitCard() == null) {

            DebitCardForm generatedForm = generateDebitCardForm(account, userObj.getUserId());
            submitDebitCardForm(generatedForm, userObj.getUserId());
            userRequestUI.requestSubmissionNotification("debit");
            userObj.getMessages().add("Your application for debit card is submitted");
        }
        else {

            userRequestUI.invalidRequestNotification("debit");
        }
    }
     void applyForLoan(Account account, User userObj) {
        if(managerObj.getLoansReq().containsKey(userObj.getUserId())){
            userRequestUI.reqAlreadySubmitted();
            return;
        }

        LoanForm generatedLoanForm = generateLoanForm(account, userObj.getUserId());
        submitLoanForm(generatedLoanForm, userObj.getUserId());
        userRequestUI.requestSubmissionNotification("loan");
        userObj.getMessages().add("Application for loan is submitted");

    }
    void applyForBranchChange(Account account, User userObj) {
        if(managerObj.getBranchChangeReq().containsKey(userObj.getUserId())){
            userRequestUI.reqAlreadySubmitted();
            return;
        }

        long accountNumber = account.getAccountNumber();
        String currentBranchCode = account.getBranchCode();
        String newBranchCode = userRequestUI.getNewBranchCode();
        BranchChangeForm branchChangeForm = generateBranchChangeForm(accountNumber, currentBranchCode, newBranchCode, userObj.getUserId());
        submitBranchChangeForm(branchChangeForm, userObj.getUserId());
        userRequestUI.requestSubmissionNotification("branchChange");
        userObj.getMessages().add("Application for branch change is submitted");

    }

    private CreditCardForm generateCreditCardForm(Account account, String userName) {

        long accNum = account.getAccountNumber();
        String branchCode = account.getBranchCode();
        String accHolderName = account.getAccHolderName();
        return new CreditCardForm(accNum, branchCode, account.getAccountType(), accHolderName, userName);

    }

    private DebitCardForm generateDebitCardForm(Account account, String userId) {

        long accNum = account.getAccountNumber();
        String branchCode = account.getBranchCode();
        String accHolderName = account.getAccHolderName();
        return new DebitCardForm(accNum, branchCode, account.getAccountType(), accHolderName, userId);

    }
    private LoanForm generateLoanForm(Account account, String userId) {

        long amount = userRequestUI.getLoanAmount();

        return new LoanForm(account.getAccountNumber(), account.getBranchCode(), amount, userId);
    }
    private BranchChangeForm generateBranchChangeForm(long accountNumber, String currentBranchCode, String newBranchCode, String userId) {

        return new BranchChangeForm(accountNumber, currentBranchCode, newBranchCode, userId);

    }


    private void submitLoanForm(LoanForm generatedLoanForm,String userId) {

        managerObj.getLoansReq().put(userId,generatedLoanForm);

    }
    private void submitBranchChangeForm(BranchChangeForm branchChangeForm,String userId) {

        managerObj.getBranchChangeReq().put(userId,branchChangeForm);

    }
    private void submitCreditCardForm(CreditCardForm generatedCreditCardForm,String userId){

        managerObj.getCreditCardsReq().put(userId,generatedCreditCardForm);

    }
    private void submitDebitCardForm(DebitCardForm generatedDebitCardForm,String userId){

        managerObj.getDebitCardsReq().put(userId,generatedDebitCardForm);

    }

}
