package Model;

import java.util.LinkedList;


public class User {
    static int num=1;
    private String userName;
    private String password;
    private  int userId;
    private LinkedList<String> messages =new LinkedList<>();
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        userId=num++;
    }
    public User(){

    }
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getUserId() {
        return userId;
    }

    public LinkedList<String> getMessages() {
        return messages;
    }

    @Override
    public String toString() {
        return
                "UserName='" + userName +
                "\nPassword='" + password +
                "\nUserId=" + userId +
                        "\nLinked Account :"+(account!=null?account.getAccountNumber():"Nil" );
    }
}








//private int walletAmt;

//    public int getCurrentAccountId() {
//        return currentAccountId;
//    }
//
//    public int getSavingsAccountId() {
//        return savingsAccountId;
//    }

//    public int getWallet() {
//        return walletAmt;
//    }

//    public void setCurrentAccountId(int currentAccountId) {
//        this.currentAccountId = currentAccountId;
//    }
//
//    public void setSavingsAccountId(int savingsAccountId) {
//        this.savingsAccountId = savingsAccountId;
//    }

//    public void setWallet(int walletAmt) {
//        this.walletAmt = walletAmt;
//    }