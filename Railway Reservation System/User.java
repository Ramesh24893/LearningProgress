public class User {
    private int userId;
    private String username;
    private int password;
    public User(int userId, String username, int password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }
    public int getUserId() {return userId;}
    public String getUsername() {return username;}
    public int getPassword() {return password;}
}
