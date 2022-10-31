import java.util.Scanner;

public class IRCTC {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Train train=new Train();
        LoginUser loginUserObject=new LoginUser();
        DisplayData displayData=new DisplayData();
        BookTicket bookTicket =new BookTicket();
        SearchTrain searchTrain=new SearchTrain();

        Default def = new Default();
        def.createDefaultStations();
        def.createDefaultTrains();
        def.createDefaultUsers();
        System.out.println("******************************************************");
        System.out.println("******************************************************");
        System.out.println("***          RAILWAY RESERVATION SYSTEM            ***");
        System.out.println("******************************************************");
        System.out.println("******************************************************");

        //User or Admin
        boolean flow=true;
        while(flow){
            System.out.println(StandardMessages.loginPageDisplay);
            switch(sc.nextInt()) {
                case 1:
                    //USER
                    User user=new User();
                    user=loginUserObject.loginUser();
                    if(user==null){                     // If User enter valid user name and password break statement not get invoked
                        break;                          // Or else break statement get invoked and asks user to enter valid data
                    }
                    boolean loop=true;
                    while(loop) {
                        System.out.println(StandardMessages.userFeatures);
                        switch (sc.nextInt()) {
                            case 1: {
                                SearchModule searchModule = new SearchModule();
                                Location location = searchModule.getLocationFromUser();
                                if (searchTrain.displayAvailableTrains(location))
                                    break;
                                BookTicket bookTicketObj = new BookTicket();
                                bookTicketObj.bookTicket(user, location);
                                break;
                            }
                            case 2: {
                                CancelTicket cancelTicketObj = new CancelTicket();
                                cancelTicketObj.cancelTicket(user);
                                break;
                            }
                            case 3: {
                                user.displayUserBookedTickets(user);
                                break;
                            }
                            case 4: {
                                loop = false;
                                break;
                            }
                        }
                    }
                    break;
                case 2: {
                    //Admin
                    Admin admin=new Admin();
                    LoginAdmin loginAdminObject=new LoginAdmin();
                     if(loginAdminObject.loginAdmin()) // If Admin enter valid user name and password break statement not get invoked
                         break;                          // Or else break statement get invoked and asks admin to enter valid data

                   boolean control=true;
                   while (control){
                       System.out.println(StandardMessages.adminFeatures);
                       switch (sc.nextInt()) {
                        case 1:
                            CreateStation createStationObject=new CreateStation();
                            createStationObject.createStations();
                            break;
                        case 2:
                            CreateTrain createTrainObject=new CreateTrain();
                            createTrainObject.createTrain();
                            break;
                        case 3:
                            displayData.displayAllTickets();
                            break;
                           case 4:
                               displayData.displayAllTrains();
                            case 5:
                            control=false;
                            break;
                             }}
                   break;}

                case 3: {
                    Registration registration=new Registration();
                    registration.registerUser();
                    break;
                }

                case 4:{
                    flow=false;
                    break;
                }
            }

        }
    }
}
