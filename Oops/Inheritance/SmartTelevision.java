package Inheritance;

public class SmartTelevision extends Television{
    public SmartTelevision(int length, int width, int height) {
        super(length, width, height);
    }

    public void connectToInternet(){
    }
    public void playMusic(){
    }
    public static void main(String[] args){
        SmartTelevision tv=new SmartTelevision(100,10,70);

        System.out.println(tv.power());
        System.out.println(tv.volumeUp());
        System.out.println(tv.volumeUp());
    }
}
