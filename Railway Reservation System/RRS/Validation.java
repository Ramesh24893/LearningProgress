package IRCTC;

public class Validation {
    public boolean validateUser(int userId,String userName,int password){
        User checkUser=Server.users.get(userId);
        if(checkUser.getUsername()==userName && checkUser.getPassword()==password){
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
