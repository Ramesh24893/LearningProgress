public class Check {
    public static void main(String[] args) {
        Admin admin1=new Admin();
        Server server=new Server();
//        System.out.println(admin1);
//        Admin admin2=new Admin();
//        System.out.println(admin2);
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

        Route route=admin1.createRoute();
        for(Station station: route.stations){
            System.out.println(station.stationName);
        }


    }
}
