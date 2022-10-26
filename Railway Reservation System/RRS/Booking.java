package IRCTC;

import java.util.Scanner;

public class Booking {
	Scanner sc=new Scanner(System.in);
	Server server=new Server();
	public void bookTicket(Train train) {
		train.seatsAvailable--;
	}
	public void cancelTicket(Train train) {
		train.seatsAvailable++;
	}
	public void bookTicket() {
    	   
    	boolean flow=true;
           while(flow) {
           //Book Ticket
           switch(sc.nextInt()){	
           case 1:
           	sc.nextLine();
           	System.out.println("Enter your name");
           String name=sc.nextLine();
//        	System.out.print("Enter the gender");
//          	String gender=sc.nextLine();
           System.out.println("Enter the age");
           int age=sc.nextInt();
          System.out.println("Enter the id of tain to book ticket");
          int trainId=sc.nextInt();
          Passenger passenger=new Passenger(name,age,trainId);
          Server.tickets.put(passenger.passengerId, passenger);
          bookTicket(server.getTrain(trainId));
       break;
           	case 2:
           		flow =false;
           		break;
           }
           }
    }
	public void cancelTicket() {
		System.out.print("Enter your id to cancel Ticket");
		int id=sc.nextInt();
		cancelTicket(server.getTrain(server.getTicket(id).trainId));
		server.tickets.remove(id);
		
	}


}
