package Controller;

import Data.BankDataBase;
import View.*;


public class ManagerController {
    public static void showManagerFeatures(BankDataBase bankDataObj){

        LoginManagerUI loginManagerUI =new LoginManagerView();
        LoginManagerController loginManagerContObj=new LoginManagerController(loginManagerUI,bankDataObj);

        ManagerValidationUI managerValidUI=new ManagerValidationView();
        ManagerValidationController managerControllerObj =new ManagerValidationController(bankDataObj,managerValidUI);

        if (loginManagerContObj.login())
            return;

        boolean flow=true;

        while(flow){

            switch(new MangerMenuView().ManagerMenuView()){

                case 1:
                    managerControllerObj.displayBranchStats();
                    break;

                case 2:
                    managerControllerObj.validateCreditCardRequests();
                    break;

                case 3:
                    managerControllerObj.validateDebitCardRequests();
                    break;

                case 4:
                    managerControllerObj.validateLoanRequests();
                    break;

                case 5:
                    managerControllerObj.validateBranchChangeRequests();
                    break;

                case 6:
                    flow=false;
                    break;

                default:
                    loginManagerUI.invalidDataNotification();

            }
        }
    }
}
