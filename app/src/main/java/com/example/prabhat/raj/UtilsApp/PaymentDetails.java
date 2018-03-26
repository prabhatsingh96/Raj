package com.example.prabhat.raj.UtilsApp;

/**
 * Created by fluper on 26/3/18.
 */

public class PaymentDetails {

    private String cardNumber;
    private String months;
    private String year;
    private String cvv;

    public PaymentDetails() {
    }

    public PaymentDetails(String cardNumber, String months, String year) {
        this.cardNumber = cardNumber;
        this.months = months;
        this.year = year;
       // this.cvv = cvv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getMonths() {
        return months;
    }

    public void setMonths(String months) {
        this.months = months;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
