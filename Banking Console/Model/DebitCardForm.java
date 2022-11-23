package Model;

public class DebitCardForm {
    private long accNum;
    private String branchCode;
    private String accountType;
    private String cardHolderName;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public DebitCardForm(long accNum, String branchCode, String accountType, String cardHolderName,String userId) {
        this.accNum = accNum;
        this.branchCode = branchCode;
        this.accountType = accountType;
        this.cardHolderName = cardHolderName;
        this.userId=userId;
    }

    public long getAccNum() {
        return accNum;
    }

    public String getBranchCode() {
        return branchCode;
    }

    @Override
    public String toString() {
        return "          DebitCardForm" +
                "\nAccNum=" + accNum +
                "\nBranchCode='" + branchCode +
                "\naccountType='" + accountType +
                "\ncardHolderName='" + cardHolderName +
                "\nUserId=" + userId ;
    }
}
