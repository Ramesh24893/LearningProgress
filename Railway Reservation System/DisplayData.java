import java.util.Iterator;
import java.util.Map;

public class DisplayData {
    RailwayDataBase railwayDataBase=new RailwayDataBase();
    public void displayAllStations(){
        Iterator< Map.Entry<Integer,Station>> iterator=railwayDataBase.stations.entrySet().iterator();
        System.out.println("StationID       Name" );
        while(iterator.hasNext()){
            Map.Entry<Integer,Station> station=iterator.next();
            System.out.print("    "+station.getKey()+"         ");
            System.out.println(station.getValue().stationName);
        }
    }
    public void displayAllTrains(){
        Iterator < Map.Entry<Integer,Train>>iterator=railwayDataBase.trains.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,Train> train=iterator.next();
            System.out.print(train.getKey()+"     ");
            System.out.println(train.getValue().name);
        }
    }
    public void displayAllTickets(){
        Iterator < Map.Entry<Integer, Ticket>>iterator=railwayDataBase.tickets.entrySet().iterator();
        System.out.println("------------------------------------------------------");
        System.out.println("Booked Tickets are");
        System.out.println("------------------------------------------------------");
        while(iterator.hasNext()){
            Map.Entry<Integer, Ticket> ticket=iterator.next();

            System.out.println("TicketID "+ticket.getKey());
            System.out.println(ticket.getValue());
            System.out.println("----------------------------------------------------");
        }
    }
}
