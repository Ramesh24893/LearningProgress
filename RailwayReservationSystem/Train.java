import java.util.ArrayList;

public class Train {
    String name;
    int trainId;
    Route route;
    int totalSeats;
    int seatsAvailable;
    public Train(){}
    public Train(String name, int trainId, Route route, int totalSeats) {
        this.name = name;
        this.trainId = trainId;
        this.route = route;
        this.totalSeats = totalSeats;
        this.seatsAvailable = totalSeats;
    }
    public Route getRoute(){
        return route;
    }
    public void dispalySeatsAvailable(Train train) {
        if(train.seatsAvailable<=0)
            System.out.println("No seats available");
        else
            System.out.println(train.seatsAvailable);
    }
    public void calculateDistance(Location location,Train train) {
        Server server=new Server();
        Default def = new Default();
        Route route=train.getRoute();
        ArrayList<Integer> dis=route.distance;
        ArrayList<Station> sta=route.stations;
        int startIndex=sta.indexOf(location.getSourcePoint());
        int stopIndex=sta.indexOf(location.getDestinationPoint());
        //System.out.println(start +"  "+ stop);
        int totalDistance=0;
        for(int i=startIndex;i<stopIndex;i++) {
            totalDistance+=dis.get(i);
        }
        System.out.println("Distance of travel is:"+totalDistance+" km");

    }
    public void reduceTicketCount(Train train) {
        train.seatsAvailable--;
    }
    public void increaseTicketCount(Train train) {
        train.seatsAvailable++;
    }

}