package IRCTC;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Server {
    public static HashMap<Integer,User> users=new HashMap<>() ;
    public static HashMap<Integer,Station> stations=new HashMap<>();
    public static HashMap<Integer,Train> trains=new HashMap<>();
    public static HashMap<Integer,Passenger> tickets=new HashMap<>();
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
    public Train getTrain(int id) {return trains.get(id);} 
    
    public Passenger getTicket(int id) {return tickets.get(id);}
    public void displayStations(){

        Iterator < Map.Entry<Integer,Station>>iterator=stations.entrySet().iterator();
        System.out.println("StationID       Name" );
        while(iterator.hasNext()){
            Map.Entry<Integer,Station> station=iterator.next();
            System.out.print("    "+station.getKey()+"         ");
            System.out.println(station.getValue().stationName);

        }
    }
    public void displayTrains(){

        Iterator < Map.Entry<Integer,Train>>iterator=trains.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,Train> train=iterator.next();
            System.out.print(train.getKey()+"     ");
            System.out.println(train.getValue().name);

        }
    }
    public void displayTickets(){

        Iterator < Map.Entry<Integer,Passenger>>iterator=tickets.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,Passenger> train=iterator.next();
            System.out.print(train.getKey()+"     ");
            System.out.println(train.getValue().name);

        }
    }
    

}