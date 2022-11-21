package Controller;
import Data.BankDataBase;
import Model.*;
import View.ManagerValidationView;
import java.time.LocalDate;
import java.util.LinkedList;

public class ManagerController {


    BankDataBase bankDataBaseObj;
    ManagerValidationView managerValidViewObj;

    Manager managerObj;
    public ManagerController(BankDataBase bankDataBaseObj, ManagerValidationView managerValidViewObj) {

        this.bankDataBaseObj = bankDataBaseObj;
        this.managerValidViewObj = managerValidViewObj;
        this.managerObj=bankDataBaseObj.getManager();

    }

    public void displayBranchStats(){

        managerValidViewObj.displayAllBranchStats(bankDataBaseObj.getBranches());
    }
    public void validateCreditCardRequests(){

        LinkedList<CreditCardForm> creditCardReq= managerObj.getCreditCardsReq();

        for(CreditCardForm creditCardForm: creditCardReq){

            User user=bankDataBaseObj.getUsers().get(creditCardForm.getUserId());

            if(managerValidViewObj.showCreditCardRequest(creditCardForm).equalsIgnoreCase("yes")) {

                long accountNumber = creditCardForm.getAccNum();
                generateCreditCard(bankDataBaseObj.getAccounts().get(accountNumber));
                user.getMessages().add("Application for credit card is accepted");
                managerValidViewObj.formAcceptedNotification();
                creditCardReq.remove(creditCardForm);

            }
            else
            {
                user.getMessages().add("Application for credit card is rejected");
                managerValidViewObj.formRejectedNotification();
            }
        }
    }

    public void validateDebitCardRequests(){

        LinkedList<DebitCardForm> debitCardReq= managerObj.getDebitCardsReq();

        for(DebitCardForm debitCardForm: debitCardReq){

            User user=bankDataBaseObj.getUsers().get(debitCardForm.getUserId());

            if(managerValidViewObj.showDebitCardRequest(debitCardForm).equalsIgnoreCase("yes")) {

                long accountNumber = debitCardForm.getAccNum();
                generateDebitCard(bankDataBaseObj.getAccounts().get(accountNumber));
                user.getMessages().add("Application for debit card is accepted");
                managerValidViewObj.formAcceptedNotification();
                debitCardReq.remove(debitCardForm);
            }
            else{
                user.getMessages().add("Application for debit card is rejected");
                managerValidViewObj.formRejectedNotification();
            }
        }
    }

    public void validateBranchChangeRequests(){

        LinkedList<BranchChangeForm> forms= managerObj.getBranchChangeReq();

        for(BranchChangeForm branchChangeForm: forms){

            User user=bankDataBaseObj.getUsers().get(branchChangeForm.getUserId());

            if(managerValidViewObj.showBranchChangeRequest(branchChangeForm).equalsIgnoreCase("yes"))
            {
            Account account= bankDataBaseObj.getAccounts().get(branchChangeForm.getAccountNumber());
            account.setBranchCode(branchChangeForm.getNewBranchCode());
            Branch currentBranch= bankDataBaseObj.getBranches().get(branchChangeForm.getCurrentBranchCode());
            Branch newBranch= bankDataBaseObj.getBranches().get(branchChangeForm.getNewBranchCode());
            currentBranch.getAccounts().remove(branchChangeForm.getAccountNumber());
            newBranch.getAccounts().add(branchChangeForm.getAccountNumber());
            user.getMessages().add("Application for branch is accepted and Branch is changed");
            managerValidViewObj.formAcceptedNotification();
            }

            else{
                user.getMessages().add("Application for branch is accepted and Branch is changed");
                managerValidViewObj.formRejectedNotification();
            }

        }
    }

    public void validateLoanRequests(){

        LinkedList<LoanForm> loanFormReq= managerObj.getLoansReq();

        for(LoanForm loanForm: loanFormReq ){

            User user=bankDataBaseObj.getUsers().get(loanForm.getUserId());

            if(managerValidViewObj.showLoanRequest(loanForm).equalsIgnoreCase("yes")) {
                long accNum = loanForm.getAccNumber();

                long amount = loanForm.getAmount();
                Account account = bankDataBaseObj.getAccounts().get(accNum);

                Branch branch = bankDataBaseObj.getBranches().get(account.getBranchCode());
                account.setBalance(account.getBalance() + amount);
                branch.setReserveAmount(branch.getReserveAmount() - amount);
                user.getMessages().add("Application for loan is accepted");
                managerValidViewObj.formAcceptedNotification();
            }

            else{
                user.getMessages().add("Application for loan is rejected");
                managerValidViewObj.formRejectedNotification();
            }
        }

    }
    public void generateCreditCard(Account account){

        LocalDate date=LocalDate.now().plusYears(10);
        CreditCard creditCard=new CreditCard(generateCardNum(),date,generateCCV());   //add bank name in credit card
        account.setCreditCard(creditCard);
    }
    public void generateDebitCard(Account account){

        LocalDate date=LocalDate.now().plusYears(10);
        DebitCard debitCard=new DebitCard(generateCardNum(),date,generateCCV());   //add bank name in credit card
        account.setDebitCard(debitCard);
    }
    public long generateCardNum(){

        long max=100000000000000L;
        long min=10000000000000L;
        long num=(long)(Math.random()*(max-min+1)+max);
        return num;

    }
    public int generateCCV(){

        int max=1000;
        int min=100;
        int num=(int)(Math.random()*(max-min+1)+max);
        return num;

    }
}
