package Model;

public class CreditCardForm {
    private long accNum;
    private String branchCode;
    private String accountType;
    private String cardHolderName;
    private String userId;

    public CreditCardForm(long accNum, String branchCode, String accountType, String cardHolderName,String userId) {
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

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "         CreditCardForm" +
                "\nAccNum         : " + accNum +
                "\nBranchCode     : " + branchCode +
                "\nAccountType    : " + accountType +
                "\nCardHolderName : " + cardHolderName +
                "\nUserId         : " + userId ;
    }
}
