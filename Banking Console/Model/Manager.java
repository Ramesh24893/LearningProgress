package Model;
import java.util.HashMap;
import java.util.LinkedList;

public class Manager {
    private final String managerPassword="24893";
    private final String managerUserName="reeganth";

    HashMap<String,CreditCardForm> creditCardsReq=new HashMap<>();
    HashMap<String,DebitCardForm> debitCardsReq=new HashMap<>();
    HashMap<String,LoanForm> loansReq=new HashMap<>();
    HashMap<String,BranchChangeForm> branchChangeReq=new HashMap<>();
    public HashMap<String,BranchChangeForm> getBranchChangeReq() {
        return branchChangeReq;
    }
    public String getManagerPassword() {
        return managerPassword;
    }
    public String getManagerUserName() {
        return managerUserName;
    }
    public HashMap<String,LoanForm> getLoansReq() {
        return loansReq;
    }
    private Manager(){}
    static Manager admin=new Manager();
    public static Manager getInstance(){
        return admin;
    }
    public HashMap<String,CreditCardForm> getCreditCardsReq() {
        return creditCardsReq;
    }
    public HashMap<String,DebitCardForm> getDebitCardsReq() {
        return debitCardsReq;
    }

}
