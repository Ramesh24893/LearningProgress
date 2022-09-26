//INHERITANCE
package Inheritance;
public class Student extends Person {
    String department;
    char sec;
    public Student(String name, int age, String city,String department,char sec) {
        super(name,age,city);
        this.department = department;
        this.sec=sec;
    }
    public String writeExam(){
        return "writing exam";
    }
    public void attendClass(){
        System.out.println("Student attending class");
    }

    public static void main(String[] args){
        Student stud1=new Student("Ramesh",21,"Tirunelveli","Mech",'B');
        System.out.println("Student name is "+ stud1.name );
        System.out.println("Student city is "+ stud1.city);
        System.out.println("Student is "+ stud1.walk());
        System.out.println("Student is "+ stud1.writeExam());
    }
}

