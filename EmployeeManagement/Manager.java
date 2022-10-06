import java.util.Scanner;
public class Manager extends Employee{
    Person personDetails;
    String position;
    int salary;
    int experienceAsManager;
    int key=2489;
    private Project project;
    public Project getProject() {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the key to get project details");
            int givenKey=sc.nextInt();
        System.out.println(givenKey);
            if(givenKey==key){
                return project;
            }
            return null;
        }
        Manager (Person personDetails, String position, int salary, int experienceAsManager,Project project) {

        this.personDetails = personDetails;
        this.position = position;
        this.salary = salary;
        this.experienceAsManager=experienceAsManager;
        this.project=project;
    }
    public void setProject(Project project){
        this.project=project;
    }
    public void work(){
        System.out.println("Planning and monitoring the project");
    }
    public void work(int time){
        System.out.println("Finished the project within  "+time + " days");
    }

    @Override
    public void getDetails()
    {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Manager{" +
                "personDetails=" + personDetails.getDetails() +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", experienceAsManager=" + experienceAsManager +
                ", project=" + project +
                '}';
    }

    public void getSalary(){
        System.out.println(this.salary);
    }

}