//-------------------------SINGLE RESPONSIBILITY PRINCIPLE----------------------------------------
// A class or component must  have single responsibility
//  A  class should have one, and only one reason to change
//It doesn't mean there should be one method in a class , A class can have a group of functions which has same motive
//Don't put functions that changes for different changes in a same class
//We should separate based on the needs
//We should not separate too many classes
//------------------------Why---------------------------------------------------------
// If a module(A) contains lot of responsibilities
// All the module which are related to that responsibilities can access the module A
//--------------------------------------------------------------------------------------------------
//Below code is to create a username ,this class has lot of responsibilities
//like Validation, receiving data, printing standard messages and create username

package SRP1;
import SRP2.Person;

import java.util.Scanner;
public class ViolatedSingleResponsibilityPrinciple {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to my Application");
        Person person= new Person();
        System.out.println("Enter your first name");
        person.firstName=sc.nextLine();
        System.out.println("Enter your second name");
        person.secondName=sc.nextLine();
        char[] arrFirst=person.firstName.toCharArray();
        char[] arrSecond=person.secondName.toCharArray();
        for(int i=0;i<arrFirst.length;i++){
            if(!Character.isLowerCase(arrFirst[i])){
                System.out.println("You did not give us valid username");
                return;
            }
        }
        for(int i=0;i<arrFirst.length;i++){
            if(!Character.isLowerCase(arrSecond[i])){
                System.out.println("You did not give us valid username");
                return;
            }
        }
        String userName=person.firstName.charAt(0)+person.secondName;
        System.out.println("Your username is");
        System.out.println(userName);

    }
}






