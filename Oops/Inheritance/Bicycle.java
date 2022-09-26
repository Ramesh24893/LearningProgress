package Inheritance;

public class Bicycle {
    int gear;
    int height;
    int length;
    int weight;
    int speed=0;

    public Bicycle(int gear, int height, int length, int weight) {
        this.gear = gear;
        this.height = height;
        this.length = length;
        this.weight = weight;
    }

    public void applyBrake(int decrement)
    {
        speed -= decrement;
    }

    public void speedUp(int increment)
    {
        speed += increment;
    }


}
