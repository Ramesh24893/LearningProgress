//Inheritance
package Inheritance;
abstract class Loan{
    //The class has methods and variable which are common for all type of Loan
    //When other class like home,vehicle loan extend this class, all fuctionality and member avalaible to extended class
    String applicantName;
    String nomineeName;
    String applicantAddress;
    String applicantPanNo;
    int applicantAadharNo;
    public abstract void checkEligibilityCriteria();
    public abstract void calculateInterestrate();
}
class VehileLoan extends Loan{
    String vehicleNo;
    String drivingLicense;
    public void getVehicleInsurance(){
        System.out.println("VehicleInsurance submitted to bank");
    }
    public void checkVehicleCondition(){
        System.out.println("Vehicle condition is checked");
    }public void checkEligibilityCriteria(){
        System.out.println("Eligibility is checked");
    }
    public void calculateInterestrate(){
        System.out.println("Interest is calculated");
    }
}
class HomeLoan extends Loan{
    String homeAddress;
    String houseOwner;
    public void getDeedForm(){
        System.out.println("deed form is submitted to bank");
    }
    public void checkHomevalue(){
        System.out.println("Home value is checked");
    }
    public void checkEligibilityCriteria(){
        System.out.println("Eligibility is checked");
    }
    public void calculateInterestrate(){
        System.out.println("Interest is calculated");
    }
}
public class Applicant{
    public static void main(String[] args){
        HomeLoan loanform=new HomeLoan();
    }
}
