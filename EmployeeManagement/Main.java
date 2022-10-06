import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Create the team");
        System.out.println("Enter manager details for your team");
        Person person=getPersonDetails();

        System.out.println("Enter the position");
        String pos=sc.nextLine();
        System.out.println("Enter the salary");
        int salary=sc.nextInt();
        System.out.println("Enter the exp as Manager ");
        int exp=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the project name");
        String projectname=sc.nextLine();
        //sc.nextLine();
        System.out.println("Enter the project worth");

        int projectworth=sc.nextInt();
        try{
            if(projectworth>1000000){
                throw new InsufficientFundException("Not enough money");
            }
        }
        catch(InsufficientFundException e){
            System.out.println("Enter the value less than 100000");
            projectworth=sc.nextInt();
        }
        sc.nextLine();
        Project project=new Project(projectname,projectworth);
         Manager manager=new Manager(person,pos,salary,exp,project);
        System.out.println(manager);
        HashMap<Integer,TechnicalStaff> technicalStaffs=new HashMap<>();
        System.out.println("Add Technical staffs  in the team");
        boolean add=true;
        int i=1;
        while(add){
            Person per=getPersonDetails();

            TechnicalStaff ts=new TechnicalStaff(per,100000,"Technical Staff");
            System.out.println("If you want another Technical staff \n type 'YES' or else type 'NO");
            String check=sc.nextLine();
            if(check.equals("NO")){
                add=false;
            }

            technicalStaffs.put(i++,ts);


        }
        System.out.println("Enter the team name");
        String teamName=sc.nextLine();
        Team team=new Team(teamName,manager,technicalStaffs);
//        for (TechnicalStaff technicalStaff : technicalStaffs) {
//            System.out.println(technicalStaff);
//
        System.out.println(technicalStaffs.keySet());
        System.out.println(technicalStaffs.entrySet());
        technicalStaffs.get(1).getSalary();
        System.out.println(team);
    }
    public static Person getPersonDetails(){
        Scanner sc=new Scanner(System.in);
               System.out.println("Enter the name");
               String name=sc.nextLine();
               System.out.println("Enter the age");
               int age = 0;
               try{
                   age=sc.nextInt();
                 if(age<0) throw new Exception();

               }
               catch(InputMismatchException e){
                   System.out.println("Invalid age");
                   System.out.println("Enter the valid age you have only one attempt");
                   Scanner scanner=new Scanner(System.in);
                   age=scanner.nextInt();
               }
               catch(Exception e){
                   System.out.println("Invalid age");
                   System.out.println("Enter the valid age you have only one attempt");
                    age=sc.nextInt();
               }
               sc.nextLine();

               System.out.println("Enter the gender");
               String gender=sc.nextLine();
               System.out.println("Enter the skilllevel");
               String skill=sc.nextLine();
               System.out.println("Enter the experience");
               int experience=sc.nextInt();
               sc.nextLine();
               System.out.println("Enter the city");
               String city=sc.nextLine();
               return new Person(name,age,gender,skill,experience,city);
    }}



























//  public ExtraDetail extraDetail{
//        Scanner sc=new Scanner(System.in);
//    ;
//        System.out.println("Enter the position");
//    String pos=sc.nextLine();
//        System.out.println("Enter the salary");
//    int salary=sc.nextInt();
//        System.out.println("Enter the exp as Manager ");
//    int exp=sc.nextInt();
//        sc.nextLine();
//    }
//}
//class ExtraDetail{
//    String pos;
//    int salary;
//    int exp;
//
//    public ExtraDetail(String pos, int salary, int exp) {
//        this.pos = pos;
//        this.salary = salary;
//        this.exp = exp;
//    }
//}
