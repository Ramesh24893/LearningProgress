package View;
import java.util.LinkedList;
import java.util.Scanner;

public class TransactionView implements  TransactionUI{
    Scanner scannerObj=new Scanner(System.in);

    public int getAmountForTransaction(){
        System.out.println("Enter the amount");
        while(!scannerObj.hasNextInt()){
            System.out.println("\nEnter the data in number");
            System.out.println("\nEnter the amount");
            scannerObj.next();
        }
        return scannerObj.nextInt();
    }public void displayReceipt(String receipt){
        System.out.println(receipt);
    }

    public long getReceiverAccountNumber(){
        System.out.println("\nEnter receiver account number");

        while(!scannerObj.hasNextLong()){
            System.out.println("\nEnter the data in number");
            System.out.println("Enter receiver account number");
            scannerObj.next();
        }
        return scannerObj.nextLong();
    }

    public void displayAllTransactions(LinkedList<String> transactions) {
        for(String transaction: transactions){
            System.out.println("===========================================");
            System.out.println(transaction);
            System.out.println("===========================================");
        }
    }
    public void transactionSuccessMessage(){
        System.out.println("\n\n        Transaction successful  ");
    }
    public void transactionFailedMessage(){
        System.out.println("****************************************");
        System.out.println("|     Transaction Failed               |");
        System.out.println("|       Balance is low                 |");
        System.out.println("|     Deposit some amount              |");
        System.out.println("****************************************");
    }

    public void depositLimitedReachedNotification(long limit){
        System.out.println("Transaction failed");
        System.out.println("Deposit Limit  is "+ limit);
    }
    public void withdrawLimitReachedNotification(long limit){
        System.out.println("Transaction failed");
        System.out.println("Withdraw Limit is "+ limit);
    }
    public void transferLimitReachedNotification(long limit){
        System.out.println("Transaction failed");
        System.out.println("Transfer limit is "+ limit);
    }

    public void branchLimitReached(long branchResAmt) {
        System.out.println("Transaction Failed");
        System.out.println("Now Bank can provide you less than Rs "+branchResAmt);
    }
}
