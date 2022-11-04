package View;

import java.util.Scanner;

public class SearchView implements SearchUI{
    Scanner scannerObject=new Scanner(System.in);
    public int getBoardingStationId(){
        System.out.println("Enter the boarding station id ");
        return scannerObject.nextInt();

    }
    public int getDestinationStationId(){
        System.out.println("Enter the destination station id ");
        return scannerObject.nextInt();
    }
    public void noTrainAvailableNotification(){
        System.out.println("No train available for this boarding and destination point");
    }
    public void displayTrainData(String trainName,int trainId,int seatsAvailable,int distance){
        System.out.println(trainName + "\nID:" + trainId + "\nSeats Available:" + seatsAvailable+ "Distance of travel is:" + distance + " km");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------------------");

    }
}
