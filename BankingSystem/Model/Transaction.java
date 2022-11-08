package Model;

public class Transaction {
    int transactionId;
    int fromAccNum;
    int toAccountNum;
    int transactionDate;
    int accountBalance;
    int charge;
    String transactionMode;
    public Transaction(int transactionId, int fromAccNum, int toAccountNum, int transactionDate, int accountBalance, int charge, String transactionMode) {
        this.transactionId = transactionId;
        this.fromAccNum = fromAccNum;
        this.toAccountNum = toAccountNum;
        this.transactionDate = transactionDate;
        this.accountBalance = accountBalance;
        this.charge = charge;
        this.transactionMode = transactionMode;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public int getFromAccNum() {
        return fromAccNum;
    }

    public int getToAccountNum() {
        return toAccountNum;
    }

    public int getTransactionDate() {
        return transactionDate;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public int getCharge() {
        return charge;
    }

    public String getTransactionMode() {
        return transactionMode;
    }
}
