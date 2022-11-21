package Controller;

import Data.BankDataBase;
import View.ManagerValidationView;
import View.MangerMenuView;
import View.LoginManagerView;


public class ManagerMenuController {
    public static void managerFeatures(BankDataBase bankDataObj){

        LoginManagerView loginManagerViewObj =new LoginManagerView();
        LoginManagerController loginManagerContObj=new LoginManagerController(loginManagerViewObj,bankDataObj);

        ManagerValidationView managerValidViewObj=new ManagerValidationView();
        ManagerController managerControllerObj =new ManagerController(bankDataObj,managerValidViewObj);

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
                    loginManagerViewObj.invalidDataNotification();

            }
        }
    }
}
