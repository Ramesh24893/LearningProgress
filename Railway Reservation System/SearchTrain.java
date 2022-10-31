import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class SearchTrain {
    public boolean displayAvailableTrains(Location location) {
        RailwayDataBase server=new RailwayDataBase();
        ArrayList<Train> availableTrains=findAvailableTrains(location);
        if(availableTrains.isEmpty()){
            System.out.println("No train available for this boarding and destination point");
            return true;
        }
        for(Train train: availableTrains) {
            System.out.println(train.name + "\nID:" + train.trainId + "\nSeats Available:" + train.findAvailableSeats(location,train).size());
            train.calculateDistance(location,train);
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.println("-----------------------------------------------------------------------------------------------------");
        }
        return false;
    }
    public ArrayList<Train> findAvailableTrains(Location location){
        RailwayDataBase server=new RailwayDataBase();

        ArrayList<Train> list=new ArrayList<>();
        //Train trainsAvailable=new Train();
        Iterator< Map.Entry<Integer,Train>> iterator= RailwayDataBase.trains.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,Train> ite=iterator.next();
            Route route=ite.getValue().getRoute();
            if(route.isStationContains(location)){
                list.add(server.getTrain(ite.getKey()));
            }
        }
        return list;
    }
}
