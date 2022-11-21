package Model;

import java.util.LinkedList;


public class User {

    private String userId;
    private String password;
    private LinkedList<String> messages =new LinkedList<>();
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
    public User(){

    }
    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }
    public LinkedList<String> getMessages() {
        return messages;
    }

    @Override
    public String toString() {
        return
                "\nUserName: " + userId +
                "\nPassword: " + password +
                        "\nLinked Bank Account :"+(account!=null?account.getAccountNumber():"No account Linked" );
    }
}
