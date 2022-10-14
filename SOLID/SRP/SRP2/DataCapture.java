package SRP2;

import java.util.Scanner;

public class DataCapture {
    public static Person getDetails() {
            Scanner sc=new Scanner(System.in);
            Person person = new Person();
            System.out.println("Enter your first name");
            person.firstName = sc.nextLine();
            System.out.println("Enter your second name");
            person.secondName = sc.nextLine();
            return person;
        }
    }

