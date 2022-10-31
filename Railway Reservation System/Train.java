
import java.util.*;
public class Train {
    String name;
    int trainId;
    Route route;
    ArrayList<Seat> seats=new ArrayList<>();
    int totalSeats;
    int seatsAvailable;
    public Train(){
    }
    public Train(String name, int trainId, Route route, int totalSeats) {
        this.name = name;
        this.trainId = trainId;
        this.route = route;
        this.totalSeats = totalSeats;
        this.seatsAvailable = totalSeats;
        createSeats(totalSeats);

    }
    public Seat getSeat(int seatNumber) {
        return seats.get(seatNumber-1);
    }

    public  Set<Integer> findAvailableSeats(Location location,Train train){
        RailwayDataBase server=new RailwayDataBase();
        Set<Integer> availableSeatNum=new HashSet<>();
        int count=0;
        int num=0;
        for(Seat seat: train.seats){
            num++;
            if(seat.tickets.isEmpty()){
                //count++;
                availableSeatNum.add(seat.seatNo);
                //System.out.println(count);
            }
            else{
               t: for (Ticket ticket : seat.tickets) {
                    Station boardingStation = server.getStation(ticket.boardingStationId);
                    Station destinationStation = server.getStation(ticket.destinationStationId);
                    int start = route.stations.indexOf(boardingStation);

                    int stop = route.stations.indexOf(destinationStation);

                    int newStart = route.stations.indexOf(location.getSourcePoint());

                    int newStop = route.stations.indexOf(location.getDestinationPoint());

                    for (int i = start; i < stop; i++) {
                        for (int j = newStart; j <= newStart; j++) {
                            if (i == j) {
                                break t;
                            }
                        }
                    }
                   availableSeatNum.add(seat.seatNo);
                }
            }
        }
        return availableSeatNum;
    }
    public void createSeats(int totalSeats){
        for(int index=1;index<=totalSeats;index++){
            this.seats.add(new Seat(index,new ArrayList<Ticket>()));
        }

    }
    public Route getRoute() {
        return route;
    }
    public void calculateDistance(Location location, Train train) {
        RailwayDataBase server = new RailwayDataBase();
        Default def = new Default();
        Route route = train.getRoute();
        ArrayList<Integer> dis = route.distance;
        ArrayList<Station> sta = route.stations;
        int startIndex = sta.indexOf(location.getSourcePoint());
        int stopIndex = sta.indexOf(location.getDestinationPoint());
        //System.out.println(start +"  "+ stop);
        int totalDistance = 0;
        for (int i = startIndex; i < stopIndex; i++) {
            totalDistance += dis.get(i);
        }
        System.out.println("Distance of travel is:" + totalDistance + " km");

    }


}
































//    public int checkAvailability(Location location) {
//        RailwayDataBase server = new RailwayDataBase();
//        int count = 0;
//
////        Iterator<Map.Entry<Integer, Seat>> iterator = seats.entrySet().iterator();
////        while (iterator.hasNext()) {
////            Map.Entry<Integer, Seat> seat = iterator.next();
//
//        for (Seat seat : seats) {
//            if (seat.tickets.isEmpty()) {
//                count++;
//            } else {
//                for (Ticket ticket : seat.tickets) {
//                    Station boardingStation = server.getStation(ticket.boardingStationId);
//                    Station destinationStation = server.getStation(ticket.destinationStationId);
//                    int start = route.stations.indexOf(boardingStation);
//                    int stop = route.stations.indexOf(destinationStation);
//                    int newStart = route.stations.indexOf(location.getSourcePoint());
//                    int newStop = route.stations.indexOf(location.getDestinationPoint());
//                    for (int i = start; i < stop; i++) {
//                        for (int j = newStart; j <= newStart; j++) {
//                            if (i == j) {
//                                break;
//                            }
//                        }
//                    }
//                    count++;
//                }
//            }
//
//        }
//        return count;
//    }
//    public void assignSeat(){
//    }
//    public void displaySeat(){
//        try{
//            for(Seat seat: seats){
//
//                System.out.println("Seat No:"+seat.seatNo);
//                for(Ticket ticket: seat.tickets){
//                    System.out.println("Tickets");
//                    System.out.println(ticket);
//                }
//            }}
//        catch(Exception e){
//
//        }
//    }
//    public void createSeats(){
//        for(int index=1;index<=totalSeats;index++){
//            ArrayList<Ticket> seat=new ArrayList<>();
//            seat.add(new Ticket());
//            seats.put(index,new Seat(index,seat));
//        }
//    }
//public ArrayList<Seat> createSeat(int count){
//    ArrayList<Seat> seats=new ArrayList<>();
//    for(int seatNo=1;seatNo<=count;seatNo++){
//        Seat seat=new Seat(seatNo,new ArrayList<>());
//        seats.add(seat);
//    }
//
//    return seats;





//                for(Seat seat: train.seats){
//                    if(seat.tickets.isEmpty()){
//
//                        seat.tickets.add(passenger);
//                        passenger.setSeatNo(seat.seatNo);
//                        break;
//                    }
//                }