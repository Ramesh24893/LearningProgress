package Controller;

import Model.LocationModel;
import Model.RailwayDataBaseModel;
import Model.RouteModel;
import Model.TrainModel;
import View.SearchUI;
import View.SearchView;
import View.UserView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class SearchController {
    RailwayDataBaseModel railwayDataBaseObject;
    SearchUI searchViewObject;
    UserView userViewObject;

    public SearchController(RailwayDataBaseModel railwayDataBaseObject, SearchUI searchViewObject, UserView userViewObject) {
        this.railwayDataBaseObject = railwayDataBaseObject;
        this.searchViewObject = searchViewObject;
        this.userViewObject = userViewObject;
    }

    public boolean displayAvailableTrains(LocationModel location) {
        ArrayList<TrainModel> availableTrains=findAvailableTrains(location);
        if(availableTrains.isEmpty()){
            searchViewObject.noTrainAvailableNotification();
            return true;
        }
        for(TrainModel train: availableTrains) {
            searchViewObject.displayTrainData(train.getName(),train.getTrainId(),train.findAvailableSeats(location,train).size(),train.calculateDistance(location,train));
        }
        return false;
    }
    public ArrayList<TrainModel> findAvailableTrains(LocationModel location){
        ArrayList<TrainModel> list=new ArrayList<>();
        Iterator< Map.Entry<Integer, TrainModel>> iterator= railwayDataBaseObject.getTrains().entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, TrainModel> ite=iterator.next();
            RouteModel route=ite.getValue().getRoute();
            if(route.stopsMatchingWithExistingStop(location)){
                list.add(railwayDataBaseObject.getTrain(ite.getKey()));
            }
        }
        return list;
    }
    public LocationModel getLocationFromUser(){
        RailwayDataBaseModel railwayDataBase=new RailwayDataBaseModel();
        userViewObject.displayAllStations(railwayDataBaseObject.getStations());
        SearchView searchModelView=new SearchView();
        int boardingStationId = searchModelView.getBoardingStationId();
        int destinationStationId = searchModelView.getDestinationStationId();
        return new LocationModel(railwayDataBase.getStation(boardingStationId), railwayDataBase.getStation(destinationStationId));
    }
}
