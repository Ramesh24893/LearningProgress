package HasARelationship;
public class CarEngine {
    String engineName;
    String engineType;
    String enginePower;
    public CarEngine(){}
    public CarEngine(String engineName, String engineType, String enginePower) {
        this.engineName = engineName;
        this.engineType = engineType;
        this.enginePower = enginePower;
    }
    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(String enginePower) {
        this.enginePower = enginePower;
    }

}
