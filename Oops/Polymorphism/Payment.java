//Method Overloading
package Polymorphism;
class DebitCard{}
class CreditCard{}
class Cash{}
class Mode{
    public void makePayment(DebitCard debit){
        System.out.println("Payment done through debitcard");
    }
    public void makePayment(CreditCard credit){
        System.out.println("Payment done through creditcard");
    }
    public void makePayment(Cash cash){
        System.out.println("Payment done through cash");
    }
}
public class Payment {
    public static void main(String[] args){
        Mode mode=new Mode();
        mode.makePayment(new DebitCard());
        mode.makePayment(new CreditCard());
        mode.makePayment(new Cash());
    }
}
