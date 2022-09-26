//Encapsulation
    //If a member is declared is private it can be accessed within the class
    //Or else I can be accessed in another class ny using getter and setter method of the class where the member is declared as private I
package Encapsulation;
import java.util.Scanner;
class BankBalance {
    private float balance = 20000f;
    int pin = 2489;
    public float atmBalanceCheck(int pin) {
        if (this.pin == pin) return balance;
        else return 0;
    }
    //The above method is like Authentication and validation
}
public class Atm {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        BankBalance bank=new BankBalance();
        System.out.println("Enter the 4 digit pin");
        int pin=sc.nextInt();
        float amount=bank.atmBalanceCheck(pin);
        if(amount==0){
            System.out.println("Invalid pin");
        }else{
        System.out.println(amount);
        }}
}