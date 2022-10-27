public class Location {
    Station sourcePoint;
    Station destinationPoint;
    public Location(Station sourcePoint, Station destinationPoint) {
        this.sourcePoint = sourcePoint;
        this.destinationPoint = destinationPoint;
    }
    public Station getSourcePoint() {
        return sourcePoint;
    }

    public Station getDestinationPoint() {
        return destinationPoint;
    }
}
