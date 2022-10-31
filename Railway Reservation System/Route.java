import java.util.ArrayList;
public class Route {
    ArrayList<Station> stations;
     ArrayList<Integer> distance;
     public Route(ArrayList<Station> stations, ArrayList<Integer> distance) {
        this.stations = stations;
        this.distance = distance;
    }
    public boolean isStationContains(Location location ){
        boolean startFlag=false;
        boolean endFlag=false;
        Station boardingStation=location.getSourcePoint();
        Station destinationStation=location.getDestinationPoint();
        for(Station station: stations){

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
