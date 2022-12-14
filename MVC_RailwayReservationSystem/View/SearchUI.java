package View;

public interface SearchUI {
    public int getBoardingStationId();
    public int getDestinationStationId();
    public void noTrainAvailableNotification();
    public void displayTrainData(String trainName, int id, int size, int trainId, int seatsAvailable, int distance);
}
