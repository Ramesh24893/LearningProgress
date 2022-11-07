package Controller;

import DataBase.RailwayDataBase;
import Model.*;
import View.UserView;
import java.util.Set;
public class UserController {
    UserModel userModelObject;
    UserView userInputViewObject;
    RailwayDataBase railwayDataBaseObject=new RailwayDataBase();
    public UserController(UserModel userModelObject, UserView userInputViewObject) {
        this.userModelObject = userModelObject;
        this.userInputViewObject = userInputViewObject;
    }
    public void bookTicket(UserModel user, LocationModel location) {


    UserView userInputViewObject =new UserView();
    SearchController searchControllerObject=new SearchController();

    StationModel boardingStation = location.getSourcePoint();
    StationModel destinationStation = location.getDestinationPoint();

    int trainId = userInputViewObject.getTrainId();
    if(!railwayDataBaseObject.getTrains().containsKey(trainId)){
        System.out.println("No such train exists");
        System.out.println("You can't book ticket");
        return;
    }
    TrainModel train = railwayDataBaseObject.getTrain(trainId);
    Set<Integer> availableSeatsCount = searchControllerObject.findAvailableSeats(location, train);
    int requiredTicketCount = userInputViewObject.getNumOfTickets();


    if (availableSeatsCount.size() > 0 && requiredTicketCount <= availableSeatsCount.size()) {
        for (int index = 0; index < requiredTicketCount; index++) {

            String name = userInputViewObject.getNameFromUser();
            int age = userInputViewObject.getAgeFromUser();
            TicketModel ticket = new TicketModel(name, age, boardingStation.getStationName(), boardingStation.getStationId(), destinationStation.getStationName(), destinationStation.getStationId(), trainId);
            railwayDataBaseObject.getTickets().put(ticket.getPassengerId(), ticket);
            user.getBookedTickets().put(ticket.getPassengerId(), ticket);
            for (Integer num : availableSeatsCount) {
                SeatModel seat = train.getSeat(num);
                RailwayDataBase.seatTickets.get(seat).add(ticket);
                ticket.setSeatNumber(num);
                availableSeatsCount.remove(num);
                break;
            }
            userInputViewObject.displayTicket(ticket);
        }
    } else {
        userInputViewObject.excessTickets();
    }
    userInputViewObject.displayAvailableSeats(availableSeatsCount.size());
}
    public void cancelTicket(UserModel user) {

        UserView userInputViewObject =new UserView();


        int cancelTicketId=userInputViewObject.getCancelTicketId();
        TicketModel ticket=railwayDataBaseObject.getTicket(cancelTicketId);
        int seatNo=ticket.getSeatNo();
        TrainModel train=railwayDataBaseObject.getTrain(ticket.getTrainId());
        SeatModel seat=train.getSeat(seatNo);
        TicketModel ticketToBeRemoved=null;
        for(TicketModel ticketObj: RailwayDataBase.seatTickets.get(seat)){
            if(ticketObj.getPassengerId()==cancelTicketId){
                ticketToBeRemoved=ticketObj;
            }
        }
        RailwayDataBase.seatTickets.get(seat).remove(ticketToBeRemoved);
        railwayDataBaseObject.getTickets().remove(cancelTicketId);
        user.getBookedTickets().remove(cancelTicketId);
        userInputViewObject.ticketCancelledNotification();

    }
    public void displayUserBookedTickets(UserModel user, UserView userInputViewObject){
        userInputViewObject.displayUserBookedTickets(user);
    }
}
