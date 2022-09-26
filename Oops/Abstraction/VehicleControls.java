//ABSTRACTION
//    Hiding internal implementation and just highlighting set of services what we are offering
//    Here a person is having a vehicle and he can accelerate and brake the vehicle but he doesn't know how internally braking and acceleration happens
package Abstraction;
interface Vehicle{
    public abstract  void accelerate();// In a class if a method is declared as abstract and the class must be declared as abstract
    public abstract void applyBrake();// If any class extend abstract class definitely the extended must provide implementation for all the classes which are declared as abstract
}
class Bike implements Vehicle{
    public void accelerate(){System.out.println("Bike is accelerated with the help of IC engine");}
    public void applyBrake(){System.out.println("Bike is stopped when brake pad and wheel comes into contact");}
}
class Ship implements Vehicle{
    public void accelerate(){System.out.println("Ship is accelerated with the help of Propeller");}
    public void applyBrake(){System.out.println("Ship is stopped when propeller stop rotating and begin to rotate in oppsite direction");}
    public void Speed(){
        System.out.println("Average speed of ship is 35 km/hr");
    }
}
public class VehicleControls {
    public static void main(String[] args){
        Vehicle ship=new Ship();
        ship.accelerate();
        ship.applyBrake();
        // ship.speed(); If an object is created with the help of parent reference we access only the methods in parent class
        Vehicle bike=new Ship();
        bike.accelerate();
        bike.applyBrake();
    }}
