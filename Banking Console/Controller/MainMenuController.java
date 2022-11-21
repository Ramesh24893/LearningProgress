package Controller;


import Data.BankDataBase;
import Model.User;
import View.*;

public class MainMenuController {
    public void menuController(){
        BankDataBase bankDataObj=BankDataBase.getInstance();

        UserInputUI userViewObj=new UserInputView();
        LoginUserUI logUserObj=new LoginUserView();

    boolean flow=true;

    BankLogoView.displayLogo();

    while(flow) {
        switch (new MainMenuView().MainMenuView()) {

            case 1:
                LoginUserController loginUserContObj=new LoginUserController(bankDataObj,logUserObj);
                User userObject = loginUserContObj.login();
                UserMenuController.userFeatures(bankDataObj,userViewObj,userObject);
                break;

                case 2:
                ManagerMenuController.managerFeatures(bankDataObj);
                break;

            case 3:
                UserRegistrationUI userRegObj=new UserRegistrationView();


                String newUserName= userRegObj.getNewUserName();
                String password=userRegObj.getNewPassword();

                User user=new User(newUserName,password);

                bankDataObj.getUsers().put(newUserName,user);
                userRegObj.userRegisteredNotification(user);

                User newUserObject=new User();
                UserMenuController.userFeatures(bankDataObj,userViewObj,newUserObject);
                break;

            case 4:

                flow=false;

        }
    }
    }
}
