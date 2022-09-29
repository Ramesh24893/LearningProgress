package HasARelationship;
class Hall{
    int length;
    int breadth;
    public Hall(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

}
class Kitchen{
    int length;
    int breadth;

    public Kitchen(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }
}
public class Home {
    String homeName;
    String homeColor;
    String destination;
    Kitchen kitchen=new Kitchen(1000,1000);
    Hall hall=new Hall(500,500);
    int rate;
    public Home(String homeName, String homeColor, String destination, int rate) {
        this.homeName = homeName;
        this.homeColor = homeColor;
        this.destination = destination;
        this.rate = rate;
    }

}
