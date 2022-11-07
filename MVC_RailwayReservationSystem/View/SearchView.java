package View;

import java.util.Scanner;

public class SearchView implements SearchUI{
    Scanner scannerObject=new Scanner(System.in);
    public int getBoardingStationId(){
        System.out.println("Enter the boarding station id ");
        while(!scannerObject.hasNextInt()){
            System.out.println("Enter the valid data");
            System.out.println("Enter the boarding station id ");
            scannerObject.next();
        }
        return scannerObject.nextInt();

    }
    public int getDestinationStationId(){
        System.out.println("Enter the destination station id ");

        while(!scannerObject.hasNextInt()){
            System.out.println("Enter the valid data");
            System.out.println("Enter the destination station id ");
            scannerObject.next();
        }
        return scannerObject.nextInt();
    }
    public void noTrainAvailableNotification(){
        System.out.println("No train available for this boarding and destination point");
    }
    public void displayTrainData(String trainName,int trainId,int seatsAvailable,int distance,int fare,int time){
        System.out.println(trainName + "\nID:" + trainId + "\nSeats Available:" + seatsAvailable+ "\nDistance of travel is:" + distance + " km"+"\nFae: Rs "+ fare+"\nTimeDuration: "+time+" hours");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------------------");

    }
}
