package Controller;

import Data.BankDataBase;
import Model.Account;
import Model.Branch;

public class TaxDebitController {
    BankDataBase bankDataBaseObj;
    public TaxDebitController(BankDataBase bankDataBaseObj) {
        this.bankDataBaseObj = bankDataBaseObj;
    }
    float transferWithInBankTaxRate=0.03f;
    float depositTaxRate=0.02f;
    float accountCreationTaxRate=0.15f;
    float withdrawTaxRate=0.05f;
    public int debitWithdrawTax(int amount, Account account){
        int taxAmt= (int)(amount*withdrawTaxRate);
        updateAccAndBranch(account,taxAmt);
        return taxAmt;
    }
    public int debitAccountToAccountTransferTax( int amount,Account account){
        int taxAmt= (int)(amount*transferWithInBankTaxRate);
        updateAccAndBranch(account,taxAmt);
        return taxAmt;

    }

//    public int debitAccountCreationTax(int amount, Account account){
//        long taxAmt= (long)(amount*accountCreationTaxRate);
//        updateAccAndBranch(account,taxAmt);
//        return taxAmt;
//
//    }
    public int debitDepositTax(int amount, Account account){
        int taxAmt= (int)(amount*depositTaxRate);
        updateAccAndBranch(account,taxAmt);
        return taxAmt;
    }
    public void updateAccAndBranch(Account account ,int taxAmt){
        account.setBalance(account.getBalance()-taxAmt);
        String branchCode= account.getBranchCode();
        Branch branch= bankDataBaseObj.getBranches().get(branchCode);
        account.setTotalChargesPaid(account.getTotalChargesPaid()+taxAmt);
        int amt=branch.getBranchProfit()+taxAmt;
        branch.setBranchProfit(amt);


    }



}











//    public void setTransferWithInBankTaxRate(float transferWithInBankTaxRate) {
//        this.transferWithInBankTaxRate = transferWithInBankTaxRate;
//    }
//    public void setTransferToOtherBankTaxRate(int transferToOtherBankTaxRate) {
//        this.transferToOtherBankTaxRate = transferToOtherBankTaxRate;
//    }
//    public void setDepositTaxRate(int depositTaxRate) {
//        this.depositTaxRate = depositTaxRate;
//    }
//    public void setAccountCreationTaxRate(int accountCreationTaxRate) {
//        this.accountCreationTaxRate = accountCreationTaxRate;
//    }
//    public void setWithdrawTaxRate(int withdrawTaxRate) {
//        this.withdrawTaxRate = withdrawTaxRate;
//    }