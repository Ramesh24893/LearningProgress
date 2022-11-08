package Model;

import java.util.Date;
import java.util.List;

public class Account {
    long accountNumber;
    int accountId;
    int mobileNumber;
    String address;
    String email;
    String branchCode;
    String accountType;
    String balance;
    Date dateCreated;
    int TotalChargesPaid;
    int debtAmount;
    int minimumBalance;
    List<Transaction> transactions;

    public Account(long accountNumber, int accountId, int mobileNumber, String address, String email, String branchCode, String accountType, String balance, Date dateCreated, int totalChargesPaid, int debtAmount, int minimumBalance, List<Transaction> transactions) {
        this.accountNumber = accountNumber;
        this.accountId = accountId;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.email = email;
        this.branchCode = branchCode;
        this.accountType = accountType;
        this.balance = balance;
        this.dateCreated = dateCreated;
        TotalChargesPaid = totalChargesPaid;
        this.debtAmount = debtAmount;
        this.minimumBalance = minimumBalance;
        this.transactions = transactions;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getBalance() {
        return balance;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public int getTotalChargesPaid() {
        return TotalChargesPaid;
    }

    public int getDebtAmount() {
        return debtAmount;
    }

    public int getMinimumBalance() {
        return minimumBalance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
