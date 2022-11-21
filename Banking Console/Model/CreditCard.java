package Model;

import java.time.LocalDate;

public class CreditCard {
    private long cardNumber;
    private LocalDate expiryDate;
    private int ccv;


    public CreditCard(long cardNumber, LocalDate expiryDate, int ccv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.ccv = ccv;
    }

    @Override
    public String toString() {
        return "CreditCard" +
                "\nCardNumber: " + cardNumber +
                "\nExpiryDate: " + expiryDate +
                "\nCCV       : " + ccv ;
    }
}
