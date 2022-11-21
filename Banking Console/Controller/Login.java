package Controller;

public interface Login {

    Object login();
    String getUserName();
    String getPassword();
    boolean verify(String userName,String password);


}
