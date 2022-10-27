import java.util.ArrayList;
import java.util.Scanner;

public class Admin {


    private static final String adminUserName="Reeganth";
    private static final int adminPassword=24893;


    public String getAdminUserName() {
        return adminUserName;
    }
    public int getAdminPassword() {
        return adminPassword;
    }

    public void createStations(){
        Server server=new Server();
        Scanner sc=new Scanner(System.in);
        System.out.println("Already existing stations");
        System.out.println("-----------------------------------------------");
        server.displayStations();
        System.out.println("-----------------------------------------------");
        System.out.println("Enter number of stations");
        int count=sc.nextInt();
        for(int i=0;i<count;i++) {
            System.out.println("Enter the station name");
            sc.nextLine();
            String stationName = sc.nextLine();
            System.out.println("Enter the station id");
            int stationId = sc.nextInt();
            Station station = new Station(stationName, stationId);
            server.addStation(station);
        }


       }
    public Route createRoute() {
        Server server=new Server();
        Scanner sc=new Scanner(System.in);
        ArrayList<Station> route=new ArrayList<>();
        ArrayList<Integer> distance=new ArrayList<>();
        server.displayStations();
        System.out.println("Create a route");
        System.out.println("Enter the Boarding Point station  ID");
        int stationId=sc.nextInt();
        route.add(server.getStation(stationId));
        boolean flow=true;
        while(flow){
        System.out.println("Type 1 to add another Station between Destination Point");
        System.out.println("Type 2 to don't add Station between Destination Point");
        int access=sc.nextInt();
        switch(access){
            case 1:
                System.out.println("Enter the station Id");
                stationId=sc.nextInt();
                route.add(server.getStation(stationId));
                System.out.println("Enter the distance between newly added station and previous station");
                distance.add(sc.nextInt());
                break;
            case 2:
                flow=false;
                break;
        }
        }
        System.out.println("Enter the Destination Point station ID");
        route.add(server.getStation(sc.nextInt()));
        System.out.println("Enter the distance between newly added station and previous station");
        distance.add(sc.nextInt());
        return new Route(route,distance);
    }
        public void createTrain(){
            Scanner sc=new Scanner(System.in);
            Server server=new Server();
            System.out.println("Enter the train name");
            String name=sc.nextLine();
            System.out.println("Enter the train ID");
            int trainId=sc.nextInt();
            System.out.println("Enter total number of seats in the train ");
            int totalSeats=sc.nextInt();
            Admin admin=new Admin();
            ;
            Train train =new Train(name,trainId,admin.createRoute(),totalSeats);
            server.addTrain(train);
    }

}


