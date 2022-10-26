package IRCTC;

public class Train {
    String name;
    int trainId;
    Route route;
    int totalSeats;
    int seatsAvailable;
    public Train(){}
    public Train(String name, int trainId, Route route, int totalSeats, int seatsAvailable) {
        this.name = name;
        this.trainId = trainId;
        this.route = route;
        this.totalSeats = totalSeats;
        this.seatsAvailable = seatsAvailable;
    }
    public Route getRoute(){
        return route;
    }
    public void dispalySeatsAvailable(Train train) {
    	System.out.println(train.seatsAvailable);
    }

}