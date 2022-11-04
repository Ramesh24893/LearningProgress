package Model;

import java.util.HashMap;

public class UserModel {
    static int num=1;
    private int userId;
    private String username;
    private String password;

    public HashMap<Integer, TicketModel> getBookedTickets() {
        return bookedTickets;
    }


    HashMap<Integer, TicketModel> bookedTickets=new HashMap<>();
    public UserModel(){}
    public UserModel(String username, String password) {
        this.userId = num++;
        this.username = username;
        this.password = password;
    }
    public int getUserId() {return userId;}
    public String getUsername() {return username;}
    public String getPassword() {return password;}

   // UserController userControllerObjject =new UserController();

//    public LocationModel getLocationFromUser(){
//        RailwayDataBaseModel railwayDataBase=new RailwayDataBaseModel();
//        DisplayAllStations.displayAllStations(RailwayDataBaseModel.getStations());
//        SearchModelView searchModelView=new SearchModelView();
//        int boardingStationId = searchModelView.getBoardingStationId();
//        int destinationStationId = searchModelView.getDestinationStationId();
//        return new LocationModel(railwayDataBase.getStation(boardingStationId), railwayDataBase.getStation(destinationStationId));
//    }





    @Override
    public String toString() {
        return  "UserId: " + userId +
                "\nUsername: " + username +
                "\nPassword: " + password;
    }


//    public void bookTicket(UserModel user, LocationModel location) {
//
//
//        UserInputView userInputViewObject =new UserInputView();
//
//
//        Scanner scannerObject = new Scanner(System.in);
//        StationModel boardingStation = location.getSourcePoint();
//        StationModel destinationStation = location.getDestinationPoint();
//
//        RailwayDataBaseModel railwayDataBaseObject = new RailwayDataBaseModel();
//        int trainId = userInputViewObject.getTrainId();
//        TrainModel train = railwayDataBaseObject.getTrain(trainId);
//        Set<Integer> availableSeatsCount = train.findAvailableSeats(location, train);
//        int requiredTicketCount = userInputViewObject.getNumOfTickets();
//        //scannerObject.nextLine();
//
//        if (availableSeatsCount.size() > 0 && requiredTicketCount <= availableSeatsCount.size()) {
//            for (int index = 0; index < requiredTicketCount; index++) {
//
//                String name = userInputViewObject.getNameFromUser();
//                scannerObject.nextLine();
//                int age = userInputViewObject.getAgeFromUser();
//                TicketModel ticket = new TicketModel(name, age, boardingStation.getStationName(), boardingStation.getStationId(), destinationStation.getStationName(), destinationStation.getStationId(), trainId);
//                RailwayDataBaseModel.getTickets().put(ticket.getPassengerId(), ticket);
//                user.getBookedTickets().put(ticket.getPassengerId(), ticket);
//                for (Integer num : availableSeatsCount) {
//                    SeatModel seat = train.getSeat(num);
//                    seat.getTickets().add(ticket);
//                    ticket.setSeatNumber(num);
//                    availableSeatsCount.remove(num);
//                    break;
//                }
//                userInputViewObject.displayTicket(ticket);
//            }
//        } else {
//            userInputViewObject.excessTickets(availableSeatsCount.size());
//
//        }
//        userInputViewObject.displayAvailableSeats(availableSeatsCount.size());
//    }
//    public void cancelTicket(UserModel user) {
//
//        UserInputView userInputViewObject =new UserInputView();
//
//
//        RailwayDataBaseModel railwayDataBaseObject=new RailwayDataBaseModel();
//        int cancelTicketId=userInputViewObject.getCancelTicketId();
//        TicketModel ticket=railwayDataBaseObject.getTicket(cancelTicketId);
//        int seatNo=ticket.getSeatNo();
//        TrainModel train=railwayDataBaseObject.getTrain(ticket.getTrainId());
//        SeatModel seat=train.getSeat(seatNo);
//        TicketModel ticketToBeRemoved=null;
//        for(TicketModel ticketObj: seat.getTickets()){
//            if(ticketObj.getPassengerId()==cancelTicketId){
//                ticketToBeRemoved=ticketObj;
//            }
//        }
//        seat.getTickets().remove(ticketToBeRemoved);
//        RailwayDataBaseModel.getTickets().remove(cancelTicketId);
//        user.getBookedTickets().remove(cancelTicketId);
//        userInputViewObject.ticketCancelledNotification();
//
//    }




//    public void displayUserBookedTickets(User user){
//        Iterator<Map.Entry<Integer, Ticket>> iterator=user.bookedTickets.entrySet().iterator();
//        while(iterator.hasNext()){
//            Map.Entry<Integer, Ticket> tickets= iterator.next();
//            System.out.println("TicketID "+tickets.getKey());
//            System.out.println(tickets.getValue());
//            System.out.println("----------------------------------------------------");
//        }
//    }

}
