//Aggregation
package HasARelationship;
import java.util.*;
class Department {

    String departmentName;
    Professor professor;
    public Department(String departmentName, Professor professor) {
        this.departmentName = departmentName;
        this.professor = professor;
    }

}
public class Professor{
    String name;
    String Qualification;
    String major;
    int age;
    public Professor(String name, String qualification, String major, int age) {
        this.name = name;
        Qualification = qualification;
        this.major = major;
        this.age = age;
    }

    public static void main(String[] args) {
        Professor varun=new Professor("Varun","Phd","Mechanical",45);
        Professor arun=new Professor("Arun","Phd","IT",54);
        Department mechanical=new Department("Mechanical",varun);
        Department it=new Department("IT",arun);
    }
}
