import java.util.*;

public class User {
    static int num=1;
    private int userId;
    private String username;
    private int password;
    HashMap<Integer,Passenger> bookedTickets=new HashMap<>();
    public User(){}
    public User( String username, int password) {
        this.userId = num++;
        this.username = username;
        this.password = password;
    }
    public int getUserId() {return userId;}
    public String getUsername() {return username;}
    public int getPassword() {return password;}

    @Override
    public String toString() {
        return
                "UserId: " + userId +
                "\nUsername: " + username +
                "\nPassword: " + password;
    }

    public void displayUserBookedTickets(User user){
        Iterator<Map.Entry<Integer,Passenger>> iterator=user.bookedTickets.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,Passenger> tickets= iterator.next();
            System.out.println("TicketID "+tickets.getKey());
            System.out.println(tickets.getValue());
            System.out.println("----------------------------------------------------");
        }
    }
}
