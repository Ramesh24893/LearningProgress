package Controller;

import Model.*;
import View.UserView;

import java.util.Scanner;
import java.util.Set;

public class UserController {
    UserModel userModelObject;
    UserView userInputViewObject;
    RailwayDataBaseModel railwayDataBaseObject=new RailwayDataBaseModel();

    public UserController(UserModel userModelObject, UserView userInputViewObject) {
        this.userModelObject = userModelObject;
        this.userInputViewObject = userInputViewObject;
    }
    public UserController(UserView userInputViewObject){
        this.userInputViewObject = userInputViewObject;
    }

//    public void bookTicket(UserModel user,LocationModel location){
//        userModelObject.bookTicket(user,location);
//    }
//    public void cancelTicket(UserModel user){
//        userModelObject.cancelTicket(user);
//    }
public void bookTicket(UserModel user, LocationModel location) {


    UserView userInputViewObject =new UserView();


    Scanner scannerObject = new Scanner(System.in);
    StationModel boardingStation = location.getSourcePoint();
    StationModel destinationStation = location.getDestinationPoint();

    int trainId = userInputViewObject.getTrainId();
    TrainModel train = railwayDataBaseObject.getTrain(trainId);
    Set<Integer> availableSeatsCount = train.findAvailableSeats(location, train);
    int requiredTicketCount = userInputViewObject.getNumOfTickets();
    //scannerObject.nextLine();

    if (availableSeatsCount.size() > 0 && requiredTicketCount <= availableSeatsCount.size()) {
        for (int index = 0; index < requiredTicketCount; index++) {

            String name = userInputViewObject.getNameFromUser();
            scannerObject.nextLine();
            int age = userInputViewObject.getAgeFromUser();
            TicketModel ticket = new TicketModel(name, age, boardingStation.getStationName(), boardingStation.getStationId(), destinationStation.getStationName(), destinationStation.getStationId(), trainId);
            railwayDataBaseObject.getTickets().put(ticket.getPassengerId(), ticket);
            user.getBookedTickets().put(ticket.getPassengerId(), ticket);
            for (Integer num : availableSeatsCount) {
                SeatModel seat = train.getSeat(num);
                seat.getTickets().add(ticket);
                ticket.setSeatNumber(num);
                availableSeatsCount.remove(num);
                break;
            }
            userInputViewObject.displayTicket(ticket);
        }
    } else {
        userInputViewObject.excessTickets(availableSeatsCount.size());

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
        for(TicketModel ticketObj: seat.getTickets()){
            if(ticketObj.getPassengerId()==cancelTicketId){
                ticketToBeRemoved=ticketObj;
            }
        }
        seat.getTickets().remove(ticketToBeRemoved);
        railwayDataBaseObject.getTickets().remove(cancelTicketId);
        user.getBookedTickets().remove(cancelTicketId);
        userInputViewObject.ticketCancelledNotification();

    }
    public void displayUserBookedTickets(UserModel user, UserView userInputViewObject){
        userInputViewObject.displayUserBookedTickets(user);
    }
//    public int getUserIdForValidation(){
//        int userIdForValidation = userInputViewObject.getUserIdForValidation();
//
//    }
//
//
//    public String getUserNameForValidation() {
//    }
//
//    public String getAdminPasswordForValidation() {
//    }
//
//    public void inValidUserNotification() {
//        userInputViewObject.inValidUserNotification();
//    }


//    public UserModel loginUser() {
//        RailwayDataBaseModel railwayDataBase=new RailwayDataBaseModel();
//        Validation validation=new Validation();
//
//        int userId=userInputViewObject.getUserIdForValidation();
//        if(!checkValidUserId(userId)){
//            return null;
//        }
//        String userName=userInputViewObject.getUserNameForValidation();
//        String userPassword=userInputViewObject.getAdminPasswordForValidation();
//        if(!validation.validateUser(userId,userName,userPassword)){
//            userInputViewObject.inValidUserNotification();
//            return null;
//        }
//        return railwayDataBase.getUser(userId);
//    }
//    public boolean checkValidUserId(int userId){
//        RailwayDataBaseModel server=new RailwayDataBaseModel();
//        if(!RailwayDataBaseModel.getUsers().containsKey(userId)) {  //Checks whether userId exists in Users database
//            userInputViewObject.noSuchUserNotification();
//            return false;
//        }
//        return true;
//    }
}
