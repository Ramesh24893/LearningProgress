package StartAppliction;

import Controller.MainMenuController;
import Data.InitialData;


public class Start {
    public static void main(String[] args) {
        InitialData.initialData();
        MainMenuController mainMenuController =new MainMenuController();
        mainMenuController.menuController();
    }
}


