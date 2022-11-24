package Controller;

import Data.BankDataBase;
import Model.User;
import View.LoginUserUI;


import static Data.BankDataBase.bankDataBaseObj;

public class LoginUserController implements Login {

    private BankDataBase bankDataObj;
    private LoginUserUI logUserUI;
    public LoginUserController(BankDataBase bankDataObj, LoginUserUI logUserUI) {

        this.bankDataObj = bankDataObj;
        this.logUserUI = logUserUI;
    }

    public User login() {

        String userName=getUserName();
        if(!checkValidUserId(userName)){

            return null;
        }
        String userPassword=getPassword();

        if(!verify(userName,userPassword)){

            logUserUI.inValidUserNotification();
            return null;
        }

        return bankDataBaseObj.getUsers().get(userName);
    }
    public boolean checkValidUserId(String userId){
        if(!bankDataObj.getUsers().containsKey(userId)) {  //Checks whether userId exists in Users database

            logUserUI.noSuchUserNotification();
            return false;
        }

        return true;
    }
    public boolean verify( String userName, String password){

        User checkUser= bankDataBaseObj.getUsers().get(userName);
        return checkUser.getUserId().equals(userName) && checkUser.getPassword().equals(password);
    }

    public String getUserName(){

        return logUserUI.getUserNameForValidation();
    }
    public String getPassword(){

        return logUserUI.getUserPasswordForValidation();
    }

}
