import java.util.Scanner;
public class Booking {

    public void bookTicket(int trainId,User user) {
        Scanner sc=new Scanner(System.in);
        Server server=new Server();

                    Train train=server.getTrain(trainId);
                    System.out.println("Enter number of tickets to book");
                    int count=sc.nextInt();
                    if(train.seatsAvailable>0 && count<=train.seatsAvailable){
                    for(int i=0;i<count;i++){
                        sc.nextLine();
                    System.out.println("Enter the name");
                    String name=sc.nextLine();
                    System.out.println("Enter the age");
                    int age=sc.nextInt();
                    Passenger passenger=new Passenger(name,age,trainId);
                    Server.tickets.put(passenger.passengerId, passenger);
                    user.bookedTickets.put(passenger.passengerId,passenger);

                        System.out.println("----------------------------------\n-------------------------------------");
                    System.out.println("Your ticket is booked");
                    train.reduceTicketCount(train);
                    System.out.println(passenger);
                    }
                    }
                    else{
                        System.out.println("You cant book ticket");
                        System.out.println("Only "+ train.seatsAvailable+" seats are available");
                    }

        System.out.println("Seats Left: "+train.seatsAvailable);
}

    public void cancelTicket(User user) {
        Server server=new Server();
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your id to cancel Ticket");
        int id=sc.nextInt();
        Train train=server.getTrain(server.getTicket(id).trainId);
        train.increaseTicketCount(train);
        server.tickets.remove(id);
        user.bookedTickets.remove(id);
    }


}
