package IRCTC;
import java.util.*;
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
      Station station12=new Station("Villupuram",12);
      Station station13=new Station("Tambaram",13);
      Station station14=new Station("Erode",14);
      Station station15=new Station("Kayakumari",15);
      Station station16=new Station("Tuticorin",16);
      Station station17=new Station("Pondicherry",17);
      Station station18=new Station("Ramanathapuram",18);
      

	public void createDefaultStations() {
	        Server.stations.put(station1.stationId,station1);
	        Server.stations.put(station2.stationId,station2);
	        Server.stations.put(station3.stationId,station3);
	        Server.stations.put(station4.stationId,station4);
	        Server.stations.put(station5.stationId,station5);
	        Server.stations.put(station6.stationId,station6);
	        Server.stations.put(station7.stationId,station7);
	        Server.stations.put(station8.stationId,station8);
	        Server.stations.put(station9.stationId,station9);
	        Server.stations.put(station10.stationId,station10);
	        Server.stations.put(station11.stationId,station11);
	        Server.stations.put(station12.stationId,station12);
	        Server.stations.put(station13.stationId,station13);
	        Server.stations.put(station14.stationId,station14);
	        Server.stations.put(station15.stationId,station15);
	        Server.stations.put(station16.stationId,station16);
	        Server.stations.put(station17.stationId,station17);
	        Server.stations.put(station18.stationId,station18);
	}
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
		Train nellaiExpress=new Train("Nellai Express",1000,nellaiExpressRoute,100,100);
		//Train 2
		ArrayList<Station> kanyaKumariRoute=new ArrayList<>();
		kanyaKumariRoute.add(station7);
		kanyaKumariRoute.add(station6);
		kanyaKumariRoute.add(station7);
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
		Train kanyaKumariExpress=new Train("KanyaKumari Express",2000,kanyaKumariExpressRoute,100,100);
		Server.trains.put(kanyaKumariExpress.trainId, kanyaKumariExpress);
		Server.trains.put(nellaiExpress.trainId, nellaiExpress);
		
	
	}
	public void createDefaultUsers() {
        User user1=new User(1234,"ram",24893);
        Server.users.put(user1.getUserId(), user1);
        User user2=new User(5678,"ramesh",39842);
        Server.users.put(user2.getUserId(), user2);
	}

}
