package Controller;

import Data.BankDataBase;
import Model.Account;
import Model.Branch;
import View.TransactionUI;

public class DepositController {
    private TaxDebitController taxDebitControllerObj;
    private TransactionUI transactionViewObj;
    private TransactionDataGenerator receiptGeneratorObj;
    private BankDataBase bankDataBaseObj;
    private TaxCalcController rateCalc;

    public DepositController (TaxDebitController taxDebitControllerObj, TransactionUI transactionViewObj, TransactionDataGenerator receiptGeneratorObj, BankDataBase bankDataBaseObj, TaxCalcController rateCalc) {

        this.taxDebitControllerObj = taxDebitControllerObj;
        this.transactionViewObj = transactionViewObj;
        this.receiptGeneratorObj = receiptGeneratorObj;
        this.bankDataBaseObj = bankDataBaseObj;
        this.rateCalc=rateCalc;
    }


     void initiateDeposit(Account account){
        int depositAmount=transactionViewObj.getAmountForTransaction();

        if(depositAmount> account.getDepositLimit()) {

           transactionViewObj.depositLimitedReachedNotification(account.getDepositLimit());
        }
        else{
            Branch branch=bankDataBaseObj.getBranches().get(account.getBranchCode());

            deposit(account, depositAmount,branch);
            int taxAmount = taxDebitControllerObj.debitDepositTax(depositAmount, account);
            branch.setReserveAmount(branch.getReserveAmount()+taxAmount);
            String data = receiptGeneratorObj.generateDepositTransactionData(depositAmount, account.getBalance(), taxAmount);
            account.getTransactions().add(data);
            transactionViewObj.transactionSuccessMessage();
            transactionViewObj.displayReceipt(data);

        }
    }

    private void deposit(Account account, int amount,Branch branch) {

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
        long updatedBalance =  account.getBalance() + amount;
        account.setBalance(updatedBalance);
     }


        branch.setReserveAmount(branch.getReserveAmount()+amount);

    }


}
