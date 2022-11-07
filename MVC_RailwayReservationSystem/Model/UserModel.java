package Model;

import java.util.HashMap;

public class UserModel {
    static int num = 1;
    private int userId;
    private String username;
    private String password;
    public HashMap<Integer, TicketModel> getBookedTickets() {
        return bookedTickets;
    }
    HashMap<Integer, TicketModel> bookedTickets = new HashMap<>();
    public UserModel(String username, String password) {
        this.userId = num++;
        this.username = username;
        this.password = password;
    }
    public int getUserId() {
        return userId;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    @Override
    public String toString() {
        return "UserId: " + userId +
                "\nUsername: " + username +
                "\nPassword: " + password;
    }

}