package Controller;

import Data.BankDataBase;
import Model.Account;
import Model.User;
import View.AccountProcessUI;
import java.time.LocalDate;
import java.util.Map;

 class AccountController {
     private BankDataBase bankDataObj;
     private AccountProcessUI accProUI;

    public AccountController(BankDataBase bankDataObj, AccountProcessUI accProUI) {

        this.bankDataObj = bankDataObj;
        this.accProUI = accProUI;
    }

     void initiateCurrentAccountCreation(User userObj){

        String branch= accProUI.getBranchCode(bankDataObj.getBranches().keySet());
        createCurrentAccount(userObj,branch);
        accProUI.accCreationSuccessfulNotification();

    }
     void initiateSavingsAccountCreation(User userObj){

        String branch= accProUI.getBranchCode(bankDataObj.getBranches().keySet());
        createSavingsAccount(userObj,branch);
        accProUI.accCreationSuccessfulNotification();

    }


     boolean initiateLinkWithExistingBankAccount(User user){


        if(linkWithExistingBankAccount(user)){
            accProUI.existingAccountLinkingSuccessful();
            return true;
        }else
            accProUI.existingAccountLinkingFailed();


        return false;
    }
    void deleteAccount(User user, Account account){

        user.setAccount(null);
        bankDataObj.getAccounts().remove(account.getAccountNumber());
        accProUI.accDeletionMessage();
    }

    void createCurrentAccount(User userObj, String branchCode){

        String name= accProUI.getName();
        long mobNum= accProUI.getMobileNum();
        String father= accProUI.getFathersName();
        int age= accProUI.getAge();
        String gender= accProUI.getGender();
        String city= accProUI.getCityName();
        long aadhaar= accProUI.getAadhaarNumber();
        String pan= accProUI.getPanNumber();

        Account accObj= new Account(name,generateAccountNumber(),mobNum,branchCode,father,age,gender,aadhaar,pan,city);

        accObj.setDateOfCreation(LocalDate.now());
        accObj.setTransferLimit(100000);
        accObj.setWithdrawLimit(10000);
        accObj.setDepositLimit(1000000);
        accObj.setMinBalance(20000);
        accObj.setOverDraftLimit(50000);
        accObj.setAccountType("CurrentAccount");

        bankDataObj.getAccounts().put(accObj.getAccountNumber(),accObj);
        bankDataObj.getBranches().get(branchCode).getAccounts().add(accObj.getAccountNumber());
        userObj.setAccount(accObj);
        accObj.setLinkedUserId(userObj.getUserId());

    }
    void createSavingsAccount(User userObj,String branchCode){

        String name= accProUI.getName();
        long mobNum= accProUI.getMobileNum();
        String father= accProUI.getFathersName();
        int age= accProUI.getAge();
        String gender= accProUI.getGender();
        String city= accProUI.getCityName();
        long aadhaar= accProUI.getAadhaarNumber();
        String pan= accProUI.getPanNumber();

        Account acc=new Account(name,generateAccountNumber(),mobNum,branchCode,father,age,gender,aadhaar,pan,city);

        acc.setTransferLimit(100000);
        acc.setWithdrawLimit(50000);
        acc.setDepositLimit(100000);
        acc.setMinBalance(1000);
        acc.setOverDraftLimit(0);
        acc.setAccountType("SavingsAccount");
        acc.setDateOfCreation(LocalDate.now());

        bankDataObj.getAccounts().put(acc.getAccountNumber(),acc);
        bankDataObj.getBranches().get(branchCode).getAccounts().add(acc.getAccountNumber());
        acc.setLinkedUserId(userObj.getUserId());
        userObj.setAccount(acc);

    }
    boolean linkWithExistingBankAccount(User userObj){

        String name= accProUI.getName();
        long mobNum= accProUI.getMobileNum();
        long accountNumber= accProUI.getExistingAccountNumber();

        for(Map.Entry<Long, Account>account: bankDataObj.getAccounts().entrySet()){

            Account accObj=account.getValue();

            if(accObj.getAccHolderName().equals(name) && accObj.getMobileNumber()==mobNum && accObj.getAccountNumber()==(accountNumber) && accObj.getLinkedUserId()==null){

                userObj.setAccount(accObj);
                accObj.setLinkedUserId(userObj.getUserId());
                return true;
            }
        }
        return false;

    }
    private long generateAccountNumber(){

        long max =10000000000000000L;
        long  min=1000000000000000L;
        return (long) (Math.random()*(max-min+1)+min);

    }

}
