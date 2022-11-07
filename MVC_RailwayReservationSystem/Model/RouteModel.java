package Model;

import java.util.ArrayList;
public class RouteModel {
    ArrayList<StationModel> stations;
     ArrayList<Integer> distance;

    public ArrayList<StationModel> getStations() {
        return stations;
    }

    public ArrayList<Integer> getDistance() {
        return distance;
    }

    public RouteModel(ArrayList<StationModel> stations, ArrayList<Integer> distance) {
        this.stations = stations;
        this.distance = distance;
    }

}
