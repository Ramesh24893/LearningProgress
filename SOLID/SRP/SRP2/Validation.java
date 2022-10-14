package SRP2;


public class Validation {

        public static boolean validation(Person person){
            char[] arrFirst=person.firstName.toCharArray();
            char[] arrSecond=person.secondName.toCharArray();
            for(int i=0;i<arrFirst.length;i++){
                if(!Character.isLowerCase(arrFirst[i])){
                    System.out.println("You did not give us valid first name");
                    return false;
                }
            }
            for(int i=0;i<arrFirst.length;i++){
                if(!Character.isLowerCase(arrFirst[i])){
                    System.out.println("You did not give us valid second name");
                    return false;
                }
            }
            return true;
        }
    }

