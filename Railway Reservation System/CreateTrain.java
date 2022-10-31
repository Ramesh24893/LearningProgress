import java.util.Scanner;

public class CreateTrain {
    public void createTrain(){
        Scanner sc=new Scanner(System.in);
        RailwayDataBase server=new RailwayDataBase();
        System.out.println("Enter the train name");
        String name=sc.nextLine();
        System.out.println("Enter the train ID");
        int trainId=sc.nextInt();
        System.out.println("Enter total number of seats in the train ");
        int totalSeats=sc.nextInt();

        CreateRoute createRouteObject=new CreateRoute();
        Train train =new Train(name,trainId,createRouteObject.createRoute(),totalSeats);
        server.addTrain(train);
    }
}
