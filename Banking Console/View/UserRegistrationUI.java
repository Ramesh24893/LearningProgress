package View;

import Model.User;

public interface UserRegistrationUI {
    String getNewUserName();
    String getNewPassword();
    void userRegisteredNotification(User user);

    void userIdExistNotification();
}
