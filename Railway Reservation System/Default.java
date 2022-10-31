import java.util.ArrayList;
public class Default {
    Station station1=new Station("Chennai",1);
    Station station2=new Station("Vellore",2);
    Station station3=new Station("Salem",3);
    Station station4=new Station("Coimbatore",4);
    Station station5=new Station("Madurai",5);
    Station station6=new Station("Kovilpatti",6);
    Station station7=new Station("Tirunelveli",7);
    Station station8=new Station("Kovilpatti",8);
    Station station9=new Station("Virudhunagar",9);
    Station station10=new Station("Dindigul",10);
    Station station11=new Station("Trichy",11);
    Station station12=new Station("Vilupuram",12);
    Station station13=new Station("Thambaram",13);
    Station station14=new Station("Erode",14);
    Station station15=new Station("Kanyakumari",15);
    Station station16=new Station("Tuticorin",16);
    Station station17=new Station("Pondicherry",17);
    Station station18=new Station("Ramanathapuram",18);


    public void createDefaultStations() {
        RailwayDataBase.stations.put(station1.stationId,station1);
        RailwayDataBase.stations.put(station2.stationId,station2);
        RailwayDataBase.stations.put(station3.stationId,station3);
        RailwayDataBase.stations.put(station4.stationId,station4);
        RailwayDataBase.stations.put(station5.stationId,station5);
        RailwayDataBase.stations.put(station6.stationId,station6);
        RailwayDataBase.stations.put(station7.stationId,station7);
        RailwayDataBase.stations.put(station8.stationId,station8);
        RailwayDataBase.stations.put(station9.stationId,station9);
        RailwayDataBase.stations.put(station10.stationId,station10);
        RailwayDataBase.stations.put(station11.stationId,station11);
        RailwayDataBase.stations.put(station12.stationId,station12);
        RailwayDataBase.stations.put(station13.stationId,station13);
        RailwayDataBase.stations.put(station14.stationId,station14);
        RailwayDataBase.stations.put(station15.stationId,station15);
        RailwayDataBase.stations.put(station16.stationId,station16);
        RailwayDataBase.stations.put(station17.stationId,station17);
        RailwayDataBase.stations.put(station18.stationId,station18);
    }

//    public ArrayList<Seat> createSeat(int count){
//        ArrayList<Seat> seats=new ArrayList<>();
//        for(int seatNo=1;seatNo<=count;seatNo++){
//            Seat seat=new Seat(seatNo,new ArrayList<>());
//            seats.add(seat);
//        }
//
//        return seats;
//    }
    public void createDefaultTrains() {
        //Train 1
        ArrayList<Station> nellaiRoute=new ArrayList<>();
        nellaiRoute.add(station7);
        nellaiRoute.add(station8);
        nellaiRoute.add(station9);
        nellaiRoute.add(station10);
        nellaiRoute.add(station11);
        nellaiRoute.add(station12);
        nellaiRoute.add(station1);
        ArrayList<Integer> distanceBetweenStationsNellaiExpress=new ArrayList<>();
        distanceBetweenStationsNellaiExpress.add(200);
        distanceBetweenStationsNellaiExpress.add(400);
        distanceBetweenStationsNellaiExpress.add(156);
        distanceBetweenStationsNellaiExpress.add(100);
        distanceBetweenStationsNellaiExpress.add(100);
        distanceBetweenStationsNellaiExpress.add(100);
        Route nellaiExpressRoute=new Route(nellaiRoute,distanceBetweenStationsNellaiExpress);
        Train nellaiExpress=new Train("Nellai Express",1000,nellaiExpressRoute,5);
        //nellaiExpress.createSeats(5);
//        ArrayList<Ticket> tickets=new ArrayList<>();
//        Ticket ticket1=new Ticket("Ramesh",21,"Tirunelveli",7,"Chennai",9,1000);
//        Ticket ticket2=new Ticket("Ram",22,"Tirunelveli",9,"Chennai",1,1000);
//        tickets.add(ticket1);
//        tickets.add(ticket2);
//        Seat seat=new Seat(1,tickets);
//        ArrayList<Seat> seatss=new ArrayList<>();
//        seatss.add(seat);
//        nellaiExpress.seats=seatss;

        //Train 2
        ArrayList<Station> kanyaKumariRoute=new ArrayList<>();
        kanyaKumariRoute.add(station7);
        kanyaKumariRoute.add(station6);
        kanyaKumariRoute.add(station10);
        kanyaKumariRoute.add(station16);
        kanyaKumariRoute.add(station17);
        kanyaKumariRoute.add(station18);
        kanyaKumariRoute.add(station1);
        ArrayList<Integer> distanceBetweenStationsKanyaKumariExpress=new ArrayList<>();
        distanceBetweenStationsKanyaKumariExpress.add(300);
        distanceBetweenStationsKanyaKumariExpress.add(100);
        distanceBetweenStationsKanyaKumariExpress.add(600);
        distanceBetweenStationsKanyaKumariExpress.add(100);
        distanceBetweenStationsKanyaKumariExpress.add(700);
        distanceBetweenStationsKanyaKumariExpress.add(100);
        Route kanyaKumariExpressRoute=new Route(kanyaKumariRoute,distanceBetweenStationsKanyaKumariExpress);
        Train kanyaKumariExpress=new Train("KanyaKumari Express",2000,kanyaKumariExpressRoute,5);
        RailwayDataBase.trains.put(kanyaKumariExpress.trainId, kanyaKumariExpress);
        RailwayDataBase.trains.put(nellaiExpress.trainId, nellaiExpress);

    }
    public void createDefaultUsers() {
        User user1=new User("ram","24893");
        RailwayDataBase.users.put(user1.getUserId(), user1);
        User user2=new User("ramesh","39842");
        RailwayDataBase.users.put(user2.getUserId(), user2);
    }

}
