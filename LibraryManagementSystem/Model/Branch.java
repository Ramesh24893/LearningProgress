package Model;

import java.util.ArrayList;

public class Branch {
    String branchName;
    String ifscCode;
    ArrayList<Integer> accounts;
    int reserveAmount;
    int branchProfit;

    public Branch(String branchName, String branchCode, ArrayList<Integer> accounts, int reserveAmount, int branchProfit) {
        this.branchName = branchName;
        this.ifscCode = branchCode;
        this.accounts = accounts;
        this.reserveAmount = reserveAmount;
        this.branchProfit = branchProfit;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getBranchCode() {
        return ifscCode;
    }

    public ArrayList<Integer> getAccounts() {
        return accounts;
    }

    public int getReserveAmount() {
        return reserveAmount;
    }

    public int getBranchProfit() {
        return branchProfit;
    }
}
