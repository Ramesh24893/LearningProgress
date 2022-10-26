package IRCTC;

public class Station {
    int stationId;
    String stationName;
    public Station(String stationName, int stationId) {
        this.stationName = stationName;
        this.stationId = stationId;
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationId=" + stationId +
                ", stationName='" + stationName + '\'' +
                '}';
    }
}
