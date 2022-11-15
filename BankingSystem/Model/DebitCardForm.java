package Model;

public class DebitCardForm {
    long accNum;
    String branchCode;
    String accountType;
    String cardHolderName;
    int userId;

    public String getAccountType() {
        return accountType;
    }

    public int getUserId() {
        return userId;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public DebitCardForm(long accNum, String branchCode, String accountType, String cardHolderName,int userId) {
        this.accNum = accNum;
        this.branchCode = branchCode;
        this.accountType = accountType;
        this.cardHolderName = cardHolderName;
        this.userId=userId;
    }

    public long getAccNum() {
        return accNum;
    }

    public void setAccNum(long accNum) {
        this.accNum = accNum;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    @Override
    public String toString() {
        return "DebitCardForm" +
                "\nAccNum=" + accNum +
                "\nBranchCode='" + branchCode +
                "\naccountType='" + accountType +
                "\ncardHolderName='" + cardHolderName +
                "\nUserId=" + userId ;
    }
}
