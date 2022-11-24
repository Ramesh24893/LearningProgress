package Controller;


import Data.BankDataBase;
import Model.Manager;
import View.LoginManagerUI;


public class LoginManagerController implements Login {
    private LoginManagerUI managerUI;
    private BankDataBase bankDataObj;

    public LoginManagerController(LoginManagerUI managerUI, BankDataBase bankDataObj) {

        this.managerUI = managerUI;
        this.bankDataObj = bankDataObj;

    }

    public Boolean login(){

        if (!verify(getUserName(), getPassword() )){

            managerUI.invalidManagerLoginNotification();
            return true;
        }

        return false;
    }

    public boolean verify(String adminUserName, String password){

        Manager managerObj= bankDataObj.getManager();
        return managerObj.getManagerUserName().equals(adminUserName) && managerObj.getManagerPassword().equals(password);

    }
    public String getUserName(){

        return managerUI.getManagerUserNameForValidation();
    }

    public String getPassword(){

        return managerUI.getManagerPasswordForValidation();
    }
}
