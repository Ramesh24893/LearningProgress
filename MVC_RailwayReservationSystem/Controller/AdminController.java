package Controller;

import Model.*;
import View.AdminUI;
import View.AdminView;

import java.util.ArrayList;


public class AdminController {
    RailwayDataBaseModel railwayDataBaseObject;
    AdminUI adminViewObject;
    public AdminController(AdminUI adminViewObject, RailwayDataBaseModel railwayDataBaseObject) {
        this.adminViewObject=adminViewObject;
        this.railwayDataBaseObject = railwayDataBaseObject;
    }



    public RouteModel createRoute() {

        ArrayList<StationModel> route=new ArrayList<>();
        ArrayList<Integer> distance=new ArrayList<>();
        adminViewObject.displayAllStations(railwayDataBaseObject.getStations());
        int stationId=adminViewObject.getBoardingStationId();
        route.add(railwayDataBaseObject.getStation(stationId));
        int distanceBetweenStation;
        boolean flow=true;
        while(flow){
            switch(adminViewObject.canGetStationsInBetween()){
                case 1:

                    int inBetweenStation=adminViewObject.getStationInBetween();
                    route.add(railwayDataBaseObject.getStation(inBetweenStation));
                    distanceBetweenStation=adminViewObject.getDistance();
                    distance.add(distanceBetweenStation);
                    break;
                case 2:
                    flow=false;
                    break;
            }
        }
        int destinationStationId=adminViewObject.getDestinationStationId();
        route.add(railwayDataBaseObject.getStation(destinationStationId));
        distanceBetweenStation=adminViewObject.getDistance();
        distance.add(distanceBetweenStation);
        return new RouteModel(route,distance);
    }
    public void createStations(){
        RailwayDataBaseModel railwayDataBase=new RailwayDataBaseModel();
        adminViewObject.displayAllStations(railwayDataBaseObject.getStations());
        int count=adminViewObject.getCountOfNewStation();
        for(int i=0;i<count;i++) {
            int stationId = adminViewObject.getNewStationId();
            String stationName = adminViewObject.getNewStationName();
            StationModel newStation = new StationModel(stationName,stationId);
            railwayDataBase.addStation(newStation);
        }
    }
    public void createTrain() {
        RailwayDataBaseModel server = new RailwayDataBaseModel();

        TrainModel train = new TrainModel(adminViewObject.getTrainName(), adminViewObject.getTrainId(), createRoute(),adminViewObject.getNumOfSeats());
        server.addTrain(train);
    }

    public void displayAllTickets(){
        adminViewObject.displayAllTickets(railwayDataBaseObject.getTickets());
    }
    public void displayAllTrains(){
        adminViewObject.displayAllTrains(railwayDataBaseObject.getTrains());
    }


}
