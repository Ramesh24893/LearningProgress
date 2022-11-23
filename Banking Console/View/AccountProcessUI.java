package View;

import java.util.HashMap;
import java.util.Set;

public interface AccountProcessUI {

    String getBranchCode(Set<String> branches);
    String getName();
    long getMobileNum();
    long getExistingAccountNumber();
    long getIniDepositAmt();
    void existingAccountLinkingFailed();
    void existingAccountLinkingSuccessful();
    void accCreationSuccessfulNotification();
     String getFathersName();
     long getAadhaarNumber();
    String getPanNumber();
     String getCityName();
     int getAge();
     String getGender();

    void accDeletionMessage();
}
