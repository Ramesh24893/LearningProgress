public class Location {
    Station sourcePoint;
    Station Destination;
    public Location(Station sourcePoint, Station destination) {
        this.sourcePoint = sourcePoint;
        Destination = destination;
    }
    public Station getSourcePoint() {
        return sourcePoint;
    }

    public Station getDestination() {
        return Destination;
    }
}
