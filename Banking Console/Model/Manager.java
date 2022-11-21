package Model;
import java.util.LinkedList;

public class Manager {
    final String managerPassword="24893";
    final String managerUserName="reeganth";

    LinkedList<CreditCardForm> creditCardsReq=new LinkedList<>();
    LinkedList<DebitCardForm> debitCardsReq=new LinkedList();
    LinkedList<LoanForm> loansReq =new LinkedList<>();
    LinkedList<BranchChangeForm> branchChangeReq=new LinkedList<>();
    public LinkedList<BranchChangeForm> getBranchChangeReq() {
        return branchChangeReq;
    }
    public String getManagerPassword() {
        return managerPassword;
    }
    public String getManagerUserName() {
        return managerUserName;
    }
    public LinkedList<LoanForm> getLoansReq() {
        return loansReq;
    }
    private Manager(){}
    static Manager admin=new Manager();
    public static Manager getInstance(){
        return admin;
    }
    public LinkedList<CreditCardForm> getCreditCardsReq() {
        return creditCardsReq;
    }
    public LinkedList<DebitCardForm> getDebitCardsReq() {
        return debitCardsReq;
    }

}
