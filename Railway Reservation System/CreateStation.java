import java.util.Scanner;

public class CreateStation {
    public void createStations(){
        RailwayDataBase railwayDataBase=new RailwayDataBase();
        Scanner sc=new Scanner(System.in);
        System.out.println("Already existing stations");
        System.out.println("***********************************************");
        DisplayData displayData=new DisplayData();
        displayData.displayAllStations();
        System.out.println("***********************************************");
        System.out.println("Enter number of stations");
        int count=sc.nextInt();
        for(int i=0;i<count;i++) {
            System.out.println("Enter the station name");
            sc.nextLine();
            String stationName = sc.nextLine();
            System.out.println("Enter the station id");
            int stationId = sc.nextInt();
            Station station = new Station(stationName, stationId);
            railwayDataBase.addStation(station);
        }
    }
}
