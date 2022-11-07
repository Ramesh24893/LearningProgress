package View;

import Model.StationModel;
import Model.TicketModel;
import Model.UserModel;

import java.util.HashMap;

public interface UserUI {
    public int getUserIdForValidation();
    public String getUserNameForValidation();
    public String getAdminPasswordForValidation();
    public void userRegisteredNotification();
    public void inValidUserNotification();
    public void noSuchUserNotification();
    public int getTrainId();
    public int getNumOfTickets();
    public String getNameFromUser();
    public int getAgeFromUser();
    public void excessTickets();
    public void displayTicket(TicketModel ticket);
    public void displayAvailableSeats(int  availableSeatsCount);
    public int getCancelTicketId();
    public void ticketCancelledNotification();
    public  void displayUserBookedTickets(UserModel user);
    public void displayAllStations(HashMap<Integer, StationModel> stations);
    public String getNewUserName();
    public String getNewPassword();
}
