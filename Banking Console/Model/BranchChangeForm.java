package Model;

public class BranchChangeForm {
    private long accountNumber;
    private String currentBranchCode;
    private String newBranchCode;
    private String userId;

    public BranchChangeForm(long accountNumber, String currentBranchCode, String newBranchCode, String userId) {
        this.accountNumber = accountNumber;
        this.currentBranchCode = currentBranchCode;
        this.newBranchCode = newBranchCode;
        this.userId=userId;
    }

    public String getUserId() {
        return userId;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getNewBranchCode() {
        return newBranchCode;
    }

    public void setNewBranchCode(String newBranchCode) {
        this.newBranchCode = newBranchCode;
    }

    public String getCurrentBranchCode() {
        return currentBranchCode;
    }

    public void setCurrentBranchCode(String currentBranchCode) {
        this.currentBranchCode = currentBranchCode;
    }

    @Override
    public String toString() {
        return  "\nBranchChangeForm" +
                "\nAccountNumber:" + accountNumber +
                "\nCurrentBranchCode:" + currentBranchCode +
                "\nNewBranchCode='" + newBranchCode +
                "\nUserId=" + userId;
    }
}
