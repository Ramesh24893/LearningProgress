
public class Passenger {
    static int num=1;
    String name;
    int age;

    int trainId;
    int passengerId;
    public Passenger(String name, int age, int trainId) {
        this.passengerId=num++;
        this.name = name;
        this.age = age;
        this.trainId = trainId;
    }

    @Override
    public String toString() {
        return
                "Name: " + name + '\n' +
                "Age: " + age +'\n'+
                "TrainId: " + trainId+'\n'+
                "PassengerId: "+ passengerId;
    }
}
