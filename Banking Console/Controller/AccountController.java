package Controller;

import Data.BankDataBase;
import Model.Account;
import Model.Branch;
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

        updateBankAccount(userObj.getUserId(),"CurrentAccount",LocalDate.now(),accObj);
        setCurrentAccTransLimits(accObj);
        updateBankData(accObj,branchCode);
        updateUserAcc(userObj,accObj);

    }

    private void setCurrentAccTransLimits(Account accObj){
        accObj.setTransferLimit(100000);
        accObj.setWithdrawLimit(10000);
        accObj.setDepositLimit(1000000);
        accObj.setMinBalance(20000);
        accObj.setOverDraftLimit(50000);
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

        Account accObj=new Account(name,generateAccountNumber(),mobNum,branchCode,father,age,gender,aadhaar,pan,city);

        setSavingsAccTransLimits(accObj);
        updateBankAccount(userObj.getUserId(),"SavingsAccount",LocalDate.now(),accObj);
        updateBankData(accObj,branchCode);
        updateUserAcc(userObj,accObj);

    }
    private void updateBankAccount(String userID,String accType,LocalDate date,Account accObj){
        accObj.setAccountType(accType);
        accObj.setDateOfCreation(date);
        accObj.setLinkedUserId(userID);
    }


    private void setSavingsAccTransLimits(Account accObj){
        accObj.setTransferLimit(100000);
        accObj.setWithdrawLimit(50000);
        accObj.setDepositLimit(100000);
        accObj.setMinBalance(1000);
        accObj.setOverDraftLimit(0);
    }
     private void updateBankData(Account acc, String branchCode){
         bankDataObj.getAccounts().put(acc.getAccountNumber(),acc);
         bankDataObj.getBranches().get(branchCode).getAccounts().add(acc.getAccountNumber());
     }
     private void updateUserAcc(User userObj,Account accObj){
         userObj.setAccount(accObj);
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
