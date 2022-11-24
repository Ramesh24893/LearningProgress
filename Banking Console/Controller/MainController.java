package Controller;

import Data.BankDataBase;
import Model.User;
import View.*;

public class MainController {
    public void main() {
        BankDataBase bankDataObj = BankDataBase.getInstance();

        UserInputUI userInputUI = new UserInputView();
        LoginUserUI logUserUI = new LoginUserView();

        boolean flow = true;

        BankLogoUI bankLogoUI = new BankLogoView();
        bankLogoUI.displayLogo();

        while (flow) {
            switch (new MainMenuView().MainMenuView()) {

                case 1:
                    LoginUserController loginUserContObj = new LoginUserController(bankDataObj, logUserUI);
                    User userObject = loginUserContObj.login();

                    UserController.showUserFeatures(bankDataObj, userInputUI, userObject);
                    break;

                case 2:
                    ManagerController.showManagerFeatures(bankDataObj);
                    break;

                case 3:
                    UserRegistrationUI userRegUI = new UserRegistrationView();
                    UserRegistrationController userRegisObj = new UserRegistrationController(userRegUI, bankDataObj);

                    User userObj = userRegisObj.register();
                    UserController.showUserFeatures(bankDataObj, userInputUI, userObj);
                    break;

                case 4:
                    flow = false;

            }
        }
    }}
