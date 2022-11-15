package Model;

public class CreditCardForm {
    long accNum;
    String branchCode;
    String accountType;
    String cardHolderName;
    int userId;

    public CreditCardForm(long accNum, String branchCode, String accountType, String cardHolderName,int userId) {
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

    public String getAccountType() {
        return accountType;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "\nCreditCardForm" +
                "\nAccNum=" + accNum +
                "\nBranchCode='" + branchCode + '\'' +
                "\nAccountType='" + accountType + '\'' +
                "\nCardHolderName='" + cardHolderName + '\'' +
                "\nUserId=" + userId ;
    }
}
