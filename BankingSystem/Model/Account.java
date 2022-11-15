package Model;
import java.time.LocalDate;
import java.util.LinkedList;

public class Account {
    private String accHolderName;
    private long accountNumber;
    private long mobileNumber;
    private String branchCode;
    private long balance;
    private LocalDate dateOfCreation ;
    private int TotalChargesPaid;
    private LinkedList<String> transactions=new LinkedList<>();

    private String accountType;
    private  int withdrawLimit;
    private  int depositLimit;
    private  int transferLimit;
    private int minBalance;
    private CreditCard creditCard;
    private DebitCard debitCard;
    private int linkedUserId;
    public Account(String accHolderName, long accountNumber, long mobileNumber, String ifscCode, long balance) {
        this.accHolderName = accHolderName;
        this.accountNumber = accountNumber;
        this.mobileNumber = mobileNumber;
        this.branchCode = ifscCode;
        this.balance = balance;
    }

    public String getAccHolderName() {
        return accHolderName;
    }

    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public int getTotalChargesPaid() {
        return TotalChargesPaid;
    }

    public void setTotalChargesPaid(int totalChargesPaid) {
        TotalChargesPaid = totalChargesPaid;
    }

    public LinkedList<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(LinkedList<String> transactions) {
        this.transactions = transactions;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(int withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public int getDepositLimit() {
        return depositLimit;
    }

    public void setDepositLimit(int depositLimit) {
        this.depositLimit = depositLimit;
    }

    public int getTransferLimit() {
        return transferLimit;
    }

    public void setTransferLimit(int transferLimit) {
        this.transferLimit = transferLimit;
    }

    public int getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(int minBalance) {
        this.minBalance = minBalance;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public DebitCard getDebitCard() {
        return debitCard;
    }

    public void setDebitCard(DebitCard debitCard) {
        this.debitCard = debitCard;
    }

    public int getLinkedUserId() {
        return linkedUserId;
    }

    public void setLinkedUserId(int linkedUserId) {
        this.linkedUserId = linkedUserId;
    }

    @Override
    public String toString() {
        return
                "\n\nAccountHolderName: " + accHolderName +
                "\nAccountNumber:" + accountNumber +
                "\nMobileNumber: " + mobileNumber +
                "\nBranchCode " + branchCode +
                "\nBalance " + balance +
                "\nDateOfCreation " + dateOfCreation +
                        "\nAccountType " + accountType +
                        "\nCreditCard " + (creditCard==null?"Nil":"Yes") +
                "\nDebitCard " + (debitCard==null?"Nil":"Yes") ;
    }





}



