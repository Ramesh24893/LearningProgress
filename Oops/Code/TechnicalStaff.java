public class TechnicalStaff extends Employee {
    Person Details;
    int salary;
    String Position;
    Project project;
    public TechnicalStaff(Person details, int salary, String position) {
        this.Details = details;
        this.salary = salary;
        this.Position = position;
    }

    public void work(){
        System.out.println("Technical staff is doing work as per the instruction of manager");
    }
    public void work(int time){
        System.out.println("Done the work with in "+time+"days");
    }
    public void setProject(Project project) {
        this.project = project;
    }
    public void getSalary(){
        System.out.println(salary);
    }
    public Project getProject() {
        return project;
    }public void getDetails() {
        System.out.println(this.toString());
    }


    @Override
    public String toString() {
        return "TechnicalStaff{" +
                "Details=" + Details.getDetails() +
                ", salary=" + salary +
                ", Position='" + Position + '\'' +
                ", project=" + project +
                '}';
    }
}
