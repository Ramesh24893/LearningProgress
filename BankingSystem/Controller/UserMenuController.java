package Controller;

import Data.BankDataBase;
import Model.Account;
import Model.User;
import View.*;

public class UserMenuController {
    public static void userFeatures(BankDataBase bankDataObj, UserView userView)
    {

        LoginUserController loginUserContObj=new LoginUserController(bankDataObj,userView);


        AccountProcessingView accProViewObj=new AccountProcessingView();
        AccountController accController=new AccountController(bankDataObj,accProViewObj);


        TaxDebitController taxDebitContObj=new TaxDebitController(bankDataObj);
        TransactionView transViewObj=new TransactionView();
        TransactionDataGenerator transDataGeneObj=new TransactionDataGenerator();
        TransactionController transContObj=new TransactionController(taxDebitContObj,transViewObj,transDataGeneObj,bankDataObj);


        RequestView reqViewObj=new RequestView();
        UserRequestController userReqContObj=new UserRequestController(bankDataObj,reqViewObj);

        User userObject = loginUserContObj.loginUser();
        if (userObject == null) {                     // If Model.User enter valid user name and password break statement not get invoked
            return;                                        // Or else break statement get invoked and asks user to enter valid data
        }
        if(userObject.getAccount()==null){
            t:  switch(UserMenuView.accountSelectionView()){
                case 1:
                    userView.displayBranches(bankDataObj.getBranches());
                    accController.createCurrentAccount(userObject);
                    break;
                case 2:
                    userView.displayBranches(bankDataObj.getBranches());
                    accController.createSavingsAccount(userObject);
                    break;

                case 3:
                    if(!accController.linkWithExistingBankAccount(userObject))
                        return;
                    break;
                    case 4:
                        return;

                default:
                    UserMenuView.invalidDataNotification();
                    break t;
            }
        }
        Account account = userObject.getAccount();

        boolean flow=true;
        while(flow){
            switch(UserMenuView.UserMenuView()){

                case 1:
                    transContObj.withdraw(account);
                    break;
                case 2:
                    transContObj.deposit(account);
                    break;
                case 3:
                    transContObj.transferToBankAccount(account);
                    break;

                    case 4:
                    userReqContObj.applyForCreditCard(account, userObject);
                    break;
                case 5:
                    userReqContObj.applyForDebitCard(account, userObject);
                    break;
                case 6:
                    userReqContObj.applyForLoan(account, userObject);
                    break;
                case 7:
                    userView.displayBranches(bankDataObj.getBranches());
                    userReqContObj.applyForBranchChange(account, userObject);
                    break;
                case 8:
                    accController.deleteAccount(userObject,account);
                    break;
                case 9:
                    transContObj.displayAllTransactions(account);
                    break;

                case 10:
                    userView.displayAccountStatus(account);
                    break;
                case 11:
                    userView.displayMessages(userObject.getMessages());
                    break;

                case 12:
                    flow=false;
                default:
                    UserMenuView.invalidDataNotification();
            }
        }}
}
