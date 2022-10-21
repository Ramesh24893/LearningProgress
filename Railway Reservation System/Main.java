import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Main main=new Main();
        User user1=new User(1234,"ram",24893);
        Server.users.put(user1.getUserId(), user1);
        User user2=new User(5678,"sita",39842);
        Server.users.put(user2.getUserId(), user2);
        Validation validation=new Validation();
        boolean check=validation.validateUser(1234,"ram",24893);
        System.out.println(check);
        //add station
        Station station1=new Station("Chennai",1);
        Station station2=new Station("Vellore",2);
        Station station3=new Station("Salem",3);
        Station station4=new Station("Coimbatore",4);
        Station station5=new Station("Madurai",5);
        Station station6=new Station("Kovilpatti",6);
        Station station7=new Station("Tirunelveli",7);
        Server.stations.put(station1.stationId,station1);
        Server.stations.put(station2.stationId,station2);
        Server.stations.put(station3.stationId,station3);
        Server.stations.put(station4.stationId,station4);
        Server.stations.put(station5.stationId,station5);
        Server.stations.put(station6.stationId,station6);Server.stations.put(station7.stationId,station7);


        ///
       
       
        ArrayList<Station> stops=new ArrayList<>();
        stops.add(station1);
        stops.add(station2);
        stops.add(station3);
        stops.add(station4);
        stops.add(station5);
        stops.add(station6);


        Route route=new Route(stops, new ArrayList<>(Arrays.asList(100,200,100,122,133)));
        //route.stations.add(station1);
        Train train1=new Train("Nellai Express",100,route,10,10);
        Server.trains.put(train1.trainId, train1);
        
        Station start=Server.stations.get(1);
        Station end=Server.stations.get(6);
        System.out.println(start);
        System.out.println(end);
        int trainId=main.searchTrain(start,end);
        System.out.println(trainId);
        Server server=new Server();
        Admin admin=new Admin();
        admin.createStations();
        server.displayStations();

    }
    public int searchTrain(Station start,Station end){
        Train trainsAvailable=new Train();
        Iterator< Map.Entry<Integer,Train>> iterator=Server.trains.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,Train> ite=iterator.next();
           Route route=ite.getValue().getRoute();
            if(route.isStationContains(start,end)){
                System.out.println("hello");
                 return ite.getKey();
            }
        }
        return 1000;
        
    }
    

}