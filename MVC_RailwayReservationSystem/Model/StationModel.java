package Model;

public class StationModel {


    int stationId;
    String stationName;
    public StationModel(String stationName, int stationId) {
        this.stationName = stationName;
        this.stationId = stationId;
    }
    public int getStationId() {
        return stationId;
    }

    public String getStationName() {
        return stationName;
    }
}
