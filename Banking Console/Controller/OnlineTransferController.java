package Controller;
import Data.BankDataBase;
import Model.*;
import View.TransactionUI;


public class OnlineTransferController {
    TaxDebitController taxDebitControllerObj;
    TransactionUI transactionViewObj;
    TransactionDataGenerator receiptGeneratorObj;
    BankDataBase bankDataBaseObj;
    InterestRateCalculator rateCalc;
    public OnlineTransferController(TaxDebitController taxDebitControllerObj, TransactionUI transactionViewObj, TransactionDataGenerator receiptGeneratorObj, BankDataBase bankDataBaseObj, InterestRateCalculator rateCalc) {

        this.taxDebitControllerObj = taxDebitControllerObj;
        this.transactionViewObj = transactionViewObj;
        this.receiptGeneratorObj = receiptGeneratorObj;
        this.bankDataBaseObj = bankDataBaseObj;
        this.rateCalc=rateCalc;
    }
    public void transferToAccount(Account senderAccount){

        int amount=transactionViewObj.getAmountForTransaction();
        int taxAmt=rateCalc.calcWithDrawTax(amount);

        if(!bankAccess(senderAccount,amount)){
            return;
        }

        if(amount> senderAccount.getTransferLimit()){
            transactionViewObj.transferLimitReachedNotification(senderAccount.getTransferLimit());
        }

        else if(amount + taxAmt>= (senderAccount.getBalance() + senderAccount.getOverDraftLimit() ) )
            transactionViewObj.transactionFailedMessage();

        else {
            long receiverAccNumber = transactionViewObj.getReceiverAccountNumber();
            Account receiverAcc = bankDataBaseObj.getAccounts().get(receiverAccNumber);

            transferToAccount(senderAccount, receiverAcc, amount);

            int taxAmount = taxDebitControllerObj.debitAccountToAccountTransferTax( amount,senderAccount);
            String senderReceipt = receiptGeneratorObj.generateSenderTransactionData(amount, receiverAccNumber, senderAccount.getBalance(), taxAmount);
            senderAccount.getTransactions().add(senderReceipt);

            String receiverReceipt = receiptGeneratorObj.generateReceiverTransactionData(amount, senderAccount.getAccountNumber(), receiverAcc.getBalance());
            receiverAcc.getTransactions().add(receiverReceipt);

            transactionViewObj.transactionSuccessMessage();
            transactionViewObj.displayReceipt(senderReceipt);
        }
        }

        public void transferToAccount(Account senderAccount, Account receiverAccount, int amount){

            updateReceiverAccount(receiverAccount,amount);

            updateSenderAccount(senderAccount,amount);

            Branch senderBranch=bankDataBaseObj.getBranches().get(senderAccount.getBranchCode());
            senderBranch.setReserveAmount(senderBranch.getReserveAmount()-amount);

            Branch receiverBranch=bankDataBaseObj.getBranches().get(senderAccount.getBranchCode());
            receiverBranch.setReserveAmount(receiverBranch.getReserveAmount()+amount);

    }



    public void updateReceiverAccount(Account receiverAcc,int amount){
        int debtAmount=receiverAcc.getDebtAmt();
        if(debtAmount>0){

            if(amount>debtAmount){

                receiverAcc.setBalance( amount- debtAmount);
                receiverAcc.setOverDraftLimit(receiverAcc.getOverDraftLimit()+debtAmount);
                receiverAcc.setDebtAmt(0);
            }
            else{

                receiverAcc.setDebtAmt(debtAmount-amount);
                receiverAcc.setOverDraftLimit(receiverAcc.getOverDraftLimit()+amount);
            }
        }

        else {

            int updatedBalance = (int) receiverAcc.getBalance() + amount;
            receiverAcc.setBalance(updatedBalance);
        }
    }
    public void updateSenderAccount(Account account,int amount){

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
    }


    public boolean bankAccess(Account account,int amount){

        Branch branchOfAcc=bankDataBaseObj.getBranches().get(account.getBranchCode());
        long branchResAmt=branchOfAcc.getReserveAmount();
         if(amount> branchResAmt){

             transactionViewObj.branchLimitReached(branchResAmt);
            return false;
        }

         return true;
    }
}
