package Controller;

import Data.BankDataBase;
import Model.User;
import View.LoginUserUI;


import static Data.BankDataBase.bankDataBaseObj;

public class LoginUserController implements Login {

    BankDataBase bankDataObj;
    LoginUserUI logUserObj;

    public LoginUserController(BankDataBase bankDataObj, LoginUserUI logUserObj) {

        this.bankDataObj = bankDataObj;
        this.logUserObj = logUserObj;
    }

    public User login() {

        String userName=getUserName();
        if(!checkValidUserId(userName)){

            return null;
        }
        String userPassword=getPassword();

        if(!verify(userName,userPassword)){

            logUserObj.inValidUserNotification();
            return null;
        }

        return bankDataBaseObj.getUsers().get(userName);
    }
    public boolean checkValidUserId(String userId){
        if(!bankDataObj.getUsers().containsKey(userId)) {  //Checks whether userId exists in Users database

            logUserObj.noSuchUserNotification();
            return false;
        }

        return true;
    }
    public boolean verify( String userName, String password){

        User checkUser= bankDataBaseObj.getUsers().get(userName);
        return checkUser.getUserId().equals(userName) && checkUser.getPassword().equals(password);
    }

    public String getUserName(){

        return logUserObj.getUserNameForValidation();
    }
    public String getPassword(){

        return logUserObj.getUserPasswordForValidation();
    }

}
