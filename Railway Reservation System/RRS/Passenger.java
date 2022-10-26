package IRCTC;
public class Passenger {
	static int passengerId=0;
	String name;
	int age;
	int trainId;
	public Passenger(String name, int age, int trainId) {
		passengerId++;
		this.name = name;
		this.age = age;
		this.trainId = trainId;
	}
	
}
