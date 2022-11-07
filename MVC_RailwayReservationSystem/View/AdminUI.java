package View;

import Model.StationModel;
import Model.TicketModel;
import Model.TrainModel;

import java.util.HashMap;

public interface AdminUI {
    public String getAdminUserNameForValidation();
    public int getAdminPasswordForValidation();
    public void invalidDataNotification();
    public  void displayAllTrains(HashMap<Integer, TrainModel> trains);
    public  void displayAllTickets(HashMap<Integer, TicketModel> tickets);
    public void displayAllStations(HashMap<Integer, StationModel> stations);
    public  int getDistance();
    public int getBoardingStationId();
    public int canGetStationsInBetween();
    public int getDestinationStationId();
    public int getStationInBetween();
    public int getNewStationId();
    public String getNewStationName();
    public int getCountOfNewStation();
    public String getTrainName();
    public int getTrainId();
    public int getNumOfSeats();
}
