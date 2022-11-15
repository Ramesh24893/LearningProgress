package Controller;

import java.time.LocalDate;
import java.time.LocalTime;

public class TransactionDataGenerator {
    public String generateWithDrawTransactionData(long amount,long accountBalance,long taxAmount){
        String data="Transaction Type: Withdraw"+
                "\nAmount: "+ amount+
                "\nDate: "+ LocalDate.now()+
                "\nTime:"+LocalTime.now().getHour()+": "+LocalTime.now().getMinute()+
                "\nTax Charged:"+ taxAmount+
                "\nBalance:"+ accountBalance;

        return data;
    }

    public String generateDepositTransactionData(long amount,long accountBalance,long taxAmount){
        String data="Transaction Type: Deposit"+
                "\nAmount: "+ amount+
                "\nDate: "+ LocalDate.now()+
                "\nTime:"+LocalTime.now().getHour()+": "+LocalTime.now().getMinute()+
                "\nTax Charged:"+ taxAmount+
                "\nBalance:"+ accountBalance;
        return data;
    }

    public String generateSenderTransactionData(long amount,long receiverAccountNum,long accountBalance,long taxAmount){
        String data="Transaction Type: Account to Account"+
                "\nDebitAmount: "+ amount+
                "\nDate: "+ LocalDate.now()+
                "\nTime:"+LocalTime.now().getHour()+": "+LocalTime.now().getMinute()+
                "\nReceiver Account Number : "+ receiverAccountNum+
                "\nTax Charged:"+ taxAmount+
                "\nBalance:"+ accountBalance;
        return data;
    }

    public String generateReceiverTransactionData(long amount,long senderAccountNum,long accountBalance){
        String data="Transaction Type: Account to Account"+
                "\nCreditAmount: "+ amount+
                "\nDate: "+ LocalDate.now()+
                "\nTime:"+LocalTime.now().getHour()+": "+LocalTime.now().getMinute()+
                "\nSender Account Number : "+ senderAccountNum+
                "\nBalance:"+ accountBalance;
        return data;
    }
}
