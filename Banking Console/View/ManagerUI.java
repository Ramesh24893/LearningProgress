package View;

public interface ManagerUI {
    String getManagerUserNameForValidation();
    String getManagerPasswordForValidation();
    void invalidManagerLoginNotification();
    void invalidDataNotification();

}
