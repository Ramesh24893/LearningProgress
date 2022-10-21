import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Server {
    public static HashMap<Integer,User> users=new HashMap<>() ;
    public static HashMap<Integer,Station> stations=new HashMap<>();
    public static HashMap<Integer,Train> trains=new HashMap<>();
    public void addStation(Station station){
        stations.put(station.stationId,station);
    }
    public Station getStation(int stationId){
        System.out.println(stations.get(stationId));
        return stations.get(stationId);
    }
    public void addTrain(Train train){
        trains.put(train.trainId,train);
    }
    public void displayStations(){

        Iterator < Map.Entry<Integer,Station>>iterator=stations.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,Station> station=iterator.next();
            System.out.print(station.getKey()+"     ");
            System.out.println(station.getValue().stationName);

        }
    }

}
