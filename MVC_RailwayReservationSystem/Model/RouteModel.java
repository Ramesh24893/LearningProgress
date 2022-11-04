package Model;

import java.util.ArrayList;
public class RouteModel {
    ArrayList<StationModel> stations;
     ArrayList<Integer> distance;
     public RouteModel(ArrayList<StationModel> stations, ArrayList<Integer> distance) {
        this.stations = stations;
        this.distance = distance;
    }
    public boolean stopsMatchingWithExistingStop(LocationModel location ){
        boolean startFlag=false;
        boolean endFlag=false;
        StationModel boardingStation=location.getSourcePoint();
        StationModel destinationStation=location.getDestinationPoint();
        for(StationModel station: stations){

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
}
