public class Project {
    String name;
    int worth;
    Project(){}

   // public Project(String name, int worth) {

       public Project(String name, int worth) {
      this.name = name;
        this.worth = worth;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorth() {
        return worth;
    }

    public void setWorth(int worth) {
        this.worth = worth;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", worth=" + worth +
                '}';
    }
}
