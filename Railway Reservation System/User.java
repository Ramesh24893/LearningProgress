import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class User {
    static int num=1;
    private int userId;
    private String username;
    private String password;
    HashMap<Integer, Ticket> bookedTickets=new HashMap<>();
    public User(){}
    public User( String username, String password) {
        this.userId = num++;
        this.username = username;
        this.password = password;
    }
    public int getUserId() {return userId;}
    public String getUsername() {return username;}
    public String getPassword() {return password;}

    @Override
    public String toString() {
        return  "UserId: " + userId +
                "\nUsername: " + username +
                "\nPassword: " + password;
    }


    public void displayUserBookedTickets(User user){
        Iterator<Map.Entry<Integer, Ticket>> iterator=user.bookedTickets.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Ticket> tickets= iterator.next();
            System.out.println("TicketID "+tickets.getKey());
            System.out.println(tickets.getValue());
            System.out.println("----------------------------------------------------");
        }
    }

}
