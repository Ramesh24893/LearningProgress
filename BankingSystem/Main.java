package Main;


import Controller.MainMenuController;
import Data.InitialData;


public class Main {
    public static void main(String[] args) {
        InitialData.initialData();
        MainMenuController mainMenuController =new MainMenuController();
        mainMenuController.menuController();
    }



}


