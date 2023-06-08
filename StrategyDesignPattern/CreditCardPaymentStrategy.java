package StrategyDesignPattern;

import org.w3c.dom.NameList;

public class CreditCardPaymentStrategy implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private int cvvCode;
    
    CreditCardPaymentStrategy(String name, String cardNumber, int cvvCode) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvvCode = cvvCode;
    }

    @Override
    public void pay(float amount) {
        System.out.println(amount + " Paid via Credit Card/ Debit Card");
    }
}
