package Model;
import java.time.LocalDate;
import java.util.LinkedList;

public class Account {
    private final String accHolderName;
    private final long accountNumber;
    private long mobileNumber;
    private String branchCode;
    private final String fatherName;
    private int age;
    private final String gender;
    private long aadhaar;
    private String panNum;
    private String city;
    private long balance;
    private LocalDate dateOfCreation;
    private int totalChargesPaid;
    private LinkedList<String> transactions=new LinkedList<>();
    private String accountType;
    private  int withdrawLimit;
    private  int depositLimit;
    private  int transferLimit;
    private int minBalance;
    private int overDraftLimit;
    private int debtAmt;
    private CreditCard creditCard;
    private DebitCard debitCard;
    private String linkedUserId;


    public Account(String accHolderName, long accountNumber, long mobileNumber, String ifscCode,String fatherName,int age,String gender,long aadhaar,String panNumber,String city ) {
        this.accHolderName = accHolderName;
        this.accountNumber = accountNumber;
        this.mobileNumber = mobileNumber;
        this.branchCode = ifscCode;
        this.fatherName=fatherName;
        this.age=age;
        this.gender=gender;
        this.aadhaar=aadhaar;
        this.panNum=panNumber;
        this.city=city;
    }

    public String getAccHolderName() {
        return accHolderName;
    }
    public long getAccountNumber() {
        return accountNumber;
    }
    public long getMobileNumber() {
        return mobileNumber;
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

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public int getTotalChargesPaid() {
        return totalChargesPaid;
    }

    public void setTotalChargesPaid(int totalChargesPaid) {
        this.totalChargesPaid = totalChargesPaid;
    }

    public LinkedList<String> getTransactions() {
        return transactions;
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

    public String getLinkedUserId() {
        return linkedUserId;
    }

    public void setLinkedUserId(String linkedUserId) {
        this.linkedUserId = linkedUserId;
    }

    public int getOverDraftLimit() {
        return overDraftLimit;
    }

    public void setOverDraftLimit(int overDraftLimit) {
        this.overDraftLimit = overDraftLimit;
    }

    public int getDebtAmt() {
        return debtAmt;
    }

    public void setDebtAmt(int debt) {
        this.debtAmt = debt;
    }


    @Override
    public String toString() {
        return
                        "\n\nAccountHolderName   : " + accHolderName +
                        "\nAccountNumber       : " + accountNumber +
                        "\nMobileNumber        : " + mobileNumber +
                        "\nBranchCode          : " + branchCode +
                        "\nFather Name         : " + fatherName+
                        "\nAge                 : " + age+
                        "\nGender              : " + gender+
                        "\nCity                : " + city+
                        "\nAadhaar Number      : " + aadhaar+
                        "\nPan Number          : " + panNum+
                        "\nBalance             : " + balance +
                        "\nDebt amount         : " + debtAmt +
                        "\nTax Payed           : "+ totalChargesPaid+
                        "\nOverDaftLimit       : "+ overDraftLimit +
                        "\nDateOfCreation      : " + dateOfCreation +
                        "\nAccountType         : " + accountType +
                        "\nCreditCard          : " + (creditCard==null?"Nil":"Yes") +
                        "\nDebitCard           : " + (debitCard==null?"Nil":"Yes") +
                        "\nLinked ID           : " + linkedUserId;

    }

}



