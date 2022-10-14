//If a change is made in lamp there will be no change in Button, Because button is dependent on ButtonServer interface
//And this ButtonServer interface can used anywhere which are related to this on/off functionality


package IDP;

public class Lamp implements ButtonServer {
    @Override
    public void turnOff() {
        System.out.println("Turnoff");
    }

    @Override
    public void turnOn() {
        System.out.println("Turn On");
    }
}
