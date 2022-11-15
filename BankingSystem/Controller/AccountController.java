package Controller;

import Data.BankDataBase;
import Model.Account;
import Model.User;
import View.AccountProcessingView;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class AccountController {

    BankDataBase bankDataBaseObj;
    AccountProcessingView accProViewObj;

    public AccountController(BankDataBase bankDataBaseObj, AccountProcessingView accProViewObj) {
        this.bankDataBaseObj = bankDataBaseObj;
        this.accProViewObj = accProViewObj;
    }

    public void createCurrentAccount(User userObj){

        HashMap<String,String> inputs= accProViewObj.userInputsForAccGen();

        if(createCurrentAccount(userObj, inputs))
            accProViewObj.invalidBranchDataNotification();
        else
            accProViewObj.accCreationSuccessfulNotification();

    }
    public void createSavingsAccount(User userObj){
        HashMap<String,String> inputs= accProViewObj.userInputsForAccGen();
        if(!createSavingsAccount(userObj,inputs))
            accProViewObj.invalidBranchDataNotification();
        else
            accProViewObj.accCreationSuccessfulNotification();

    }
    public boolean linkWithExistingBankAccount(User user){
        HashMap<String,String> inputs= accProViewObj.userInputsToLinkAcc();
        if(linkWithExistingBankAccount(user,inputs)){
            accProViewObj.existingAccountLinkingSuccessful();
        }else{
            accProViewObj.existingAccountLinkingFailed();
        }

        return false;
    }
    public void deleteAccount(User user, Account account){
        user.setAccount(null);
        bankDataBaseObj.getAccounts().remove(account.getAccountNumber());
    }

    public boolean createCurrentAccount(User userObj, HashMap<String,String> inputs){
        String name= inputs.get("name");
        long mobNum=new Long(inputs.get("mobNum"));
        long amount=new Long(inputs.get("iniDepositAmt"));
        String branchCode=inputs.get("branchCode");
        if(!bankDataBaseObj.getBranches().containsKey(branchCode)){
            return false;
        }
        Account acc= new Account(name,generateAccountNumber(),mobNum,branchCode,amount);
        acc.setDateOfCreation(LocalDate.now());
        acc.setTransferLimit(100000);
        acc.setWithdrawLimit(100000);
        acc.setDepositLimit(1000000);
        acc.setMinBalance(20000);
        acc.setAccountType("CurrentAccount");
        bankDataBaseObj.getAccounts().put(acc.getAccountNumber(),acc);
        bankDataBaseObj.getBranches().get(branchCode).getAccounts().add(acc.getAccountNumber());
        userObj.setAccount(acc);
        acc.setLinkedUserId(userObj.getUserId());
        return true;
    }

    public boolean createSavingsAccount(User userObj, HashMap<String,String> inputs){
        String name= inputs.get("name");
        long mobNum=new Long(inputs.get("mobNum"));
        long amount=new Long(inputs.get("iniDepositAmt"));
        String branchCode=inputs.get("branchCode");
        if(!bankDataBaseObj.getBranches().containsKey(branchCode)){
            return false;
        }
        Account acc=new Account(name,generateAccountNumber(),mobNum,branchCode,amount);
        acc.setTransferLimit(100000);
        acc.setWithdrawLimit(50000);
        acc.setDepositLimit(100000);
        acc.setMinBalance(1000);
        acc.setAccountType("SavingsAccount");
        acc.setDateOfCreation(LocalDate.now());
        bankDataBaseObj.getAccounts().put(acc.getAccountNumber(),acc);
        bankDataBaseObj.getBranches().get(branchCode).getAccounts().add(acc.getAccountNumber());
        acc.setLinkedUserId(userObj.getUserId());
        userObj.setAccount(acc);
        return true;
    }



    public boolean linkWithExistingBankAccount(User user, HashMap<String,String> inputs){

        String name= inputs.get("name");
        long mobNum=new Long(inputs.get("mobNum"));
        long accountNumber=new Long(inputs.get("accountNumber"));

        for(Map.Entry<Long, Account>account: bankDataBaseObj.getAccounts().entrySet()){
            Account acc=account.getValue();
            if(acc.getAccHolderName().equals(name) && acc.getMobileNumber()==mobNum && acc.getAccountNumber()==(accountNumber) && acc.getLinkedUserId()==0){
                user.setAccount(acc);
                return true;
            }
        }
        return false;

    }
    public long generateAccountNumber(){
        long max =10000000000000000L;
        long  min=1000000000000000L;
        return (long) (Math.random()*(max-min+1)+min);
    }
}
