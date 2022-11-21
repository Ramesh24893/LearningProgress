package View;

import java.util.LinkedList;

public interface TransactionUI {
   int getAmountForTransaction();
    void displayReceipt(String receipt);
    long getReceiverAccountNumber();
    void displayAllTransactions(LinkedList<String> transactions);
    void transactionSuccessMessage();
     void transactionFailedMessage();
    void depositLimitedReachedNotification(long limit);
     void withdrawLimitReachedNotification(long limit);
    void transferLimitReachedNotification(long limit);
    void branchLimitReached(long branchResAmt);

}
