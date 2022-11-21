package Controller;


import Data.BankDataBase;
import Model.Manager;
import View.ManagerUI;


public class LoginManagerController implements Login {
    ManagerUI managerViewObject;
    BankDataBase bankDataBaseObj;

    public LoginManagerController(ManagerUI managerViewObject, BankDataBase bankDataBaseObj) {

        this.managerViewObject = managerViewObject;
        this.bankDataBaseObj = bankDataBaseObj;

    }

    public Boolean login(){

        if (!verify(getUserName(), getPassword() )){

            managerViewObject.invalidManagerLoginNotification();
            return true;
        }

        return false;
    }

    public boolean verify(String adminUserName, String password){

        Manager managerObj=bankDataBaseObj.getManager();
        return managerObj.getManagerUserName().equals(adminUserName) && managerObj.getManagerPassword().equals(password);

    }
    public String getUserName(){

        return managerViewObject.getManagerUserNameForValidation();
    }
    public String getPassword(){

        return managerViewObject.getManagerPasswordForValidation();
    }
}
