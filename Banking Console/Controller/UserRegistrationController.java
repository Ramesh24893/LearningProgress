package Controller;

import Data.BankDataBase;
import Model.User;
import View.UserRegistrationUI;

public class UserRegistrationController {

    private UserRegistrationUI userRegUI;
    private BankDataBase bankDataObj;

    public UserRegistrationController(UserRegistrationUI userRegUI, BankDataBase bankDataObj) {

        this.userRegUI = userRegUI;
        this.bankDataObj = bankDataObj;
    }

    User register() {
        String newUserName;
        int count=1;
        do {
            if(count>1){
                userRegUI.userIdExistNotification();
            }
            newUserName = getUserName();
            count++;
        }
        while(isUserIdExists(newUserName));

        String password= getPassword();

        return createUserAcc(newUserName,password);

    }

    private boolean isUserIdExists(String newUserName){
        return bankDataObj.getUsers().containsKey(newUserName);
    }
    private String getUserName() {

        return userRegUI.getNewUserName();
    }

    private String getPassword() {

        return userRegUI.getNewPassword();
    }

    private User createUserAcc(String newUserName,String password) {
        User userObj=new User(newUserName,password);

        bankDataObj.getUsers().put(newUserName,userObj);
        userRegUI.userRegisteredNotification(userObj);

        return userObj;
    }

}
