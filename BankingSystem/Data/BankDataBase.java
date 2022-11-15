package Data;
import Model.Account;
import Model.Branch;
import Model.Manager;
import Model.User;

import java.util.HashMap;

public class BankDataBase {

    final private  HashMap<Integer, User> users=new HashMap<>();
    final private  HashMap<String, Branch> branches=new HashMap<>();
    final private HashMap<Long, Account> accounts=new HashMap<>();
    final private  Manager manager= Manager.getInstance();

     private BankDataBase(){

    }

    public Manager getManager() {
        return manager;
    }

    public static BankDataBase bankDataBaseObj=new BankDataBase();
    public static BankDataBase getInstance(){
        return bankDataBaseObj;
    }

    public  HashMap<Long, Account> getAccounts() {
        return accounts;
    }
    public HashMap<Integer, User> getUsers() {
        return users;
    }



    public  HashMap<String, Branch> getBranches() {
        return branches;
    }







}
