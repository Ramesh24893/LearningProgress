package Model;

public class LocationModel {
    StationModel sourcePoint;
    StationModel destinationPoint;
    public LocationModel(StationModel sourcePoint, StationModel destinationPoint) {
        this.sourcePoint = sourcePoint;
        this.destinationPoint = destinationPoint;
    }
    public StationModel getSourcePoint() {
        return sourcePoint;
    }

    public StationModel getDestinationPoint() {
        return destinationPoint;
    }

}
