package View;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountProcessView implements AccountProcessUI {
    Scanner scannerObj=new Scanner(System.in);
    public HashMap<String,String> userInputsForAccGen(){

        HashMap<String,String> inputs=new HashMap<>();

        inputs.put("branchCode",getBranchCode());
        inputs.put("name",getName());
        inputs.put("father",getFathersName());
        inputs.put("age",getAge());
        inputs.put("gender",getGender());
        inputs.put("city",getCityName());
        inputs.put("mobNum",getMobileNum());
        inputs.put("aadhaar",getAadhaarNumber());
        inputs.put("pan",getPanNumber());
        inputs.put("iniDepositAmt",getIniDepositAmt());
        return inputs;
    }

    public String getBranchCode() {

        System.out.println("Enter the branch code");
        return scannerObj.nextLine();
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
        while(!validateName(name));
            return name;
    }
    public  String getMobileNum() {

            Scanner scannerObj = new Scanner(System.in);
            Long num;
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
            while (!validateMobileNum(num.toString()));
            return num.toString();
        }


    public String getExistingAccountNumber() {
        Scanner scannerObj = new Scanner(System.in);
        Long num=0L;
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

        while (!validateAccNumber(num.toString()));
        return num.toString();
    }

    public String getIniDepositAmt()
    {
        System.out.println("Enter amount of money to deposit in your account");

        while(!scannerObj.hasNextLong()){
            System.out.println("Enter the data in number");
            System.out.println("Enter amount of money to deposit in your account");
            scannerObj.next();
        }

        long num=scannerObj.nextLong();
        return Long.toString(num);
    }


public HashMap<String,String> userInputsToLinkAcc() {

    HashMap<String, String> inputs = new HashMap<>();

    inputs.put("name",getName());
    inputs.put("mobNum",getMobileNum());
    scannerObj.nextLine();

    inputs.put("accountNumber", getExistingAccountNumber());
    return inputs;
}
public void existingAccountLinkingFailed(){

        System.out.println("Linking with existing account is failed");
}
    public void existingAccountLinkingSuccessful(){

        System.out.println("Linking with existing account is successful");
    }
    public void invalidBranchDataNotification(){

        System.out.println("Enter valid branch code");
    }

    public void accCreationSuccessfulNotification() {

        System.out.println("account created successfully");
    }

    public String getFathersName(){
        System.out.println("Enter your fathers name");
        return scannerObj.nextLine();
    }
    public String getAadhaarNumber(){
        System.out.println("Enter Aadhaar Number");
        return scannerObj.nextLine();

    }
    public String getPanNumber(){
        System.out.println("Enter Pan Number");
        return scannerObj.nextLine();
    }
    public String getCityName(){
        System.out.println("Enter city name");
        return scannerObj.nextLine();
    }
    public String getAge(){
        System.out.println("Enter age in number");
        return scannerObj.nextLine();
    }
    public String getGender(){
        System.out.println("Enter gender");
        return scannerObj.nextLine();
    }

    public boolean validateMobileNum(String mobileNum){

        Pattern pattern = Pattern.compile("[6-9]{1}[0-9]{9}");
        Matcher matcher = pattern.matcher(mobileNum);
        return matcher.matches();
    }
    public boolean validateAccNumber(String accNum){

        Pattern pattern = Pattern.compile("[6-9]{1}[0-9]{13}");
        Matcher matcher = pattern.matcher(accNum);
        return matcher.matches();
    }
    public boolean validateName(String name){
        Pattern pattern=Pattern.compile("[A-Za-z]{4,}");
        Matcher matcher= pattern.matcher(name);
        return matcher.matches();
    }
}
