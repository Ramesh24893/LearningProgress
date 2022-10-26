package IRCTC;

public class Location {
    Station sourcePoint;
    Station destination;
    public Location(Station sourcePoint, Station destination) {
        this.sourcePoint = sourcePoint;
        this.destination = destination;
    }
    public Station getSourcePoint() {
        return sourcePoint;
    }

    public Station getDestination() {
        return destination;
    }
}
