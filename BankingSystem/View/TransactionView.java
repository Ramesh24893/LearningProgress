package View;
import java.util.LinkedList;
import java.util.Scanner;

public class TransactionView {
    Scanner scannerObj=new Scanner(System.in);
    public int getAmountForWithdraw(){
        System.out.println("Enter the withdraw amount");
        while(!scannerObj.hasNextInt()){
            System.out.println("\nEnter the data in number");
            System.out.println("\nEnter the withdraw amount");
            scannerObj.next();
        }
        return scannerObj.nextInt();
    }
    public int getAmountForDeposit(){
        System.out.println("\nEnter the deposit amount");
        while(!scannerObj.hasNextInt()){
            System.out.println("\nEnter the data in number");
            System.out.println("Enter the deposit amount");
            scannerObj.next();
        }
        return scannerObj.nextInt();
    }
    public int getAmountForTransfer(){
        System.out.println("\nEnter the  amount to transfer");

        while(!scannerObj.hasNextInt()){
            System.out.println("\nEnter the data in number");
            System.out.println("Enter the withdraw amount");
            scannerObj.next();
        }
        return scannerObj.nextInt();
    }
    public void displayReceipt(String receipt){
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
            System.out.println(transaction);
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

    public void depositLimitedReached(long limit){
        System.out.println("Transaction failed");
        System.out.println("Deposit Limit  is "+ limit);
    }
    public void withdrawLimitReached(long limit){
        System.out.println("Transaction failed");
        System.out.println("Withdraw Limit is "+ limit);
    }
    public void transferLimitReached(long limit){
        System.out.println("Transaction failed");
        System.out.println("Transfer limit is "+ limit);
    }
}
