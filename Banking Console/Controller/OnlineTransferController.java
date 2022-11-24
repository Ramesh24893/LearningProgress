package Controller;
import Data.BankDataBase;
import Model.*;
import View.TransactionUI;


public class OnlineTransferController {
    private TaxDebitController taxDebitControllerObj;
    private TransactionUI transactionViewObj;
    private TransactionDataGenerator receiptGeneratorObj;
    private BankDataBase bankDataObj;
    private TaxCalcController rateCalc;
    public OnlineTransferController(TaxDebitController taxDebitControllerObj, TransactionUI transactionViewObj, TransactionDataGenerator receiptGeneratorObj, BankDataBase bankDataObj, TaxCalcController rateCalc) {

        this.taxDebitControllerObj = taxDebitControllerObj;
        this.transactionViewObj = transactionViewObj;
        this.receiptGeneratorObj = receiptGeneratorObj;
        this.bankDataObj = bankDataObj;
        this.rateCalc=rateCalc;
    }
    public void initiateOnlineTransfer(Account senderAccount){

        int amount=transactionViewObj.getAmountForTransaction();
        int taxAmt=rateCalc.calcWithDrawTax(amount);



        if(amount> senderAccount.getTransferLimit()){
            transactionViewObj.transferLimitReachedNotification(senderAccount.getTransferLimit());
        }
        else if(!bankAccess(senderAccount,amount)){
            return;
        }

        else if(amount + taxAmt>= (senderAccount.getBalance() + senderAccount.getOverDraftLimit() ) )
            transactionViewObj.transactionFailedMessage();

        else {
            long receiverAccNumber = transactionViewObj.getReceiverAccountNumber();
            Account receiverAcc = bankDataObj.getAccounts().get(receiverAccNumber);

            if(receiverAcc==null){
                transactionViewObj.noSuchAccountExist();
                return;
            }

            Branch senderBranch= bankDataObj.getBranches().get(senderAccount.getBranchCode());


            transferToAccount(senderAccount, receiverAcc, amount,senderBranch);

            int taxAmount = taxDebitControllerObj.debitAccountToAccountTransferTax( amount,senderAccount);

            senderBranch.setReserveAmount(senderBranch.getReserveAmount()+taxAmount);
            String senderReceipt = receiptGeneratorObj.generateSenderTransactionData(amount, receiverAccNumber, senderAccount.getBalance(), taxAmount);
            senderAccount.getTransactions().add(senderReceipt);

            String receiverReceipt = receiptGeneratorObj.generateReceiverTransactionData(amount, senderAccount.getAccountNumber(), receiverAcc.getBalance());
            receiverAcc.getTransactions().add(receiverReceipt);

            transactionViewObj.transactionSuccessMessage();
            transactionViewObj.displayReceipt(senderReceipt);
        }
        }

        public void transferToAccount(Account senderAccount, Account receiverAccount, int amount,Branch senderBranch){

            updateReceiverAccount(receiverAccount,amount);
            updateSenderAccount(senderAccount,amount);
            senderBranch.setReserveAmount(senderBranch.getReserveAmount()-amount);
            Branch receiverBranch= bankDataObj.getBranches().get(senderAccount.getBranchCode());
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

        Branch branchOfAcc= bankDataObj.getBranches().get(account.getBranchCode());
        long branchResAmt=branchOfAcc.getReserveAmount();
         if(amount> branchResAmt){

             transactionViewObj.branchLimitReached(branchResAmt);
            return false;
        }

         return true;
    }
}
