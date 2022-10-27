import java.util.*;

public class IRCTC {
    public static void main(String[] args) {
        Server server=new Server();
        Booking book=new Booking();
        Scanner sc=new Scanner(System.in);
        Default def = new Default();
        def.createDefaultStations();
        def.createDefaultTrains();
        def.createDefaultUsers();
        IRCTC irctc=new IRCTC();

        Validation validation=new Validation();

        System.out.println("----------------RAILWAY RESERVATION SYSTEM------------");
        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");
        //User or Admin
        boolean flow=true;
        while(flow){
            System.out.println("Enter 1 to continue as User\n" +
                    "Enter 2 to continue as Admin\n" +
                    "Enter 3 to create User account\n" +
                    "Enter 4 to exit");
            switch(sc.nextInt()) {
                case 1:
                    //USER
                    User user=new User();
                    try{
                    user=irctc.loginUser();  //Login user and checking whether data is valid
                    }
                    catch(InvalidLoginData e){
                        System.out.println("Enter the valid username and password");
                       break;
                    }
                    boolean loop=true;
                    while(loop) {
                        System.out.println("Enter 1 to book ticket\n" +
                                "Enter 2 to cancel ticket\n" +
                                "Enter 3 to display booked Tickets\n" +
                                "Enter 4 to exit");
                        switch (sc.nextInt()) {
                            case 1: {

                                server.displayStations();
                                System.out.println("Enter the boarding station id ");
                                int boardingStationId = sc.nextInt();
                                System.out.println("Enter the destination station id ");
                                int destinationStationId = sc.nextInt();
                                Location location = new Location(server.getStation(boardingStationId), server.getStation(destinationStationId));
                                if (irctc.displayAvailableTrains(location)) {
                                    System.out.println("No train available for this boarding and destination point");
                                    break;
                                }
                                System.out.println("Enter ID of train to book ticket");
                                int trainId = sc.nextInt();
                                book.bookTicket(trainId, user);
                                break;

                            }
                            case 2: {
                                book.cancelTicket(user);
                                break;
                            }
                            case 3: {
                                user.displayUserBookedTickets(user);
                                break;
                            }
                            case 4:
                                loop=false;
                                break;

                        }


                    }
                    break;
                case 2: {
                    Admin admin=new Admin();
                   try{
                       irctc.loginAdmin();    //Login admin and checking whether data is valid
                   }catch(InvalidLoginData e){
                       System.out.println("Enter the valid username and password");
                        break;
                   }
                   boolean control=true;
                   while (control){
                    System.out.println("Enter 1 to create stations\nEnter 2 to create Trains\nEnter 3 to exit");
                    switch (sc.nextInt()) {
                        case 1:
                            admin.createStations();
                            break;
                        case 2:
                            admin.createTrain();
                            break;
                        case 3:
                            control=false;
                            break;
                    }
                    }
                   break;
                }

                case 3: {
                    sc.nextLine();
                    System.out.println("Enter the new username ");
                    String newUserName = sc.nextLine();
                    System.out.println("Enter the password");
                    int password = sc.nextInt();

                    irctc.registerUser(newUserName, password);
                    break;
                }

                case 4: flow=false;
                    break;
            }}
    }
    public void registerUser(String userName,int password){
        User user=new User(userName,password);
        Server.users.put(user.getUserId(),user);
        System.out.println("Your account is created\nACCOUNT DETAILS");
        System.out.println(user);
    }
    public boolean displayAvailableTrains(Location location) {
        Server server=new Server();
        ArrayList<Train> availableTrains=server.findAvailableTrains(location);
        if(availableTrains.isEmpty())
            return true;
        for(Train train: availableTrains) {
            System.out.println(train.name + "\nID:" + train.trainId + "\nSeats Available:" + train.seatsAvailable);
            train.calculateDistance(location,train);
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.println("-----------------------------------------------------------------------------------------------------");
        }
        return false;
    }
    public User loginUser() throws InvalidLoginData{
        Scanner sc=new Scanner(System.in);
        Server server=new Server();
        Validation validation=new Validation();
        System.out.println("Enter your userId");
        int userId=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the name");
        String userName=sc.nextLine();
        System.out.println("Enter the password");
        int userPassword=sc.nextInt();
        if(!validation.validateUser(userId,userName,userPassword)){

            throw new InvalidLoginData();
        }
        return server.getUser(userId);

    }
    public void loginAdmin() throws  InvalidLoginData{
        Scanner sc=new Scanner(System.in);
        Validation validation=new Validation();
        //sc.nextLine();
        Admin admin = new Admin();
        System.out.println("Enter the username");
        String adminUserName = sc.nextLine();
        System.out.println("Enter the password");
        int adminPassword = sc.nextInt();
        if (!validation.validateAdmin(adminUserName, adminPassword))
            throw new InvalidLoginData();
    }
}
