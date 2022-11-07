package Controller;

import DataBase.RailwayDataBase;
import Model.AdminModel;
import Model.UserModel;
import View.AdminUI;
import View.UserUI;

public class LoginAccessController {
    UserUI userInputObj;
    AdminUI adminViewObject;
    RailwayDataBase railwayDataBaseObject;

    public LoginAccessController(UserUI userInputObj, RailwayDataBase railwayDataBaseObject) {
        this.userInputObj = userInputObj;
        this.railwayDataBaseObject = railwayDataBaseObject;
    }

    public LoginAccessController(AdminUI adminViewObject, RailwayDataBase railwayDataBaseObject) {
        this.adminViewObject = adminViewObject;
        this.railwayDataBaseObject = railwayDataBaseObject;
    }


    public UserModel loginUser() {



        int userId=userInputObj.getUserIdForValidation();
        if(!checkValidUserId(userId)){
            return null;
        }
        String userName=userInputObj.getUserNameForValidation();
        String userPassword=userInputObj.getAdminPasswordForValidation();
        if(!validateUser(userId,userName,userPassword)){
            userInputObj.inValidUserNotification();
            return null;
        }
        return railwayDataBaseObject.getUser(userId);
    }

    public boolean checkValidUserId(int userId){
        if(!railwayDataBaseObject.getUsers().containsKey(userId)) {  //Checks whether userId exists in Users database
            userInputObj.noSuchUserNotification();
            return false;
        }
        return true;
    }

    public boolean loginAdmin(){
        if (!validateAdmin(adminViewObject.getAdminUserNameForValidation(), adminViewObject.getAdminPasswordForValidation() )){
            adminViewObject.invalidDataNotification();
        }
        return false;
    }
    public void registerUser(){
        String newUserName= userInputObj.getNewUserName();
        String password=userInputObj.getNewPassword();

        UserModel user=new UserModel(newUserName,password);

        railwayDataBaseObject.getUsers().put(user.getUserId(),user);
        userInputObj.userRegisteredNotification();
        System.out.println(user);
    }
    public boolean validateUser(int userId, String userName, String password){
        UserModel checkUser= railwayDataBaseObject.getUsers().get(userId);
        return checkUser.getUsername().equals(userName) && checkUser.getPassword().equals(password);
    }
    public boolean validateAdmin(String adminUserName,int password){
        AdminModel admin=new AdminModel();
        return admin.getAdminUserName().equals(adminUserName) && admin.getAdminPassword() == (password);
    }


}
