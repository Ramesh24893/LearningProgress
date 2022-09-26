package Inheritance;
public class MountainBike extends Bicycle {
    public int seatHeight;
    public MountainBike(int gear,int height,int weight,int seatHeight)
    {
        super(gear,height,weight,weight);
        this.seatHeight = seatHeight;
    }

    public void setHeight(int newValue) {
        seatHeight = newValue;
    }
    public static void main(String[] args)
    {
        MountainBike mb = new MountainBike(3, 130,20,50);
        System.out.println(mb.toString());
    }
}


