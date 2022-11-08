package Model;

import java.util.Date;

public class Card {
    private int number;
    private Date expiryDate;
    private int ccv;

    public Card(int number, Date expiryDate, int ccv) {
        this.number = number;
        this.expiryDate = expiryDate;
        this.ccv = ccv;
    }

    public int getNumber() {
        return number;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public int getCcv() {
        return ccv;
    }
}
