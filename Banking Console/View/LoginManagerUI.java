package View;

public interface LoginManagerUI {
    String getManagerUserNameForValidation();
    String getManagerPasswordForValidation();
    void invalidManagerLoginNotification();
    void invalidDataNotification();

}
