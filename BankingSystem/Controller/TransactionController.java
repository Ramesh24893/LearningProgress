package Controller;
import Data.BankDataBase;
import Model.*;
import View.TransactionView;



public class TransactionController {
    TaxDebitController taxDebitControllerObj;
    TransactionView transactionViewObj;
    TransactionDataGenerator dataGeneratorObj;
    BankDataBase bankDataBaseObj;
    public TransactionController(TaxDebitController taxDebitControllerObj, TransactionView transactionViewObj, TransactionDataGenerator dataGeneratorObj, BankDataBase bankDataBaseObj) {
        this.taxDebitControllerObj = taxDebitControllerObj;
        this.transactionViewObj = transactionViewObj;
        this.dataGeneratorObj = dataGeneratorObj;
        this.bankDataBaseObj = bankDataBaseObj;
    }

    public void deposit(Account account){
        int amount=transactionViewObj.getAmountForDeposit();

        if(amount> account.getDepositLimit()) {
            transactionViewObj.depositLimitedReached(account.getDepositLimit());
        }else{
                deposit(account, amount);
                int taxAmount = taxDebitControllerObj.debitDepositTax(amount, account);
                String data = dataGeneratorObj.generateDepositTransactionData(amount, account.getBalance(), taxAmount);
                account.getTransactions().add(data);
                transactionViewObj.transactionSuccessMessage();
                transactionViewObj.displayReceipt(data);
        }
    }
    public void withdraw(Account account){
        int amount=transactionViewObj.getAmountForWithdraw();
      if(amount> account.getWithdrawLimit()){
          transactionViewObj.withdrawLimitReached(account.getWithdrawLimit());
        }else if(amount> account.getBalance()){
          transactionViewObj.transactionFailedMessage();
      }
      else{
           withdraw(account,amount);
        int taxAmount=taxDebitControllerObj.debitWithdrawTax(amount,account);
        String data=dataGeneratorObj.generateWithDrawTransactionData(amount,account.getBalance(),taxAmount);
              transactionViewObj.transactionSuccessMessage();
        transactionViewObj.displayReceipt(data);
        account.getTransactions().add(data);

      }
    }
    public void transferToBankAccount(Account senderAccount){

        int amount=transactionViewObj.getAmountForTransfer();
        if(amount> senderAccount.getTransferLimit()){
            transactionViewObj.transferLimitReached(senderAccount.getTransferLimit());
        }
        else if(amount> senderAccount.getBalance()){
        transactionViewObj.transactionFailedMessage();
        }
        else {
            long receiverAccNumber = transactionViewObj.getReceiverAccountNumber();
            Account receiverAcc = bankDataBaseObj.getAccounts().get(receiverAccNumber);
            transferToBankAccount(senderAccount, receiverAcc, amount);
            int taxAmount = taxDebitControllerObj.debitAccountToAccountTransferTax( amount,senderAccount);
            String senderReceipt = dataGeneratorObj.generateSenderTransactionData(amount, receiverAccNumber, senderAccount.getBalance(), taxAmount);
            senderAccount.getTransactions().add(senderReceipt);
            transactionViewObj.transactionSuccessMessage();
            transactionViewObj.displayReceipt(senderReceipt);
            String receiverReceipt = dataGeneratorObj.generateReceiverTransactionData(amount, senderAccount.getAccountNumber(), receiverAcc.getBalance());
            receiverAcc.getTransactions().add(receiverReceipt);

            }
        }



    public void  withdraw(Account account, int amount){

            int updatedBalance=(int)account.getBalance()-amount;
            account.setBalance(updatedBalance);
            Branch branch=bankDataBaseObj.getBranches().get(account.getBranchCode());
            branch.setReserveAmount(branch.getReserveAmount()-amount);

    }
    public void deposit(Account account, int amount){

        int updatedBalance=(int)account.getBalance()+amount;
        account.setBalance(updatedBalance);
            Branch branch=bankDataBaseObj.getBranches().get(account.getBranchCode());
            branch.setReserveAmount(branch.getReserveAmount()+amount);
            System.out.println(branch);
    }
    public void transferToBankAccount(Account senderAccount, Account receiverAccount, int amount){
            receiverAccount.setBalance(receiverAccount.getBalance()+ amount);
            senderAccount.setBalance(senderAccount.getBalance()-amount);
            Branch senderBranch=bankDataBaseObj.getBranches().get(senderAccount.getBranchCode());
            senderBranch.setReserveAmount(senderBranch.getReserveAmount()-amount);
            Branch receiverBranch=bankDataBaseObj.getBranches().get(senderAccount.getBranchCode());
            receiverBranch.setReserveAmount(receiverBranch.getReserveAmount()+amount);
    }


    public void displayAllTransactions(Account account) {
        transactionViewObj.displayAllTransactions(account.getTransactions());
    }
}
