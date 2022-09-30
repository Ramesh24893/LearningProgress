import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //Project project=new Project("Zoho",10000000);
        Person person1=new Person("Ramesh",21,"Male","High",3,"Tirunelveli");
        TechnicalStaff ts1=new TechnicalStaff(person1,800000,"TechnicalStaff");
        Person person2=new Person("Ram",23,"Male","Medium",1,"Vallioor");
        TechnicalStaff ts2=new TechnicalStaff(person1,1000000,"TechnicalStaff");
        Person person3=new Person("Amesh",21,"Male","Basic",4,"Chennai");
        TechnicalStaff ts3=new TechnicalStaff(person1,700000,"TechnicalStaff");
        Person person4=new Person("mesh",21,"Male","High",3,"Tirunelveli");
        TechnicalStaff ts4=new TechnicalStaff(person1,500000,"TechnicalStaff");
        Person person5=new Person("Ramesh",21,"Male","High",4,"Tirunelveli");
        TechnicalStaff ts5=new TechnicalStaff(person1,600000,"TechnicalStaff");


        Person man=new Person("Reeganth",25,"Male","High",8,"Thoothukudi");
        Project project=CEO.project;
        Manager manager=new Manager(person2,"Manager",2000000,2,project);

        Team team=new Team(manager,ts1);

//        ts1.setProject(manager.getProject());
//        System.out.println(ts1.getProject());
//        ts1.work(6);
//        ts1.work(6);
//        ts1.getSalary();
        manager.getSalary();
        ts1.getDetails();
        ts2.getDetails();
        manager.work();
        ts5.getSalary();
           }
}