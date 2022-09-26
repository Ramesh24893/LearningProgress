package Inheritance;

public class Television {
    int length;
    int width;
    int height;
    int volume=0;
    int maxVolume=100;
    boolean power=false;
    public Television(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
    public boolean power(){
        return this.power=!power;
    }
    public int volumeUp(){
        if(this.volume<this.maxVolume){
            volume++;
        }
        return volume;
    }
    public int volumeDown(){
        if(this.volume>0){
            volume--;
        }
        return volume;
    }
}
