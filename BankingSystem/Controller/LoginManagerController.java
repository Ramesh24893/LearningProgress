package Controller;

import Data.BankDataBase;
import Model.Manager;
import View.ManagerView;

public class LoginManagerController {
    ManagerView managerViewObject;
    BankDataBase bankDataBaseObj;

    public LoginManagerController(ManagerView managerViewObject, BankDataBase bankDataBaseObj) {
        this.managerViewObject = managerViewObject;
        this.bankDataBaseObj = bankDataBaseObj;
    }

    public boolean loginManager(){
        if (!validateManager(managerViewObject.getManagerUserNameForValidation(), managerViewObject.getManagerPasswordForValidation() )){
            managerViewObject.invalidManagerLoginNotification();
            return true;
        }
        return false;
    }

    public boolean validateManager(String adminUserName, String password){
        Manager managerObj=bankDataBaseObj.getManager();
        return managerObj.getManagerUserName().equals(adminUserName) && managerObj.getManagerPassword().equals(password);
    }
}
