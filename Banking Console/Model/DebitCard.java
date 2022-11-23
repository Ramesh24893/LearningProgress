package Model;

import java.time.LocalDate;

public class DebitCard {
    private final long cardNumber;
    private final LocalDate expiryDate;
    private final int ccv;

    public DebitCard(long cardNumber, LocalDate expiryDate, int ccv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.ccv = ccv;
    }

    @Override
    public String toString() {
        return  "\nDebitCard " +
                "\nCard Number :" + cardNumber +
                "\nExpiryDate  :" + expiryDate +
                "\nCCV         :" + ccv;
    }
}
