package Controller;

import Data.BankDataBase;
import Model.Account;
import Model.Branch;
import View.TransactionUI;


public class WithDrawController  {

    TaxDebitController taxDebitControllerObj;
    TransactionUI transactionViewObj;
    TransactionDataGenerator receiptGeneratorObj;
    BankDataBase bankDataBaseObj;
    InterestRateCalculator rateCalc;

    public WithDrawController(TaxDebitController taxDebitControllerObj, TransactionUI transactionViewObj, TransactionDataGenerator receiptGeneratorObj, BankDataBase bankDataBaseObj,InterestRateCalculator rateCalc) {

        this.taxDebitControllerObj = taxDebitControllerObj;
        this.transactionViewObj = transactionViewObj;
        this.receiptGeneratorObj = receiptGeneratorObj;
        this.bankDataBaseObj = bankDataBaseObj;
        this.rateCalc=rateCalc;

    }
    public void withdraw(Account account){

        int amount=transactionViewObj.getAmountForTransaction();
        int taxAmt=rateCalc.calcWithDrawTax(amount);
        if(!bankLimit(account,amount))
            return;

        if(amount> account.getWithdrawLimit())
            transactionViewObj.withdrawLimitReachedNotification(account.getWithdrawLimit());


        else if(amount + taxAmt>= (account.getBalance() + account.getOverDraftLimit() ) )
            transactionViewObj.transactionFailedMessage();

        else{

            withdraw(account,amount);
            int taxAmount=taxDebitControllerObj.debitWithdrawTax(amount,account);
            String data= receiptGeneratorObj.generateWithDrawTransactionData(amount,account.getBalance(),taxAmount);
            transactionViewObj.transactionSuccessMessage();
            transactionViewObj.displayReceipt(data);
            account.getTransactions().add(data);

        }
    }

    public void  withdraw(Account account, int amount){

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
        Branch branch=bankDataBaseObj.getBranches().get(account.getBranchCode());
        branch.setReserveAmount(branch.getReserveAmount()-amount);

    }

    public boolean bankLimit(Account account, int amount){

        Branch branchOfAcc=bankDataBaseObj.getBranches().get(account.getBranchCode());
        long branchResAmt=branchOfAcc.getReserveAmount();

        if(amount> branchResAmt){

            transactionViewObj.branchLimitReached(branchResAmt);
            return false;

        }

        return true;
    }


}
