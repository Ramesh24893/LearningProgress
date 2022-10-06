import java.util.HashMap;

public class Team {
    String name;
    Manager manager;
    HashMap<Integer,TechnicalStaff> staffs;

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", manager=" + manager.toString() +
                ", staffs=" + staffs.entrySet() +
                '}';
    }

    public Team(String name, Manager manager, HashMap<Integer,TechnicalStaff> staffs) {
        this.manager = manager;
        this.staffs = staffs;
        this.name=name;
    }

}
