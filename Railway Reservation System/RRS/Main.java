package IRCTC;

import java.util.*;


public class Main {
	
    
	public static void main(String[] args) {
		Server server=new Server();
		Scanner sc=new Scanner(System.in);
		  Default def = new Default();
	        def.createDefaultStations();
	        def.createDefaultTrains();
//		Main main=new Main();

//        Validation validation=new Validation();
//        boolean check=validation.validateUser(1234,"ram",24893);
//        System.out.println(check);
       System.out.println("----------RAILWAY RESERVATION SYSTEM------------");
       System.out.println("------------------------------------------------");
       System.out.println("------------------------------------------------");
       //User or Admin
       System.out.println("Enter 1 to continue as User\nEnter 2 to continue as Admin");
       switch(sc.nextInt()) {
       case 1:
    	   //User
    	   System.out.println("Enter 1 to book ticket \nEnter 2 to cancel ticket");
    	   switch(sc.nextInt()) {
    	   case 1:
    		  System.out.println("Enter the boarding station id ");
    		  int boardingStationId=sc.nextInt();
    		  System.out.println("Enter the destination station id ");
    		  int destinationStationId=sc.nextInt();
    		  findTrain(boardingStationId,destinationStationId);
    		   }
    	   break;
       case 2:
    	   //Admin
    	   break;
       }

       
}
    public ArrayList<Train> searchTrain(int start,int end){
    	Server server=new Server();
    	Station sta=server.getStation(start);
    	Station en=server.getStation(end);
    	ArrayList<Train> list=new ArrayList<>();
    	//Train trainsAvailable=new Train();
        Iterator< Map.Entry<Integer,Train>> iterator=Server.trains.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,Train> ite=iterator.next();
           Route route=ite.getValue().getRoute();
            if(route.isStationContains(sta,en)){
                list.add(server.getTrain(ite.getKey()));
            }
        }
        return list;
        
    }
    public void calculateDistance() {
        Server server=new Server();
        Default def = new Default();
        def.createDefaultStations();
        def.createDefaultTrains();
        
        Train train=server.getTrain(2000);
        Route route=train.getRoute();
        ArrayList<Integer> dis=route.distance;
        ArrayList<Station> sta=route.stations;
        int start=sta.indexOf(server.getStation(7));
        int stop=sta.indexOf(server.getStation(1));
        System.out.println(start +"  "+ stop);
        int totalDistance=0;
        for(int i=start;i<stop;i++) {
     	   totalDistance+=dis.get(i);
        }
        System.out.println(totalDistance);
        
    }
    public void findTrain(int  start,int end) {
    	Main main=new Main();   
    	Server server=new Server();
    
           ArrayList<Train>trainIds=main.searchTrain(start,end);
           for(Train train: trainIds)
           System.out.println(train.name + " ID:"+train.trainId);
           
           Booking booking=new Booking();
           booking.bookTicket();
           Train train=new Train();
           train.dispalySeatsAvailable(server.getTrain(2000));
           booking.cancelTicket();
        
    }
        

}
