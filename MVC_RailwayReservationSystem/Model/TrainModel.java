package Model;

import DataBase.RailwayDataBase;

import java.util.*;
public class TrainModel {
    String name;
    int trainId;
    RouteModel route;
    ArrayList<SeatModel> seats=new ArrayList<>();

    public ArrayList<SeatModel> getSeats() {
        return seats;
    }

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


    public void createSeats(int totalSeats){
        for(int index=1;index<=totalSeats;index++){
            SeatModel seat=new SeatModel(index);
            this.seats.add(seat);
            RailwayDataBase.seatTickets.put(seat,new ArrayList<TicketModel>());
        }
    }



}
































//    public int checkAvailability(Model.Location location) {
//        Model.DataBase.RailwayDataBase server = new Model.DataBase.RailwayDataBase();
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