package Controller;

import Data.BankDataBase;
import Model.Account;
import Model.User;
import View.*;

public class UserMenuController {
    public static void userFeatures(BankDataBase bankDataObj, UserInputUI userView,User userObject)
    {



        AccountProcessUI accProViewObj=new AccountProcessView();
        AccountController accController=new AccountController(bankDataObj,accProViewObj);

        TaxDebitController taxDebitContObj=new TaxDebitController(bankDataObj);
        TransactionUI transViewObj=new TransactionView();
        TransactionDataGenerator transDataGeneObj=new TransactionDataGenerator();

        UserRequestUI reqViewObj=new UserRequestView();
        UserRequestController userReqContObj=new UserRequestController(bankDataObj,reqViewObj);
        UserMenuView userMenuViewObj=new UserMenuView();




        if (userObject == null) {                     // If Model.User enter valid user name and password break statement not get invoked
            return;                                        // Or else break statement get invoked and asks user to enter valid data
        }

        if(userObject.getAccount()==null){

            t:  switch(userMenuViewObj.accountSelectionView()){

                case 1:
                    userView.displayBranches(bankDataObj.getBranches());
                    accController.initiateCurrentAccountCreation(userObject);
                    break;

                case 2:
                    userView.displayBranches(bankDataObj.getBranches());
                    accController.initiateSavingsAccountCreation(userObject);
                    break;

                case 3:
                    if(!accController.initiateLinkWithExistingBankAccount(userObject))
                        return;
                    break;

                case 4:
                        return;

                default:
                    userMenuViewObj.invalidDataNotification();
                    break t;
            }
        }

        Account account = userObject.getAccount();

        boolean flow=true;

        while(flow){
            InterestRateCalculator rateCalculator=new InterestRateCalculator();

            switch(userMenuViewObj.UserMenuView()){

                case 1:
                    WithDrawController withdrawContObj=new WithDrawController(taxDebitContObj,transViewObj,transDataGeneObj,bankDataObj,rateCalculator);
                    withdrawContObj.withdraw(account);
                    break;

                case 2:
                    DepositController depositContObj=new DepositController(taxDebitContObj,transViewObj,transDataGeneObj,bankDataObj,rateCalculator);
                    depositContObj.deposit(account);
                    break;

                case 3:
                    OnlineTransferController accTransContObj=new OnlineTransferController(taxDebitContObj,transViewObj,transDataGeneObj,bankDataObj,rateCalculator);
                    accTransContObj.transferToAccount(account);
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
                    transViewObj.displayAllTransactions(account.getTransactions());
                    break;

                case 10:
                    userView.displayAccountStatus(account);
                    break;

                case 11:
                    userView.displayMessages(userObject.getMessages());
                    break;

                case 12:
                    userView.displayAvailableBalance(account.getBalance());
                    break;
                    case 13:
                    flow=false;
                    break;



                default:
                    userMenuViewObj.invalidDataNotification();
            }
        }
    }
}
