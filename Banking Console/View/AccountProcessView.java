package View;
import java.util.Scanner;
import java.util.Set;


public class AccountProcessView implements AccountProcessUI {
    Scanner scannerObj=new Scanner(System.in);
    Validation validObj=new Validation();


    public String getBranchCode(Set<String> branches) {
        System.out.println("Enter the branch code");
        String branch;
        int count=1;
        do{
           if(count>1){
               System.out.println("Enter valid branch code");
           }
           branch=scannerObj.nextLine();
           count++;

        }
        while (!branches.contains(branch));
        return branch;
    }

    public String getName(){

        System.out.println("Enter the Account Holder name");
        String name;
        int count=1;
        do{
            if(count>1){
                System.out.println("Enter the valid name");

            }
            name=scannerObj.nextLine();
        count++;
        }
        while(!validObj.validateName(name));
            return name;
    }
    public  long getMobileNum() {

        Scanner scannerObj = new Scanner(System.in);
            long num;
            int count = 1;
            do {
                if (count > 1) {
                    System.out.println("Mobile number consists of 10 digits");
                }
                System.out.println("Enter the mobile number");
                while (!scannerObj.hasNextLong()) {
                    System.out.println("Enter the data in number");
                    System.out.println("Enter the Mobile Number");
                    scannerObj.next();
                }
                num= scannerObj.nextLong();

                count++;
            }
            while (!validObj.validateMobileNum(String.valueOf(num)));
            return num;
        }


    public long getExistingAccountNumber() {

        long num;
        int count = 1;
        do {
            if (count > 1) {
                System.out.println("Account number consists of 14 digits");
            }
            System.out.println("Enter the existing account Number");

            while (!scannerObj.hasNextLong()) {
                System.out.println("Enter the data in number");
                System.out.println("Enter the existing account Number");
                scannerObj.next();
            }

            num= scannerObj.nextLong();
            count++;
        }

        while (!validObj.validateAccNumber(String.valueOf(num)));
        return num;
    }

    public long getIniDepositAmt()
    {
        System.out.println("Enter amount of money to deposit in your account");

        while(!scannerObj.hasNextLong()){
            System.out.println("Enter the data in number");
            System.out.println("Enter amount of money to deposit in your account");
            scannerObj.next();
        }

        return scannerObj.nextLong();
    }
    public String getFathersName(){

        System.out.println("Enter your fathers name");
        String fatherName;
        int count=1;
        do{
            if(count>1){
                System.out.println("Enter the valid name");

            }
            fatherName=scannerObj.nextLine();
            count++;
        }
        while(!validObj.validateName(fatherName));
        return fatherName;
    }
    public long getAadhaarNumber(){

        System.out.println("Enter Aadhaar Number");
        Long num;
        int count = 1;
        do {
            if (count > 1) {
                System.out.println("Aadhaar number consists of 14 digits");
                System.out.println("Enter valid Aadhaar Number");
            }

            while (!scannerObj.hasNextLong()) {
                System.out.println("Enter the data in number");
                System.out.println("Enter Aadhaar Number");
                scannerObj.next();
            }

            num= scannerObj.nextLong();
            count++;
        }

        while (!validObj.validateAadhaar(num.toString()));
        return num;
    }

    public String getPanNumber(){
        scannerObj.nextLine();
        System.out.println("Enter the pan number");
        String panNum;
        int count=1;
        do{
            if(count>1){
                System.out.println("Enter the pan number");

            }
            panNum=scannerObj.nextLine();
            count++;
        }
        while(!validObj.validatePan(panNum));
        return panNum;
    }

    public String getCityName(){
        System.out.println("Enter the city name");
        String city;
        int count=1;
        do{
            if(count>1){
                System.out.println("Enter the valid city name");

            }
            city=scannerObj.nextLine();
            count++;
        }
        while(!validObj.validateName(city));
        return city;
    }

    public  int getAge(){
        System.out.println("Enter age in number");
        int age=0;
        int count=1;
        do{
            if(count>1){
                scannerObj.next();
                System.out.println("Enter the valid age");
            }
            count++;
        }
        while(!(scannerObj.hasNextInt()));
        age=scannerObj.nextInt();
        return age;
    }
    public String getGender(){
        scannerObj.nextLine();
        System.out.println("Enter gender\n\nM for Male\nF for Female\nO for Others");
        String gender;
        int count=1;
        do{
            if(count>1){
                System.out.println("Enter M or F or O");
            }
           gender=scannerObj.nextLine();
            count++;
        }
        while(!validObj.validateGender(gender));
        return gender;
    }


    public void accDeletionMessage() {
        System.out.println("\n Your account is deleted");
    }

    public void existingAccountLinkingFailed(){

        System.out.println("Linking with existing account is failed");
    }
    public void existingAccountLinkingSuccessful(){

        System.out.println("Linking with existing account is successful");
    }


    public void accCreationSuccessfulNotification() {

        System.out.println("account created successfully");
    }

}
