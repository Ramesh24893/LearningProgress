package Model;

public class User {
    private String userName;
    private String password;
    private int userId;
    private int accountId;
    public User(String userName, String password, int userId, int accountId) {
        this.userName = userName;
        this.password = password;
        this.userId = userId;
        this.accountId = accountId;
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

    public int getAccountId() {
        return accountId;
    }
}
