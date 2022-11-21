package View;

import Model.User;

public interface LoginUserUI {
    String getUserNameForValidation();
    String getUserPasswordForValidation();
    void inValidUserNotification();
    void noSuchUserNotification();

}
