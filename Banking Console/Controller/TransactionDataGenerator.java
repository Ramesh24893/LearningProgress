package Controller;
import java.time.LocalDate;
import java.time.LocalTime;

public class TransactionDataGenerator implements BankTransactionDataGenerator{
    public String generateWithDrawTransactionData(long amount, long accountBalance, long taxAmount){

        return "Transaction Type: Withdraw"+
                "\nAmount: "+ amount+
                "\nDate: "+ LocalDate.now()+
                "\nTime:"+LocalTime.now().getHour()+": "+LocalTime.now().getMinute()+
                "\nTax Charged:"+ taxAmount+
                "\nBalance:"+ accountBalance;
    }

    public String generateDepositTransactionData(long amount,long accountBalance,long taxAmount){

        return "Transaction Type: Deposit"+
                "\nAmount: "+ amount+
                "\nDate: "+ LocalDate.now()+
                "\nTime:"+LocalTime.now().getHour()+": "+LocalTime.now().getMinute()+
                "\nTax Charged:"+ taxAmount+
                "\nBalance:"+ accountBalance;
    }

    public String generateSenderTransactionData(long amount,long receiverAccountNum,long accountBalance,long taxAmount){

        return "Transaction Type: Account to Account"+
                "\nDebitAmount: "+ amount+
                "\nDate: "+ LocalDate.now()+
                "\nTime:"+LocalTime.now().getHour()+": "+LocalTime.now().getMinute()+
                "\nReceiver Account Number : "+ receiverAccountNum+
                "\nTax Charged:"+ taxAmount+
                "\nBalance:"+ accountBalance;
    }

    public String generateReceiverTransactionData(long amount,long senderAccountNum,long accountBalance){

        return "Transaction Type: Account to Account"+
                "\nCreditAmount: "+ amount+
                "\nDate: "+ LocalDate.now()+
                "\nTime:"+LocalTime.now().getHour()+": "+LocalTime.now().getMinute()+
                "\nSender Account Number : "+ senderAccountNum+
                "\nBalance:"+ accountBalance;
    }

}
