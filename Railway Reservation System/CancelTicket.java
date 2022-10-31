import java.util.Scanner;

public class CancelTicket {
    public void cancelTicket(User user) {
        RailwayDataBase server=new RailwayDataBase();
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your id to cancel Ticket");
        int id=sc.nextInt();
        Ticket ticket=server.getTicket(id);
        int seatNo=ticket.seatNo;
        Train train=server.getTrain(ticket.trainId);
        Seat seat=train.getSeat(seatNo);
        Ticket ticketToBeRemoved=null;
        for(Ticket tic: seat.tickets){
            if(tic.passengerId==id){
                ticketToBeRemoved=tic;
            }
        }
        seat.tickets.remove(ticketToBeRemoved);
        server.tickets.remove(id);
        user.bookedTickets.remove(id);
        System.out.println("*************************************************");
        System.out.println("Ticket is cancelled");
        System.out.println("*************************************************");
    }
}
