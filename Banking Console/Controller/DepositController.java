package Controller;

import Data.BankDataBase;
import Model.Account;
import Model.Branch;
import View.TransactionUI;

public class DepositController {
    TaxDebitController taxDebitControllerObj;
    TransactionUI transactionViewObj;
    TransactionDataGenerator receiptGeneratorObj;
    BankDataBase bankDataBaseObj;
    InterestRateCalculator rateCalc;

    public DepositController (TaxDebitController taxDebitControllerObj, TransactionUI transactionViewObj, TransactionDataGenerator receiptGeneratorObj, BankDataBase bankDataBaseObj,InterestRateCalculator rateCalc) {

        this.taxDebitControllerObj = taxDebitControllerObj;
        this.transactionViewObj = transactionViewObj;
        this.receiptGeneratorObj = receiptGeneratorObj;
        this.bankDataBaseObj = bankDataBaseObj;
        this.rateCalc=rateCalc;
    }


    public void deposit(Account account){
        int amount=transactionViewObj.getAmountForTransaction();

        if(amount> account.getDepositLimit()) {

           transactionViewObj.depositLimitedReachedNotification(account.getDepositLimit());
        }
        else{

            deposit(account, amount);
            int taxAmount = taxDebitControllerObj.debitDepositTax(amount, account);
            String data = receiptGeneratorObj.generateDepositTransactionData(amount, account.getBalance(), taxAmount);
            account.getTransactions().add(data);
            transactionViewObj.transactionSuccessMessage();
            transactionViewObj.displayReceipt(data);

        }
    }

    public void deposit(Account account, int amount){
    int debtAmount=account.getDebtAmt();
    if(debtAmount>0){

            if(amount>debtAmount){

            account.setBalance( amount- debtAmount);
            account.setOverDraftLimit(account.getOverDraftLimit()+debtAmount);
            account.setDebtAmt(0);
            }
            else{

                account.setDebtAmt(debtAmount-amount);
                account.setOverDraftLimit(account.getOverDraftLimit()+amount);
            }
     }
     else {
        int updatedBalance = (int) account.getBalance() + amount;
        account.setBalance(updatedBalance);
     }

        Branch branch=bankDataBaseObj.getBranches().get(account.getBranchCode());
        branch.setReserveAmount(branch.getReserveAmount()+amount);

    }


}
