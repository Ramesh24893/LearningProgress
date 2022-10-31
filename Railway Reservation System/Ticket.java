
public class Ticket {
    static int num=1;
    String name;
    int age;
    String boardingStationName;
    int boardingStationId;
    String destinationStationName;
    int destinationStationId;
    int trainId;
    int passengerId;
    int seatNo;

    public Ticket(){}
    public Ticket(String name, int age, String boardingStationName, int boardingStationId, String destinationStationName, int destinationStationId, int trainId) {
        this.name = name;
        this.age = age;
        this.boardingStationName = boardingStationName;
        this.boardingStationId = boardingStationId;
        this.destinationStationName = destinationStationName;
        this.destinationStationId = destinationStationId;
        this.trainId = trainId;
        this.passengerId = num++;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    @Override
    public String toString() {
        return
                "Name: " + name +
                "\nage: " + age +
                "\nBoardingStationName: " + boardingStationName +
                "\nBoardingStationId: " + boardingStationId +
                "\nDestinationStationName: " + destinationStationName +
                "\nDestinationStationId: " + destinationStationId +
                "\nTrainId: " + trainId +
                "\nSeat No:"+ seatNo+
                "\nPassengerId: " + passengerId;
    }
}
