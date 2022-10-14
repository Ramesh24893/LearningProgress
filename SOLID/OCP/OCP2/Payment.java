// In the below OCP is violated because I can't add any new feature without changing the code
// If a code has switch or if we cant extend without changing the existing code

package OCP2;

public class Payment {
    String accountType;
    public Payment(String accountType){
        this.accountType=accountType;
    }
    public static void makePayment(Payment account){
        if(account.accountType.equals("Credit")){
            System.out.println("Payment done through Credit");
        }
        else if(account.accountType.equals("Debit")){
            System.out.println("Payment done through Debit");
        }
        else{
            System.out.println("invalid type");
        }

    }

    public static void main(String[] args) {
        Payment pay=new Payment("Debit");
        makePayment(pay);
    }
}
