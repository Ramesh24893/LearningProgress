package Model;

public class LoanForm {
    private long accNumber;
    private String branchCode;
    private long amount;
    private String userId;

    public LoanForm(long accNumber, String branchCode, long amount, String userId) {
        this.accNumber = accNumber;
        this.branchCode = branchCode;
        this.amount = amount;
        this.userId=userId;
    }

    public String getUserId() {
        return userId;
    }

    public long getAccNumber() {
        return accNumber;
    }

    public long getAmount() {
        return amount;
    }


    public String getBranchCode() {
        return branchCode;
    }

    @Override
    public String toString() {
        return "\nLoanForm" +
                "\nAccNumber=" + accNumber +
                "\nBranchCode='" + branchCode +
                "\nAmount=" + amount +
                "\nUserId=" + userId ;
    }
}
