import java.util.*;
public class Server {
    static HashMap<Integer,User> users=new HashMap<>();
    static HashMap<Integer,Station> stations=new HashMap<>();
    static HashMap<Integer,Train> trains=new HashMap<>();
    static HashMap<Integer,Passenger> tickets=new HashMap<>();
    public void addStation(Station station){
        stations.put(station.stationId,station);
    }
    public Station getStation(int stationId){
        return stations.get(stationId);
    }
    public void addTrain(Train train){
        trains.put(train.trainId,train);
    }
    public Train getTrain(int id){
        return trains.get(id);
    }

    public Passenger getTicket(int id) {
        return tickets.get(id);
    }
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
            System.out.println("------------------------------------------------------");
            System.out.println("Booked Tickets are");
            System.out.println("------------------------------------------------------");
            System.out.println("PassengerID      Passenger Name");
            System.out.print("     "+train.getKey()+"       ");
            System.out.println(train.getValue().name);

        }
    }
    public ArrayList<Train> findAvailableTrains(Location location){
        Server server=new Server();
        Station boardingStation=location.getSourcePoint();    //server.getStation(start);
        Station destinationStation=location.getDestinationPoint();//server.getStation(end);
        ArrayList<Train> list=new ArrayList<>();
        //Train trainsAvailable=new Train();
        Iterator< Map.Entry<Integer,Train>> iterator=Server.trains.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,Train> ite=iterator.next();
            Route route=ite.getValue().getRoute();
            if(route.isStationContains(boardingStation,destinationStation)){
                list.add(server.getTrain(ite.getKey()));
            }
        }
        return list;
    }

    public User getUser(int userId){
        return users.get(userId);
    }



}