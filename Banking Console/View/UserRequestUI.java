package View;

public interface UserRequestUI {
    void requestSubmissionNotification(String form);
    long getLoanAmount();
    void invalidRequestNotification(String cardType);
    String getNewBranchCode();

    void reqAlreadySubmitted();
}
