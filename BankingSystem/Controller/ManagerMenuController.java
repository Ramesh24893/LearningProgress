package Controller;

import Data.BankDataBase;
import View.ManagerValidationView;
import View.MangerMenuView;
import View.ManagerView;


public class ManagerMenuController {
    public static void managerFeatures(BankDataBase bankDataObj){

        ManagerView managerViewObj=new ManagerView();
        LoginManagerController loginManagerContObj=new LoginManagerController(managerViewObj,bankDataObj);

        ManagerValidationView managerValidViewObj=new ManagerValidationView();
        ManagerController managerControllerObj =new ManagerController(bankDataObj,managerValidViewObj);

        if (loginManagerContObj.loginManager())
            return;
        boolean flow=true;
        while(flow){
            switch(MangerMenuView.AdminMenuView()){
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
                default:
                    managerViewObj.invalidDataNotification();

            }
        }
    }
}
