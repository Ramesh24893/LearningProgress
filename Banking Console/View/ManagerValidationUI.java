package View;

import Model.*;

import java.util.HashMap;

public interface ManagerValidationUI {

    String showLoanRequest(LoanForm loanForm);
    String showBranchChangeRequest(BranchChangeForm branchChangeForm);
    String showDebitCardRequest(DebitCardForm debitCardForm);
    String showCreditCardRequest(CreditCardForm creditCardForm);
    String validateRequest();
    void displayAllBranchStats(HashMap<String, Branch> branches);
    void formAcceptedNotification();
    void formRejectedNotification();
}
