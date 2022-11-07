package DataBase;

import Model.*;

import java.util.ArrayList;
import java.util.HashMap;

public class RailwayDataBase {


    public static HashMap<Integer, UserModel> users=new HashMap<>();
    public static HashMap<Integer, StationModel> stations=new HashMap<>();
    public static HashMap<Integer, TrainModel> trains=new HashMap<>();
    public static HashMap<Integer, TicketModel> tickets=new HashMap<>();

    public static HashMap<SeatModel,ArrayList<TicketModel>> seatTickets=new HashMap<>();


    public void addStation(StationModel station){
        stations.put(station.getStationId(),station);
    }
    public StationModel getStation(int stationId){
        return stations.get(stationId);
    }
    public UserModel getUser(int userId){
        return users.get(userId);
    }
    public void addTrain(TrainModel train){
        trains.put(train.getTrainId(),train);
    }
    public TrainModel getTrain(int id){
        return trains.get(id);
    }

    public TicketModel getTicket(int id) {
        return tickets.get(id);
    }
    public  HashMap<Integer, UserModel> getUsers() {
        return users;
    }

    public  HashMap<Integer, StationModel> getStations() {
        return stations;
    }

    public  HashMap<Integer, TrainModel> getTrains() {
        return trains;
    }

    public  HashMap<Integer, TicketModel> getTickets() {
        return tickets;
    }

}