package Controller;

import Data.BankDataBase;
import Model.User;
import View.UserView;

import static Data.BankDataBase.bankDataBaseObj;

public class LoginUserController {

    BankDataBase bankDataObj;
    UserView userViewObj;

    public LoginUserController(BankDataBase bankDataObj, UserView userViewObj) {
        this.bankDataObj = bankDataObj;
        this.userViewObj = userViewObj;
    }

    public User loginUser() {
        int userId=userViewObj.getUserIdForValidation();
        if(!checkValidUserId(userId)){
            return null;
        }
        String userName=userViewObj.getUserNameForValidation();
        String userPassword=userViewObj.getUserPasswordForValidation();
        if(!validateUser(userId,userName,userPassword)){
            userViewObj.inValidUserNotification();
            return null;
        }
        return bankDataBaseObj.getUsers().get(userId);
    }

    public boolean checkValidUserId(int userId){
        if(!bankDataBaseObj.getUsers().containsKey(userId)) {
            userViewObj.noSuchUserNotification();
            return false;
        }
        return true;
    }public boolean validateUser(int userId, String userName, String password){
        User checkUser= bankDataBaseObj.getUsers().get(userId);
        return checkUser.getUserName().equals(userName) && checkUser.getPassword().equals(password);
    }

}
