package IDP;

public class Button {
    ButtonServer bs=new Lamp();
    public void perform(String command){
        if(command.equals("ON")){
            bs.turnOn();
        }
        else{
            bs.turnOff();
        }
    }

    public static void main(String[] args) {
        Button but=new Button();
        but.perform("ON");
    }
}
