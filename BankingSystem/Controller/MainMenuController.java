package Controller;

import Data.BankDataBase;
import Model.User;
import View.*;

public class MainMenuController {
    public void menuController(){
        BankDataBase bankDataObj=BankDataBase.getInstance();
        UserView userViewObj=new UserView();
    boolean flow=true;
    while(flow) {
        switch (MainMenuView.MainMenuView()) {
            case 1:
                UserMenuController.userFeatures(bankDataObj,userViewObj);
                break;
            case 2:
                ManagerMenuController.managerFeatures(bankDataObj);
                break;
            case 3:
                String newUserName= userViewObj.getNewUserName();
                String password=userViewObj.getNewPassword();
                User user=new User(newUserName,password);
                bankDataObj.getUsers().put(user.getUserId(),user);
                userViewObj.userRegisteredNotification(user);
                break;
            case 4:
                flow=false;

        }
    }
    }
}
