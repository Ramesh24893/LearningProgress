package Controller;
import Data.BankDataBase;
import Model.*;
import View.ManagerValidationUI;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ManagerController {


    private BankDataBase bankDataObj;
    private ManagerValidationUI managerValidaUI;

    private Manager managerObj;
    public ManagerController(BankDataBase bankDataObj, ManagerValidationUI managerValidaUI) {

        this.bankDataObj = bankDataObj;
        this.managerValidaUI = managerValidaUI;
        this.managerObj= bankDataObj.getManager();

    }

    public void displayBranchStats(){

        managerValidaUI.displayAllBranchStats(bankDataObj.getBranches());
    }
    public void validateCreditCardRequests(){

        HashMap<String,CreditCardForm> creditCardForms= managerObj.getCreditCardsReq();

        if(creditCardForms.isEmpty()){
            managerValidaUI.noRequestAvailNotification();
            return;
        }

        for(Map.Entry<String, CreditCardForm> form: creditCardForms.entrySet()){
            CreditCardForm creditCardForm=form.getValue();

            User user= bankDataObj.getUsers().get(creditCardForm.getUserId());

            if(managerValidaUI.showCreditCardRequest(creditCardForm).equalsIgnoreCase("yes")) {

                long accountNumber = creditCardForm.getAccNum();
                generateCreditCard(bankDataObj.getAccounts().get(accountNumber));
                user.getMessages().add("Application for credit card is accepted");
                managerValidaUI.formAcceptedNotification();


            }
            else
            {
                user.getMessages().add("Application for credit card is rejected");
                managerValidaUI.formRejectedNotification();
            }
            creditCardForms.remove(user.getUserId());
        }
    }

    public void validateDebitCardRequests(){

        HashMap<String,DebitCardForm> debitCardForms= managerObj.getDebitCardsReq();
        if(debitCardForms.isEmpty()){
            managerValidaUI.noRequestAvailNotification();
            return;
        }

        for(Map.Entry<String, DebitCardForm> form : debitCardForms.entrySet()){
            DebitCardForm debitCardForm=form.getValue();

            User user= bankDataObj.getUsers().get(debitCardForm.getUserId());

            if(managerValidaUI.showDebitCardRequest(debitCardForm).equalsIgnoreCase("yes")) {

                long accountNumber = debitCardForm.getAccNum();
                generateDebitCard(bankDataObj.getAccounts().get(accountNumber));
                user.getMessages().add("Application for debit card is accepted");
                managerValidaUI.formAcceptedNotification();

            }
            else{
                user.getMessages().add("Application for debit card is rejected");
                managerValidaUI.formRejectedNotification();
            }
            debitCardForms.remove(user.getUserId());
        }
    }

    public void validateBranchChangeRequests(){

        HashMap<String,BranchChangeForm> branchChangeForms= managerObj.getBranchChangeReq();

        if(branchChangeForms.isEmpty()){
            managerValidaUI.noRequestAvailNotification();
            return;
        }


        for(Map.Entry<String, BranchChangeForm> form : branchChangeForms.entrySet()){
            BranchChangeForm branchChangeForm=form.getValue();
            User user= bankDataObj.getUsers().get(branchChangeForm.getUserId());

            if(managerValidaUI.showBranchChangeRequest(branchChangeForm).equalsIgnoreCase("yes"))
            {
            Account account= bankDataObj.getAccounts().get(branchChangeForm.getAccountNumber());
            account.setBranchCode(branchChangeForm.getNewBranchCode());
            Branch currentBranch= bankDataObj.getBranches().get(branchChangeForm.getCurrentBranchCode());
            Branch newBranch= bankDataObj.getBranches().get(branchChangeForm.getNewBranchCode());
            currentBranch.getAccounts().remove(branchChangeForm.getAccountNumber());
            newBranch.getAccounts().add(branchChangeForm.getAccountNumber());
            user.getMessages().add("Application for branch is accepted and Branch is changed");
            managerValidaUI.formAcceptedNotification();
            }

            else{
                user.getMessages().add("Application for branch is accepted and Branch is changed");
                managerValidaUI.formRejectedNotification();
            }
            branchChangeForms.remove(branchChangeForm);
        }
    }

    public void validateLoanRequests(){

        HashMap<String,LoanForm> loanForms= managerObj.getLoansReq();
        if(loanForms.isEmpty()){
            managerValidaUI.noRequestAvailNotification();
            return;
        }

        for(Map.Entry<String, LoanForm> form : loanForms.entrySet()){
            LoanForm loanForm=form.getValue();

            User user= bankDataObj.getUsers().get(loanForm.getUserId());

            if(managerValidaUI.showLoanRequest(loanForm).equalsIgnoreCase("yes")) {
                long accNum = loanForm.getAccNumber();

                long amount = loanForm.getAmount();
                Account account = bankDataObj.getAccounts().get(accNum);

                Branch branch = bankDataObj.getBranches().get(account.getBranchCode());
                account.setBalance(account.getBalance() + amount);
                branch.setReserveAmount(branch.getReserveAmount() - amount);
                user.getMessages().add("Application for loan is accepted");
                managerValidaUI.formAcceptedNotification();
            }

            else{
                user.getMessages().add("Application for loan is rejected");
                managerValidaUI.formRejectedNotification();
            }
            loanForms.remove(user.getUserId());
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
