import java.util.Scanner;

public class SearchModule {
    public Location getLocationFromUser(){
        Scanner scannerObject=new Scanner(System.in);
        RailwayDataBase railwayDataBase=new RailwayDataBase();
        DisplayData displayData=new DisplayData();
        displayData.displayAllStations();
        System.out.println("Enter the boarding station id ");
        int boardingStationId = scannerObject.nextInt();
        System.out.println("Enter the destination station id ");
        int destinationStationId = scannerObject.nextInt();
        return new Location(railwayDataBase.getStation(boardingStationId), railwayDataBase.getStation(destinationStationId));
    }
}
