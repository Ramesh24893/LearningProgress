package Controller;

import Model.RailwayDataBaseModel;
import Model.UserModel;
import View.AdminUI;
import View.AdminView;
import View.UserUI;
import View.ValidationView;

public class LoginAccessController {
    UserUI userInputObj;
    AdminUI adminViewObject;
    RailwayDataBaseModel railwayDataBaseObject;

    public LoginAccessController(UserUI userInputObj, RailwayDataBaseModel railwayDataBaseObject) {
        this.userInputObj = userInputObj;
        this.railwayDataBaseObject = railwayDataBaseObject;
    }

    public LoginAccessController(AdminUI adminViewObject, RailwayDataBaseModel railwayDataBaseObject) {
        this.adminViewObject = adminViewObject;
        this.railwayDataBaseObject = railwayDataBaseObject;
    }
//    LoginAccessModel loginAccessModelObject=new LoginAccessModel();
//    public void loginAdmin(LoginAccessModel loginAccessModelObject){
//        loginAccessModelObject.loginAdmin();
//    }
//    public void loginUser(LoginAccessModel loginAccessModelObject){
//        loginAccessModelObject.loginUser();
//    }


    public UserModel loginUser() {

        ValidationView validation=new ValidationView(railwayDataBaseObject);

        int userId=userInputObj.getUserIdForValidation();
        if(!checkValidUserId(userId)){
            return null;
        }
        String userName=userInputObj.getUserNameForValidation();
        String userPassword=userInputObj.getAdminPasswordForValidation();
        if(!validation.validateUser(userId,userName,userPassword)){
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
        ValidationView validation=new ValidationView(railwayDataBaseObject);
        if (!validation.validateAdmin(adminViewObject.getAdminUserNameForValidation(), adminViewObject.getAdminPasswordForValidation() )){
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


}
