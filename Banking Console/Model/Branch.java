package Model;


import java.util.ArrayList;

public class Branch {
   private String branchName;
    private String branchCode;
    private ArrayList<Long> accounts=new ArrayList<>();
    private long reserveAmount;
    private int branchProfit=0;

    public Branch(String branchName, long reserveAmount, String branchCode) {
        this.branchName = branchName;
        this.branchCode = branchCode;
        this.reserveAmount = reserveAmount;

    }
    public String getBranchName() {
        return branchName;
    }

    public String getBranchCode() {
        return branchCode;
    }
    public ArrayList<Long>  getAccounts() {
        return accounts;
    }
    public long getReserveAmount() {
        return reserveAmount;
    }
    public int getBranchProfit() {
        return branchProfit;
    }
    public void setReserveAmount(long reserveAmount) {
        this.reserveAmount = reserveAmount;
    }
    public void setBranchProfit(int branchProfit) {
        this.branchProfit = branchProfit;
    }

    @Override
    public String toString() {
        return "BranchName :" + branchName  +
                "\nIFSC Code='" + branchCode +
                "\nAccounts=" + accounts +
                "\nReserveAmount=" + reserveAmount +
                "\nBranchProfit=" + branchProfit;
    }
}
