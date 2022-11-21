package View;

import java.util.HashMap;

public interface AccountProcessUI {
    HashMap<String,String> userInputsForAccGen();
    String getBranchCode();
    String getName();
    String getMobileNum();
    String getExistingAccountNumber();
    String getIniDepositAmt();
    HashMap<String,String> userInputsToLinkAcc();
    void existingAccountLinkingFailed();
    void existingAccountLinkingSuccessful();
    void invalidBranchDataNotification();
    void accCreationSuccessfulNotification();

}
