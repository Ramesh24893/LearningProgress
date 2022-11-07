package Controller;

import DataBase.RailwayDataBase;
import Model.*;
import View.SearchUI;
import View.SearchView;
import View.UserView;
import java.util.*;


public class SearchController {
    RailwayDataBase railwayDataBaseObject;
    SearchUI searchViewObject;
    UserView userViewObject;

    public SearchController(RailwayDataBase railwayDataBaseObject, SearchUI searchViewObject, UserView userViewObject) {
        this.railwayDataBaseObject = railwayDataBaseObject;
        this.searchViewObject = searchViewObject;
        this.userViewObject = userViewObject;
    }
    public SearchController(){

    }

    public boolean displayAvailableTrains(LocationModel location) {
        ArrayList<TrainModel> availableTrains=findAvailableTrains(location);
        if(availableTrains.isEmpty()){
            searchViewObject.noTrainAvailableNotification();
            return true;
        }
        for(TrainModel train: availableTrains) {
            int distance=calculateDistance(location,train);
            searchViewObject.displayTrainData(train.getName(),train.getTrainId(),findAvailableSeats(location,train).size(),distance,calculateBaseFare(distance),calculateTime(distance));
        }
        return false;
    }
    public ArrayList<TrainModel> findAvailableTrains(LocationModel location){
        ArrayList<TrainModel> list=new ArrayList<>();
        Iterator< Map.Entry<Integer, TrainModel>> trains= railwayDataBaseObject.getTrains().entrySet().iterator();
        while(trains.hasNext()){
            Map.Entry<Integer, TrainModel> train=trains.next();
            RouteModel route=train.getValue().getRoute();
            if(stopsMatchingWithExistingStop(location,route)){
                list.add(railwayDataBaseObject.getTrain(train.getKey()));
            }
        }
        return list;
    }
    public LocationModel getLocationFromUser(){
        RailwayDataBase railwayDataBase=new RailwayDataBase();
        userViewObject.displayAllStations(railwayDataBaseObject.getStations());
        SearchView searchModelView=new SearchView();
        int boardingStationId = searchModelView.getBoardingStationId();
        int destinationStationId = searchModelView.getDestinationStationId();
        return new LocationModel(railwayDataBase.getStation(boardingStationId), railwayDataBase.getStation(destinationStationId));
    }
    public boolean stopsMatchingWithExistingStop(LocationModel location,RouteModel route ){
        boolean startFlag=false;
        boolean endFlag=false;
        StationModel boardingStation=location.getSourcePoint();
        StationModel destinationStation=location.getDestinationPoint();
        for(StationModel station: route.getStations()){

            if(station.equals(boardingStation)){
                startFlag=true;
            }
            if(startFlag){
                if(station.equals(destinationStation)){
                    endFlag=true;
                }}
        }
        if(startFlag & endFlag){
            return true;
        }
        else{
            return false;
        }
    }


    public int calculateBaseFare(int distance){
        int fare;
        fare=(distance/100)*100;
        return fare/2;
    }
    public int calculateTime(int distance){
        return distance/100;
    }



    public Set<Integer> findAvailableSeats(LocationModel location, TrainModel train) {
        RailwayDataBase server=new RailwayDataBase();
        Set<Integer> availableSeatNumber=new HashSet<>();
        for(SeatModel seat: train.getSeats()){
            if(RailwayDataBase.seatTickets.get(seat).isEmpty()){
                availableSeatNumber.add(seat.getSeatNo());
            }
            else{
                t: for (TicketModel ticket : RailwayDataBase.seatTickets.get(seat)) {
                    StationModel boardingStation = server.getStation(ticket.getBoardingStationId());
                    StationModel destinationStation = server.getStation(ticket.getDestinationStationId());
                    int existingTicketBoardingStationPosition = train.getRoute().getStations().indexOf(boardingStation);
                    int existingTicketDestinationStationPosition = train.getRoute().getStations().indexOf(destinationStation);
                    int newTicketBoardingStationPosition = train.getRoute().getStations().indexOf(location.getSourcePoint());
                    int newTicketDestinationStationPosition = train.getRoute().getStations().indexOf(location.getDestinationPoint());
                    for (int start = existingTicketBoardingStationPosition; start < existingTicketDestinationStationPosition; start++) {
                        for (int stop = newTicketBoardingStationPosition; stop <= newTicketDestinationStationPosition; stop++) {
                            if (start == stop) {
                                break t;
                            }
                        }
                    }
                    availableSeatNumber.add(seat.getSeatNo());
                }
            }
        }
        return availableSeatNumber;
    }
    public int calculateDistance(LocationModel location, TrainModel train) {
        int startIndex = train.getRoute().getStations().indexOf(location.getSourcePoint());  //Stations are inserted in an order in ArrayList By using the index distance is calculated
        int stopIndex = train.getRoute().getStations().indexOf(location.getDestinationPoint());
        int totalDistance = 0;
        for (int i = startIndex; i < stopIndex; i++) {
            totalDistance += train.getRoute().getDistance().get(i);
        }
        return totalDistance;

    }
}
