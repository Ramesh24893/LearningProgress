package Controller;

public interface BankTransactionDataGenerator {
    String generateWithDrawTransactionData(long amount, long accountBalance, long taxAmount);
    String generateDepositTransactionData(long amount,long accountBalance,long taxAmount);
    String generateSenderTransactionData(long amount,long receiverAccountNum,long accountBalance,long taxAmount);
     String generateReceiverTransactionData(long amount,long senderAccountNum,long accountBalance);

}
