package View;

public interface LoginUserUI {
    String getUserNameForValidation();
    String getUserPasswordForValidation();
    void inValidUserNotification();
    void noSuchUserNotification();


}
