import java.util.ArrayList;
import java.util.Scanner;

public class CreateRoute {
    public Route createRoute() {
        RailwayDataBase railwayDataBaseObject=new RailwayDataBase();
        Scanner sc=new Scanner(System.in);
        ArrayList<Station> route=new ArrayList<>();
        ArrayList<Integer> distance=new ArrayList<>();
        DisplayData displayData=new DisplayData();
        displayData.displayAllStations();
        System.out.println("Create a route");
        System.out.println("Enter the Boarding Point station  ID");
        int stationId=sc.nextInt();
        route.add(railwayDataBaseObject.getStation(stationId));
        boolean flow=true;
        while(flow){
            System.out.println("Type 1 to add another Station between Destination Point");
            System.out.println("Type 2 to don't add Station between Destination Point");
            int access=sc.nextInt();
            switch(access){
                case 1:
                    System.out.println("Enter the station Id");
                    stationId=sc.nextInt();
                    route.add(railwayDataBaseObject.getStation(stationId));
                    System.out.println("Enter the distance between newly added station and previous station");
                    distance.add(sc.nextInt());
                    break;
                case 2:
                    flow=false;
                    break;
            }
        }
        System.out.println("Enter the Destination Point station ID");
        route.add(railwayDataBaseObject.getStation(sc.nextInt()));
        System.out.println("Enter the distance between newly added station and previous station");
        distance.add(sc.nextInt());
        return new Route(route,distance);
    }

}
