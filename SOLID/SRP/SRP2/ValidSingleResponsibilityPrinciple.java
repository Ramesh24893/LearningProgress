package SRP2;

public class ValidSingleResponsibilityPrinciple {
    public static void main(String[] args) {
        StandardMessage.welcomeMessage();
        Person person=DataCapture.getDetails();
        boolean valid= Validation.validation(person);
        if(valid==true){

            CreateUserName.create(person);
        }
        else{
            StandardMessage.invalidMessage();
        }
        StandardMessage.endMessage();

    }
}
