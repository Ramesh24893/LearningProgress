package Model;

public class BranchChangeForm {
    long accountNumber;
    String currentBranchCode;
    String newBranchCode;
    String accountType;
    int userId;

    public BranchChangeForm(long accountNumber, String currentBranchCode, String newBranchCode, int userId) {
        this.accountNumber = accountNumber;
        this.currentBranchCode = currentBranchCode;
        this.newBranchCode = newBranchCode;
        this.userId=userId;
    }

    public int getUserId() {
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

    public String getAccountType() {
        return accountType;
    }

    public String getCurrentBranchCode() {
        return currentBranchCode;
    }

    public void setCurrentBranchCode(String currentBranchCode) {
        this.currentBranchCode = currentBranchCode;
    }

    @Override
    public String toString() {
        return "\nBranchChangeFormModel" +
                "\n\nAccountNumber:" + accountNumber +
                "CurrentBranchCode:" + currentBranchCode +
                "NewBranchCode='" + newBranchCode +
                "AccountType='" + accountType +
                "UserId=" + userId;
    }
}
