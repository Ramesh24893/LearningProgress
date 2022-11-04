package Model;

import java.util.ArrayList;
public class DefaultData {
    StationModel station1=new StationModel("Chennai",1);
    StationModel station2=new StationModel("Vellore",2);
    StationModel station3=new StationModel("Salem",3);
    StationModel station4=new StationModel("Coimbatore",4);
    StationModel station5=new StationModel("Madurai",5);
    StationModel station6=new StationModel("Kovilpatti",6);
    StationModel station7=new StationModel("Tirunelveli",7);
    StationModel station8=new StationModel("Kovilpatti",8);
    StationModel station9=new StationModel("Virudhunagar",9);
    StationModel station10=new StationModel("Dindigul",10);
    StationModel station11=new StationModel("Trichy",11);
    StationModel station12=new StationModel("Vilupuram",12);
    StationModel station13=new StationModel("Thambaram",13);
    StationModel station14=new StationModel("Erode",14);
    StationModel station15=new StationModel("Kanyakumari",15);
    StationModel station16=new StationModel("Tuticorin",16);
    StationModel station17=new StationModel("Pondicherry",17);
    StationModel station18=new StationModel("Ramanathapuram",18);


    public void createDefaultStations() {
        RailwayDataBaseModel.stations.put(station1.stationId,station1);
        RailwayDataBaseModel.stations.put(station2.stationId,station2);
        RailwayDataBaseModel.stations.put(station3.stationId,station3);
        RailwayDataBaseModel.stations.put(station4.stationId,station4);
        RailwayDataBaseModel.stations.put(station5.stationId,station5);
        RailwayDataBaseModel.stations.put(station6.stationId,station6);
        RailwayDataBaseModel.stations.put(station7.stationId,station7);
        RailwayDataBaseModel.stations.put(station8.stationId,station8);
        RailwayDataBaseModel.stations.put(station9.stationId,station9);
        RailwayDataBaseModel.stations.put(station10.stationId,station10);
        RailwayDataBaseModel.stations.put(station11.stationId,station11);
        RailwayDataBaseModel.stations.put(station12.stationId,station12);
        RailwayDataBaseModel.stations.put(station13.stationId,station13);
        RailwayDataBaseModel.stations.put(station14.stationId,station14);
        RailwayDataBaseModel.stations.put(station15.stationId,station15);
        RailwayDataBaseModel.stations.put(station16.stationId,station16);
        RailwayDataBaseModel.stations.put(station17.stationId,station17);
        RailwayDataBaseModel.stations.put(station18.stationId,station18);
    }

//    public ArrayList<Model.Seat> createSeat(int count){
//        ArrayList<Model.Seat> seats=new ArrayList<>();
//        for(int seatNo=1;seatNo<=count;seatNo++){
//            Model.Seat seat=new Model.Seat(seatNo,new ArrayList<>());
//            seats.add(seat);
//        }
//
//        return seats;
//    }
    public void createDefaultTrains() {
        //Model.Train 1
        ArrayList<StationModel> nellaiRoute=new ArrayList<>();
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
        RouteModel nellaiExpressRoute=new RouteModel(nellaiRoute,distanceBetweenStationsNellaiExpress);
        TrainModel nellaiExpress=new TrainModel("Nellai Express",1000,nellaiExpressRoute,5);
        //nellaiExpress.createSeats(5);
//        ArrayList<Model.Ticket> tickets=new ArrayList<>();
//        Model.Ticket ticket1=new Model.Ticket("Ramesh",21,"Tirunelveli",7,"Chennai",9,1000);
//        Model.Ticket ticket2=new Model.Ticket("Ram",22,"Tirunelveli",9,"Chennai",1,1000);
//        tickets.add(ticket1);
//        tickets.add(ticket2);
//        Model.Seat seat=new Model.Seat(1,tickets);
//        ArrayList<Model.Seat> seatss=new ArrayList<>();
//        seatss.add(seat);
//        nellaiExpress.seats=seatss;

        //Model.Train 2
        ArrayList<StationModel> kanyaKumariRoute=new ArrayList<>();
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
        RouteModel kanyaKumariExpressRoute=new RouteModel(kanyaKumariRoute,distanceBetweenStationsKanyaKumariExpress);
        TrainModel kanyaKumariExpress=new TrainModel("KanyaKumari Express",2000,kanyaKumariExpressRoute,5);
        RailwayDataBaseModel.trains.put(kanyaKumariExpress.trainId, kanyaKumariExpress);
        RailwayDataBaseModel.trains.put(nellaiExpress.trainId, nellaiExpress);

    }
    public void createDefaultUsers() {
        UserModel user1=new UserModel("ram","24893");
        RailwayDataBaseModel.users.put(user1.getUserId(), user1);
        UserModel user2=new UserModel("ramesh","39842");
        RailwayDataBaseModel.users.put(user2.getUserId(), user2);
    }

}
