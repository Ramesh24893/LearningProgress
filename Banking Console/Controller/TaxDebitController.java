package Controller;

import Data.BankDataBase;
import Model.Account;
import Model.Branch;

public class TaxDebitController  {
    private BankDataBase bankDataObj;
    private InterestCalcController rateCalc;
    public TaxDebitController(BankDataBase bankDataObj,InterestCalcController rateCalc) {
        this.bankDataObj = bankDataObj;
        this.rateCalc=rateCalc;
    }

    public int debitWithdrawTax(int amount, Account account){

       int taxAmt=rateCalc.calcWithDrawTax(amount);
       updateAccAndBranch(account,taxAmt);
       return taxAmt;

    }
    public int debitAccountToAccountTransferTax( int amount,Account account){

        int taxAmt=rateCalc.calcAccountToAccountTransferTax(amount);
        updateAccAndBranch(account,taxAmt);
        return taxAmt;

    }
    public int debitDepositTax(int amount, Account account){

        int taxAmt=rateCalc.calcDepositTax(amount);
        updateAccAndBranch(account,taxAmt);
        return taxAmt;

    }
    public void updateAccAndBranch(Account account ,int taxAmt){

        int accBalance=(int)account.getBalance();
        if(taxAmt>accBalance){
            int amount=taxAmt-accBalance;

            account.setDebtAmt(account.getDebtAmt()+amount);
            account.setOverDraftLimit(account.getOverDraftLimit()-amount);
            account.setBalance(0);
        }
        else {
            account.setBalance(account.getBalance() - taxAmt);
        }
        String branchCode= account.getBranchCode();
        Branch branch= bankDataObj.getBranches().get(branchCode);
        account.setTotalChargesPaid(account.getTotalChargesPaid()+taxAmt);
        int amt=branch.getBranchProfit()+taxAmt;
        branch.setBranchProfit(amt);

    }
}

