package Model;

import java.util.ArrayList;
public class SeatModel {


    int seatNo;

    ArrayList <TicketModel> tickets;

    public SeatModel(int seatNo, ArrayList<TicketModel> tickets) {
        this.seatNo = seatNo;
        this.tickets = tickets;
    }
    public ArrayList<TicketModel> getTickets() {
        return tickets;
    }
    public int getSeatNo() {
        return seatNo;
    }


}
