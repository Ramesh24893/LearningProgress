package View;

import Model.AdminModel;
import Model.RailwayDataBaseModel;
import Model.UserModel;

public class ValidationView {
    RailwayDataBaseModel railwayDataBaseObject;

    public ValidationView(RailwayDataBaseModel railwayDataBaseObject) {
        this.railwayDataBaseObject = railwayDataBaseObject;
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