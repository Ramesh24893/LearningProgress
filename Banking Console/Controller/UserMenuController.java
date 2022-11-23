package Controller;

import Data.BankDataBase;
import Model.Account;
import Model.User;
import View.*;

public class UserMenuController {
    public static void userFeatures(BankDataBase bankDataObj, UserInputUI userInputUI, User userObject) {


        AccountProcessUI accProUI = new AccountProcessView();
        AccountController accController = new AccountController(bankDataObj, accProUI);
        InterestCalcController rateCalc=new InterestCalcController();
        TaxDebitController taxDebitContObj = new TaxDebitController(bankDataObj,rateCalc);
        TransactionUI transUI = new TransactionView();
        TransactionDataGenerator transDataGeneObj = new TransactionDataGenerator();

        UserRequestUI userRequestUI = new UserRequestView();
        UserRequestController userReqContObj = new UserRequestController(bankDataObj, userRequestUI);
        UserMenuUI userMenuUI = new UserMenuView();

        if (userObject == null) {                     
            return;                                      
        }

        if (userObject.getAccount() == null) {
            boolean loop = true;
            while (loop) {
                switch (userMenuUI.accountSelectionView()) {

                    case 1:
                        userInputUI.displayBranches(bankDataObj.getBranches());
                        accController.initiateCurrentAccountCreation(userObject);
                        loop = false;
                        break;

                    case 2:
                        userInputUI.displayBranches(bankDataObj.getBranches());
                        accController.initiateSavingsAccountCreation(userObject);
                        loop = false;
                        break;

                    case 3:
                        if (!accController.initiateLinkWithExistingBankAccount(userObject))
                            return;
                        loop = false;
                        break;

                    case 4:                           
                        return;

                    default:
                        userMenuUI.invalidDataNotification();

                }
            }
        }
            Account account = userObject.getAccount();

            boolean flow = true;

            while (flow) {
                InterestCalcController interestCalcObj = new InterestCalcController();

                switch (userMenuUI.UserMenuView()) {

                    case 1:
                        WithDrawController withdrawContObj = new WithDrawController(taxDebitContObj, transUI, transDataGeneObj, bankDataObj, interestCalcObj);
                        withdrawContObj.initiateWithdraw(account);
                        break;

                    case 2:
                        DepositController depositContObj = new DepositController(taxDebitContObj, transUI, transDataGeneObj, bankDataObj, interestCalcObj);
                        depositContObj.initiateDeposit(account);
                        break;

                    case 3:
                        OnlineTransferController accTransContObj = new OnlineTransferController(taxDebitContObj, transUI, transDataGeneObj, bankDataObj, interestCalcObj);
                        accTransContObj.initiateMoneyTransfer(account);
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
                        userInputUI.displayBranches(bankDataObj.getBranches());
                        userReqContObj.applyForBranchChange(account, userObject);
                        break;

                    case 8:
                        accController.deleteAccount(userObject, account);
                        return;

                    case 9:
                        transUI.displayAllTransactions(account.getTransactions());
                        break;

                    case 10:
                        userInputUI.displayAccountStatus(account);
                        break;

                    case 11:
                        userInputUI.displayMessages(userObject.getMessages());
                        break;

                    case 12:
                        userInputUI.displayAvailableBalance(account.getBalance());
                        break;
                    case 13:
                        flow = false;
                        break;


                    default:
                        userMenuUI.invalidDataNotification();
                }
            }
        }
    }
