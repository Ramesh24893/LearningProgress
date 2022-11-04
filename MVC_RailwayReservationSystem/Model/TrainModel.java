package Model;

import java.util.*;
public class TrainModel {


    String name;
    int trainId;
    RouteModel route;
    ArrayList<SeatModel> seats=new ArrayList<>();
    int totalSeats;
    int seatsAvailable;
    public TrainModel(){
    }
    public TrainModel(String name, int trainId, RouteModel route, int totalSeats) {
        this.name = name;
        this.trainId = trainId;
        this.route = route;
        this.totalSeats = totalSeats;
        this.seatsAvailable = totalSeats;
        createSeats(totalSeats);

    }

    public int getTrainId() {
        return trainId;
    }

    public String getName() {
        return name;
    }
    public RouteModel getRoute() {
        return route;
    }
    public SeatModel getSeat(int seatNumber) {
        return seats.get(seatNumber-1);
    }

    public  Set<Integer> findAvailableSeats(LocationModel location, TrainModel train) {
        RailwayDataBaseModel server=new RailwayDataBaseModel();
        Set<Integer> availableSeatNumber=new HashSet<>();
        for(SeatModel seat: train.seats){
            if(seat.tickets.isEmpty()){
                availableSeatNumber.add(seat.seatNo);
            }
            else{
                t: for (TicketModel ticket : seat.tickets) {
                    StationModel boardingStation = server.getStation(ticket.getBoardingStationId());
                    StationModel destinationStation = server.getStation(ticket.getDestinationStationId());
                    int existingTicketBoardingStationPosition = route.stations.indexOf(boardingStation);
                    int existingTicketDestinationStationPosition = route.stations.indexOf(destinationStation);
                    int newTicketBoardingStationPosition = route.stations.indexOf(location.getSourcePoint());
                    int newTicketDestinationStationPosition = route.stations.indexOf(location.getDestinationPoint());
                    for (int start = existingTicketBoardingStationPosition; start < existingTicketDestinationStationPosition; start++) {
                        for (int stop = newTicketBoardingStationPosition; stop <= newTicketDestinationStationPosition; stop++) {
                            if (start == stop) {
                                break t;
                            }
                        }
                    }
                    availableSeatNumber.add(seat.seatNo);
                }
                }
                                   }
        return availableSeatNumber;
    }

    public void createSeats(int totalSeats){
        for(int index=1;index<=totalSeats;index++){
            this.seats.add(new SeatModel(index,new ArrayList<TicketModel>()));
        }
    }
    public int calculateDistance(LocationModel location, TrainModel train) {
        int startIndex = this.route.stations.indexOf(location.getSourcePoint());  //Stations are inserted in an order in ArrayList By using the index distance is calculated
        int stopIndex = this.route.stations.indexOf(location.getDestinationPoint());
        int totalDistance = 0;
        for (int i = startIndex; i < stopIndex; i++) {
            totalDistance += this.route.distance.get(i);
        }
       return totalDistance;

    }


}
































//    public int checkAvailability(Model.Location location) {
//        Model.RailwayDataBase server = new Model.RailwayDataBase();
//        int count = 0;
//
////        Iterator<Map.Entry<Integer, Model.Seat>> iterator = seats.entrySet().iterator();
////        while (iterator.hasNext()) {
////            Map.Entry<Integer, Model.Seat> seat = iterator.next();
//
//        for (Model.Seat seat : seats) {
//            if (seat.tickets.isEmpty()) {
//                count++;
//            } else {
//                for (Model.Ticket ticket : seat.tickets) {
//                    Model.Station boardingStation = server.getStation(ticket.boardingStationId);
//                    Model.Station destinationStation = server.getStation(ticket.destinationStationId);
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
//            for(Model.Seat seat: seats){
//
//                System.out.println("Model.Seat No:"+seat.seatNo);
//                for(Model.Ticket ticket: seat.tickets){
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
//            ArrayList<Model.Ticket> seat=new ArrayList<>();
//            seat.add(new Model.Ticket());
//            seats.put(index,new Model.Seat(index,seat));
//        }
//    }
//public ArrayList<Model.Seat> createSeat(int count){
//    ArrayList<Model.Seat> seats=new ArrayList<>();
//    for(int seatNo=1;seatNo<=count;seatNo++){
//        Model.Seat seat=new Model.Seat(seatNo,new ArrayList<>());
//        seats.add(seat);
//    }
//
//    return seats;





//                for(Model.Seat seat: train.seats){
//                    if(seat.tickets.isEmpty()){
//
//                        seat.tickets.add(passenger);
//                        passenger.setSeatNo(seat.seatNo);
//                        break;
//                    }
//                }