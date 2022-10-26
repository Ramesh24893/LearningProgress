package IRCTC;

import java.util.ArrayList;


public class Route {
    ArrayList<Station> stations;
     ArrayList<Integer> distance;
    // public Route(){}

    public Route(ArrayList<Station> stations, ArrayList<Integer> distance) {
        this.stations = stations;
        this.distance = distance;
    }
    public boolean isStationContains(Station startingPoint,Station endPoint ){
        boolean startFlag=false;
        boolean endFlag=false;
        for(Station station: stations){

            if(station.equals(startingPoint)){
                startFlag=true;
            }
            if(station.equals(endPoint)){
                endFlag=true;
            }
        }
        if(startFlag & endFlag){
            return true;
        }
        else{
            return false;
        }
    }
}
