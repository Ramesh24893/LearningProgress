package Model;

public class TicketModel {
    static int num=1;
    private String name;
    private int age;
    private String boardingStationName;
    private int boardingStationId;
    private String destinationStationName;
    private int destinationStationId;
    private int trainId;
    private int passengerId;
    private int seatNo;
    public TicketModel(String name, int age, String boardingStationName, int boardingStationId, String destinationStationName, int destinationStationId, int trainId) {
        this.name = name;
        this.age = age;
        this.boardingStationName = boardingStationName;
        this.boardingStationId = boardingStationId;
        this.destinationStationName = destinationStationName;
        this.destinationStationId = destinationStationId;
        this.trainId = trainId;
        this.passengerId = num++;
    }

    public void setSeatNumber(int seatNo) {
        this.seatNo = seatNo;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nage: " + age +
                "\nBoardingStationName: " + boardingStationName +
                "\nBoardingStationId: " + boardingStationId +
                "\nDestinationStationName: " + destinationStationName +
                "\nDestinationStationId: " + destinationStationId +
                "\nTrainId: " + trainId +
                "\nModel.Seat No:"+ seatNo+
                "\nPassengerId: " + passengerId;
    }


    public int getBoardingStationId() {
        return boardingStationId;
    }
    public int getDestinationStationId() {
        return destinationStationId;
    }
    public int getTrainId() {
        return trainId;
    }
    public int getPassengerId() {
        return passengerId;
    }
    public int getSeatNo() {
        return seatNo;
    }
}
