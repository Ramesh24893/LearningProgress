package Model;

import Model.Branch;

import java.util.List;

public class Bank {
    String bankName;
    int bankId;
    int totalAmount;
    List<Branch> branchesList;

    public Bank(String bankName, int bankId, int totalAmount, List<Branch> branchesList) {
        this.bankName = bankName;
        this.bankId = bankId;
        this.totalAmount = totalAmount;
        this.branchesList = branchesList;
    }
}
