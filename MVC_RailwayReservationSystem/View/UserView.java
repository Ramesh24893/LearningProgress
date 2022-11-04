package View;
import Model.*;
import java.util.*;

public class UserView implements UserUI{
    Scanner scannerObject=new Scanner(System.in);
    public int getUserIdForValidation(){
        System.out.println("Enter the user ID");
        while(!scannerObject.hasNextInt()){
            System.out.println("user id exists only in integer");
            System.out.println("Enter the user ID");
            scannerObject.next();
        }
        return scannerObject.nextInt();
    }
    public String getUserNameForValidation(){
        scannerObject.nextLine();
        System.out.println("Enter the user name");
        return scannerObject.nextLine();
    }
    public String getAdminPasswordForValidation(){
        System.out.println("Enter the user password");
        return scannerObject.nextLine();
    }
    public void userRegisteredNotification(){
        System.out.println("Your account is created\nACCOUNT DETAILS");
    }
    public void inValidUserNotification(){
        System.out.println("Enter the valid username and password");
    }
    public void noSuchUserNotification(){
        System.out.println("No such userId exists");
    }


    public int getTrainId(){
        System.out.println("Enter ID of train to book ticket");
        return scannerObject.nextInt();
    }
    public int getNumOfTickets(){
        System.out.println("Enter number of tickets to book");
        return scannerObject.nextInt();
    }





    public String getNameFromUser(){
        System.out.println("Enter the name");
        return scannerObject.nextLine();
    }

    public int getAgeFromUser(){
        System.out.println("Enter the age");
        return scannerObject.nextInt();
    }
    public void excessTickets(int availableSeatsCount) {
        System.out.println("You cant book ticket");
        System.out.println("Only " + availableSeatsCount + " seats are available");
    }
    public void displayTicket(TicketModel ticket){
        System.out.println("*********************************************\n--------------------------------------------");
        System.out.println("Your ticket is booked");
        System.out.println(ticket);
        System.out.println("*********************************************\n--------------------------------------------");
    }
    public void displayAvailableSeats(int  availableSeatsCount){
        System.out.println("Seats Left: " + availableSeatsCount);
    }
    public int getCancelTicketId() {
        System.out.print("Enter your id to cancel Ticket");
        return scannerObject.nextInt();

    }
    public void ticketCancelledNotification(){
        System.out.println("*************************************************");
        System.out.println("Ticket is cancelled");
        System.out.println("*************************************************");
    }

    public  void displayUserBookedTickets(UserModel user){
        Iterator<Map.Entry<Integer, TicketModel>> iterator=user.getBookedTickets().entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, TicketModel> tickets= iterator.next();
            System.out.println("TicketID "+tickets.getKey());
            System.out.println(tickets.getValue());
            System.out.println("----------------------------------------------------");
        }
    }

    public void displayAllStations(HashMap<Integer, StationModel> stations){
        System.out.println("***********************************************");
        System.out.println("Already existing stations");
        System.out.println("***********************************************");
        Iterator< Map.Entry<Integer, StationModel>> iterator= stations.entrySet().iterator();
        System.out.println("StationID       Name" );
        while(iterator.hasNext()){
            Map.Entry<Integer, StationModel> station=iterator.next();
            System.out.print("    "+station.getKey()+"         ");
            System.out.println(station.getValue().getStationName());
        }
    }
    public String getNewUserName() {
        System.out.println("Enter the new username ");
        return  scannerObject.nextLine();
    }

    public String getNewPassword() {
        System.out.println("Enter the password");
        return scannerObject.nextLine();
    }



}
