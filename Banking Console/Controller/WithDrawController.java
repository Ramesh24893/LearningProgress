package Controller;

import Data.BankDataBase;
import Model.Account;
import Model.Branch;
import View.TransactionUI;


public class WithDrawController  {

    private TaxDebitController taxDebitControllerObj;
    private TransactionUI transactionViewObj;
    private TransactionDataGenerator receiptGeneratorObj;
    private BankDataBase bankDataBaseObj;
    private TaxCalcController rateCalc;

    public WithDrawController(TaxDebitController taxDebitControllerObj, TransactionUI transactionViewObj, TransactionDataGenerator receiptGeneratorObj, BankDataBase bankDataBaseObj, TaxCalcController rateCalc) {

        this.taxDebitControllerObj = taxDebitControllerObj;
        this.transactionViewObj = transactionViewObj;
        this.receiptGeneratorObj = receiptGeneratorObj;
        this.bankDataBaseObj = bankDataBaseObj;
        this.rateCalc=rateCalc;

    }
    void initiateWithdraw(Account account){

        int amount=transactionViewObj.getAmountForTransaction();
        int taxAmt=rateCalc.calcWithDrawTax(amount);



        if(amount> account.getWithdrawLimit())
            transactionViewObj.withdrawLimitReachedNotification(account.getWithdrawLimit());

        else if(!bankLimit(account,amount)) {
            return;
        }

        else if(amount + taxAmt>= (account.getBalance() + account.getOverDraftLimit() ))
            transactionViewObj.transactionFailedMessage();

        else{
            Branch branch=bankDataBaseObj.getBranches().get(account.getBranchCode());
            withdraw(account,amount,branch);
            int taxAmount=taxDebitControllerObj.debitWithdrawTax(amount,account);
            branch.setReserveAmount(branch.getReserveAmount()+taxAmount);
            String data= receiptGeneratorObj.generateWithDrawTransactionData(amount,account.getBalance(),taxAmount);
            transactionViewObj.transactionSuccessMessage();
            transactionViewObj.displayReceipt(data);
            account.getTransactions().add(data);

        }
    }

    private void  withdraw(Account account, int amount,Branch branch){

        int balance=(int)account.getBalance();

        if(amount>balance){
            account.setDebtAmt(account.getDebtAmt()+(amount-balance));//amount-balance;
            account.setOverDraftLimit(account.getOverDraftLimit()-(amount-balance));
            account.setBalance(0);

        }
        else {
            int updatedBalance = (int) account.getBalance() - amount;
            account.setBalance(updatedBalance);
        }

        branch.setReserveAmount(branch.getReserveAmount()-amount);

    }

    private boolean bankLimit(Account account, int amount){

        Branch branchOfAcc=bankDataBaseObj.getBranches().get(account.getBranchCode());
        long branchResAmt=branchOfAcc.getReserveAmount();

        if(amount> branchResAmt){

            transactionViewObj.branchLimitReached(branchResAmt);
            return false;
        }

        return true;
    }

}
