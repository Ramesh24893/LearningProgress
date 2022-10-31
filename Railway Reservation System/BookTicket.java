import java.util.*;
import java.util.Scanner;
public class BookTicket {
    public void bookTicket(User user, Location location) {
        Scanner scannerObject = new Scanner(System.in);
        RailwayDataBase railwayDataBaseObject = new RailwayDataBase();
        System.out.println("Enter ID of train to book ticket");
        int trainId = scannerObject.nextInt();

        Train train = railwayDataBaseObject.getTrain(trainId);
        Set<Integer> seatNum=train.findAvailableSeats(location,train);

        System.out.println("Enter number of tickets to book");
        int count = scannerObject.nextInt();
        Station boardingStation = location.getSourcePoint();
        Station destinationStation = location.getDestinationPoint();
        if (seatNum.size() > 0 && count <= seatNum.size()) {
            for (int index = 0; index < count; index++) {
                scannerObject.nextLine();
                System.out.println("Enter the name");
                String name = scannerObject.nextLine();
                System.out.println("Enter the age");
                int age = scannerObject.nextInt();
                Ticket passenger = new Ticket(name, age, boardingStation.stationName, boardingStation.stationId, destinationStation.stationName, destinationStation.stationId, trainId);
                RailwayDataBase.tickets.put(passenger.passengerId, passenger);
                user.bookedTickets.put(passenger.passengerId, passenger);
                for(Integer num: seatNum){
                    Seat seat=train.getSeat(num);
                    seat.tickets.add(passenger);
                    passenger.setSeatNo(num);
                    seatNum.remove(num);
                    break;
                }
                System.out.println("*********************************************\n--------------------------------------------");
                System.out.println("Your ticket is booked");
                // train.reduceTicketCount(train);
                System.out.println(passenger);
                System.out.println("*********************************************\n--------------------------------------------");
            }
        } else {
            System.out.println("You cant book ticket");
            System.out.println("Only " + train.seatsAvailable + " seats are available");
        }

        System.out.println("Seats Left: " + seatNum.size());//+ train.findAvailableSeats(location,train).size());
    }
}










//    public void bookTicket(User user, Location location) {
//        Scanner scannerObject = new Scanner(System.in);
//        RailwayDataBase railwayDataBaseObject = new RailwayDataBase();
//        System.out.println("Enter ID of train to book ticket");
//        int trainId = scannerObject.nextInt();
//        Train train = railwayDataBaseObject.getTrain(trainId);
//        System.out.println("Enter number of tickets to book");
//        int count = scannerObject.nextInt();
//        Station boardingStation = location.getSourcePoint();
//        Station destinationStation = location.getDestinationPoint();
//        if (train.seatsAvailable > 0 && count <= train.seatsAvailable) {
//            for (int index = 0; index < count; index++) {
//                scannerObject.nextLine();
//                System.out.println("Enter the name");
//                String name = scannerObject.nextLine();
//                System.out.println("Enter the age");
//                int age = scannerObject.nextInt();
//                Ticket passenger = new Ticket(name, age, boardingStation.stationName, boardingStation.stationId, destinationStation.stationName, destinationStation.stationId, trainId);
//                RailwayDataBase.tickets.put(passenger.passengerId, passenger);
//                user.bookedTickets.put(passenger.passengerId, passenger);
//                System.out.println("-------------------------------------------\n--------------------------------------------");
//                System.out.println("Your ticket is booked");
//                train.reduceTicketCount(train);
//                System.out.println(passenger);
//            }
//        } else {
//            System.out.println("You cant book ticket");
//            System.out.println("Only " + train.seatsAvailable + " seats are available");
//        }
//        System.out.println("Seats Left: " + train.findAvailableSeats(location,train));
//    }

