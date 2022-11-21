package View;

import Model.Account;
import Model.Branch;
import Model.User;

import java.util.HashMap;
import java.util.LinkedList;

public interface UserInputUI {

    void displayAccountStatus(Account account);
    void displayMessages(LinkedList<String> messages);
    void displayBranches(HashMap<String, Branch> branchesList);

    void displayAvailableBalance(long balance);
}
