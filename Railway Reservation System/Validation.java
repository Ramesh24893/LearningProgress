

public class Validation {
    public boolean validateUser(int userId,String userName,String password){
        User checkUser= RailwayDataBase.users.get(userId);
        if(checkUser.getUsername().equals(userName) && checkUser.getPassword().equals(password)){
            return true;
        }
        return false;
    }
    public boolean validateAdmin(String adminUserName,int password){
        Admin admin=new Admin();
        if(admin.getAdminUserName().equals(adminUserName) && admin.getAdminPassword()==(password)){
            return true;
        }
        return false;
    }

}