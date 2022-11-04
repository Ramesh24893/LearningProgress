import Controller.*;
import Model.DefaultData;
import Model.LocationModel;
import Model.RailwayDataBaseModel;
import Model.UserModel;
import View.*;

import java.util.Scanner;

public class IRCTC {

    RailwayDataBaseModel railwayDataBaseModelObject=new RailwayDataBaseModel();
    StandardMessagesUI standardMessagesUIObject=new StandardMessages();
    public  void startApplication() {


        DefaultData defaultData = new DefaultData();
        defaultData.createDefaultStations();
        defaultData.createDefaultTrains();
        defaultData.createDefaultUsers();


        Scanner scannerObject = new Scanner(System.in);
        standardMessagesUIObject.logoPage();
        boolean flow = true;
        while (flow) {
            standardMessagesUIObject.loginPageDisplay();
            while (!scannerObject.hasNextInt()) {
                standardMessagesUIObject.invalidMessage();
                standardMessagesUIObject.loginPageDisplay();
                scannerObject.next();
            }
            IRCTC main = new IRCTC();
            switch (scannerObject.nextInt()) {
                case 1: {
                    //User
                    main.userFeatures();
                    break;
                }
                case 2: {
                    //Admin
                    main.adminFeatures();
                    break;

                }
                case 3: {
                        //New User Registration
                        UserUI userInputViewObject=new UserView();
                        LoginAccessController loginAccessControllerObject=new LoginAccessController(userInputViewObject, railwayDataBaseModelObject);
                        loginAccessControllerObject.registerUser();
                        break;
                    }

                    case 4: {
                        flow = false;
                        break;
                    }
                }
            }
        }
        public void userFeatures () {
            Scanner scannerObject = new Scanner(System.in);
            UserView userViewObject = new UserView();
            LoginAccessController loginAccessControllerObject=new LoginAccessController(userViewObject,railwayDataBaseModelObject);

            UserModel userModelObject = loginAccessControllerObject.loginUser();
            if (userModelObject == null) {                     // If Model.User enter valid user name and password break statement not get invoked
                return;                          // Or else break statement get invoked and asks user to enter valid data
            }
            boolean loop = true;
            while (loop) {
                standardMessagesUIObject.displayUserFeatures();
                while (!scannerObject.hasNextInt()) {
                    standardMessagesUIObject.invalidMessage();
                    standardMessagesUIObject.displayUserFeatures();
                    scannerObject.next();
                }
                UserController userControllerObject=new UserController(userModelObject,userViewObject);
                switch (scannerObject.nextInt()) {

                    case 1: {
                        SearchView searchViewObject=new SearchView();

                        SearchController searchControllerObject = new SearchController(railwayDataBaseModelObject,searchViewObject,userViewObject);

                        LocationModel location = searchControllerObject.getLocationFromUser();

                        if (searchControllerObject.displayAvailableTrains(location))
                            break;

                        userControllerObject.bookTicket(userModelObject, location);
                        break;
                    }
                    case 2: {
                        userControllerObject.cancelTicket(userModelObject);
                        break;
                    }
                    case 3: {
                        userControllerObject.displayUserBookedTickets(userModelObject,userViewObject);
                        break;
                    }
                    case 4: {
                        loop = false;
                        break;
                    }
                }
            }
        }
        public void adminFeatures() {
            Scanner scannerObject = new Scanner(System.in);
            AdminView adminViewObject=new AdminView();
            AdminController adminControllerObject = new AdminController(adminViewObject, railwayDataBaseModelObject);
            LoginAccessController loginAccessControllerObject=new LoginAccessController(adminViewObject,railwayDataBaseModelObject);

            if (loginAccessControllerObject.loginAdmin()) // If Model.Admin enter valid user name and password break statement not get invoked
                return;                        // Or else break statement get invoked and asks admin to enter valid data

            boolean control = true;
            while (control) {
                standardMessagesUIObject.displayAdminFeatures();
                while (!scannerObject.hasNextInt()) {
                    standardMessagesUIObject.invalidMessage();
                    standardMessagesUIObject.displayAdminFeatures();
                }

                switch (scannerObject.nextInt()) {

                    case 1:

                        adminControllerObject.createStations();
                        break;
                    case 2:
                        adminControllerObject.createTrain();
                        break;
                    case 3:
                        adminControllerObject.displayAllTickets();
                        break;
                    case 4:
                        adminControllerObject.displayAllTrains();
                        break;
                    case 5:
                        control = false;
                        break;
                }
            }

        }

    }














//USER
//                    UserModel user=loginUserObject.loginUser();
//                    if(user==null){                     // If Model.User enter valid user name and password break statement not get invoked
//                        break;                          // Or else break statement get invoked and asks user to enter valid data
//                    }
//                    boolean loop=true;
//                    while(loop) {
//                        StandardMessages.displayUserFeatures();
//                        while(!scannerObject.hasNextInt()) {
//                            StandardMessages.invalidMessage();
//                            StandardMessages.displayUserFeatures();
//                            scannerObject.next();
//                        }
//                        switch (scannerObject.nextInt()) {
//
//                            case 1: {
//                                BookingView bookingViewObject=new BookingView();
//                                SearchModuleView searchModule = new SearchModuleView();
//                                LocationModel location = searchModule.getLocationFromUser();
//                                if (searchTrain.displayAvailableTrains(location))
//                                    break;
//                                BookingController bookingObj = new BookingController(bookingViewObject,railwayDataBaseModel);
//                                bookingObj.bookTicket(user, location);
//                                break;
//                            }
//                            case 2: {
//                                BookingView bookingViewObject=new BookingView();
//                                BookingController bookingObj = new BookingController(bookingViewObject,railwayDataBaseModel);
//                                bookingObj.cancelTicket(user);
//                                break;
//                            }
//                            case 3: {
//
//                                DisplayUserBookedTickets.displayUserBookedTickets(user);
//                                break;
//                            }
//                            case 4: {
//                                loop = false;
//                                break;
//                            }
//                        }
//                    }
//break;



//                    LoginAdminController loginAdminObject=new LoginAdminController();
//                     if(loginAdminObject.loginAdmin()) // If Model.Admin enter valid user name and password break statement not get invoked
//                         break;                          // Or else break statement get invoked and asks admin to enter valid data
//
//                   boolean control=true;
//                   while (control){
//                       StandardMessages.displayAdminFeatures();
//                       while(!scannerObject.hasNextInt()) {
//                           StandardMessages.invalidMessage();
//                           StandardMessages.displayAdminFeatures();
//                           //scannerObject.next();
//                       }
//
//                       ComponentCreationView componentCreationView=new ComponentCreationView();
//                       switch (scannerObject.nextInt()) {
//
//                           case 1:
//
//                            ComponentCreationController createStationObject=new ComponentCreationController(componentCreationView,railwayDataBaseModel);
//                            createStationObject.createStations();
//                            break;
//                        case 2:
//
//                            ComponentCreationController createTrainObject=new ComponentCreationController(componentCreationView,railwayDataBaseModel);
//                            createTrainObject.createTrain();
//                            break;
//                        case 3:
//                            DisplayAllTickets.displayAllTickets(RailwayDataBaseModel.getTickets());
//                            break;
//                           case 4:
//                               DisplayAllTrains.displayAllTrains(RailwayDataBaseModel.getTrains());
//                               break;
//                            case 5:
//                            control=false;
//                            break;
//                             }}
//                   break;}