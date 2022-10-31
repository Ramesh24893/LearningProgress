import java.util.HashMap;
public class RailwayDataBase {
    static HashMap<Integer,User> users=new HashMap<>();
    static HashMap<Integer,Station> stations=new HashMap<>();
    static HashMap<Integer,Train> trains=new HashMap<>();
    static HashMap<Integer, Ticket> tickets=new HashMap<>();
    public void addStation(Station station){
        stations.put(station.stationId,station);
    }
    public Station getStation(int stationId){
        return stations.get(stationId);
    }
    public User getUser(int userId){
        return users.get(userId);
    }
    public void addTrain(Train train){
        trains.put(train.trainId,train);
    }
    public Train getTrain(int id){
        return trains.get(id);
    }

    public Ticket getTicket(int id) {
        return tickets.get(id);
    }

}