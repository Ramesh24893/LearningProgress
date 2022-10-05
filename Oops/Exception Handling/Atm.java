package Exceptional;

class InsufficientFundException extends Exception{
    InsufficientFundException(String str){
        super(str);
    }
}
public class Atm{
    public static void main(String[] args) throws InsufficientFundException {
       try{ withdrawl(1000);}
       catch(InsufficientFundException e){
           System.out.println(e);
       }
    }
    public static void withdrawl(int money) throws InsufficientFundException {
        int balance=500;
    if(money>balance){
        throw new InsufficientFundException("Insufficient fund");
    }
        }
}
