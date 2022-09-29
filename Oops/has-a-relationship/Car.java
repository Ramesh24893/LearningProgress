package HasARelationship;
//Composition

public class Car {

    String carColour;
    String carModel;
    CarEngine engine;
    public Car(String carColour, String carModel, String engineName,String engineType,String enginePower) {
        this.engine = new CarEngine();
        this.carColour = carColour;
        this.carModel = carModel;
        engine.setEngineName(engineName);
        engine.setEnginePower(enginePower);
        engine.setEngineType(engineType);

    }


    public static void main(String[] args) {
        Car car=new Car("Blue","X2","V8","Chevy","320 BHP");

    }
}
