package View;

import Model.*;
import java.util.*;

public class AdminView implements AdminUI {
    Scanner scannerObject=new Scanner(System.in);
    public String getAdminUserNameForValidation(){
        System.out.println("Enter the Admin username");
        return scannerObject.nextLine();
    }
    public int getAdminPasswordForValidation(){
        System.out.println("Enter the Admin password");
        return scannerObject.nextInt();
    }
    public void invalidDataNotification(){
        System.out.println("Invalid admin data");
    }
    public  void displayAllTrains(HashMap<Integer, TrainModel> trains){
        for (Map.Entry<Integer, TrainModel> train : trains.entrySet()) {
            System.out.print(train.getKey() + "     ");
            System.out.println(train.getValue().getName());
        }
    }
    public  void displayAllTickets(HashMap<Integer, TicketModel> tickets){
        Iterator< Map.Entry<Integer, TicketModel>> iterator=tickets.entrySet().iterator();
        System.out.println("------------------------------------------------------");
        System.out.println("Booked Tickets are");
        System.out.println("------------------------------------------------------");
        while(iterator.hasNext()){
            Map.Entry<Integer, TicketModel> ticket=iterator.next();

            System.out.println("TicketID "+ticket.getKey());
            System.out.println(ticket.getValue());
            System.out.println("----------------------------------------------------");
        }
    }
    public void displayAllStations(HashMap<Integer, StationModel> stations){
        System.out.println("***********************************************");
        System.out.println("Already existing stations");
        System.out.println("***********************************************");
        Iterator< Map.Entry<Integer, StationModel>> iterator= stations.entrySet().iterator();
        System.out.println("StationID       Name" );
        while(iterator.hasNext()){
            Map.Entry<Integer, StationModel> station=iterator.next();
            System.out.print("    "+station.getKey()+"         ");
            System.out.println(station.getValue().getStationName());
        }
    }

    public  int getDistance() {
        System.out.println("Enter the distance between newly added station and previous station");
        return scannerObject.nextInt();
    }

    public int getBoardingStationId(){
        System.out.println("Create a route");
        System.out.println("Enter the Boarding Point station  ID");
        return scannerObject.nextInt();
    }

    public int canGetStationsInBetween(){
        System.out.println("Type 1 to add another Station between Destination Point");
        System.out.println("Type 2 to don't add Station between Destination Point");
        return scannerObject.nextInt();
    }
    public int getDestinationStationId(){
        System.out.println("Enter the Destination Point station ID");
        return scannerObject.nextInt();
    }
    public int getStationInBetween(){
        System.out.println("Enter the station Id");
        return scannerObject.nextInt();
    }

    public int getNewStationId(){
        System.out.println("Enter the station id");
        return scannerObject.nextInt();
    }
    public String getNewStationName(){
        System.out.println("Enter the station name");
        return scannerObject.next();
    }
    public int getCountOfNewStation(){
        System.out.println("Enter number of stations to add in database");
        return  scannerObject.nextInt();
    }
    public String getTrainName(){
        System.out.println("Enter the train name");
        return scannerObject.nextLine();
    }
    public int getTrainId(){
        System.out.println("Enter the train ID");
        return scannerObject.nextInt();
    }
    public int getNumOfSeats(){
        System.out.println("Enter total number of seats in the train ");
        return scannerObject.nextInt();
    }

}
