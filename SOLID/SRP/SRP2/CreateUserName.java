package SRP2;

public class CreateUserName {
    public static void  create(Person person){
        String userName=person.firstName.charAt(0)+person.secondName;
        System.out.println("Your username is:  " +userName);
    }
}

