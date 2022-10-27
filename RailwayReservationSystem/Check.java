public class Check {
    public static void main(String[] args) {
//        System.out.println(admin1);
//        Admin admin2=new Admin();
//        System.out.println(admin2);
//        Station station1=new Station("Chennai",1);
//        Station station2=new Station("Vellore",2);
//        Station station3=new Station("Salem",3);
//        Station station4=new Station("Coimbatore",4);
//        Station station5=new Station("Madurai",5);
//        Station station6=new Station("Kovilpatti",6);
//        Station station7=new Station("Tirunelveli",7);
//        Station station8=new Station("Kovilpatti",8);
//        Station station9=new Station("Virudhunagar",9);
//        Station station10=new Station("Dindigul",10);
//        Station station11=new Station("Trichy",11);
//        Station station12=new Station("Villupuram",12);
//        Station station13=new Station("Tambaram",13);
//        Station station14=new Station("Erode",14);
//        Station station15=new Station("Kayakumari",15);
//        Station station16=new Station("Tuticorin",16);
//        Station station17=new Station("Pondicherry",17);
//        Station station18=new Station("Ramanathapuram",18);
//
//
//
//        Server.stations.put(station1.stationId,station1);
//        Server.stations.put(station2.stationId,station2);
//        Server.stations.put(station3.stationId,station3);
//        Server.stations.put(station4.stationId,station4);
//        Server.stations.put(station5.stationId,station5);
//        Server.stations.put(station6.stationId,station6);
//        Server.stations.put(station7.stationId,station7);
//        Server.stations.put(station8.stationId,station8);
//        Server.stations.put(station9.stationId,station9);
//        Server.stations.put(station10.stationId,station10);
//        Server.stations.put(station11.stationId,station11);
//        Server.stations.put(station12.stationId,station12);
//        Server.stations.put(station13.stationId,station13);
//        Server.stations.put(station14.stationId,station14);
//        Server.stations.put(station15.stationId,station15);
//        Server.stations.put(station16.stationId,station16);
//        Server.stations.put(station17.stationId,station17);
//        Server.stations.put(station18.stationId,station18);


//        Route route=admin1.createRoute();
//        for(Station station: route.stations){
//            System.out.println(station.stationName);
//        }
        Default def = new Default();
        def.createDefaultStations();
        def.createDefaultTrains();
        Server server=new Server();
        server.displayTrains();

    }
}
