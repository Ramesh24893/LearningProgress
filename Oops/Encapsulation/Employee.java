//ENCAPSULATION
package Encapsulation;
public class Employee {
    public static void main(String[] args){
        EmployeeData emp1=new EmployeeData("Ram",1,1000);
        System.out.print(emp1);
    }
}
class EmployeeData{
    String name;
    int employeeId;
    int salary;
    private int key=2468;
    public EmployeeData(String name, int employeeId, int salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
    }
    public int employeeAccessKey(){
        return key;
    }
    public void work(){
        System.out.println("The employee is doing work");
    }
    public void attendMeeting(){
        System.out.println("The employee interact with workers");
    }
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", employeeId=" + employeeId +
                ", salary=" + salary +
                '}';
    }
}
