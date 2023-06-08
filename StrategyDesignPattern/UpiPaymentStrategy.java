package StrategyDesignPattern;

public class UpiPaymentStrategy implements PaymentStrategy {
    private String upiId;

    UpiPaymentStrategy(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(float amount) {
        System.out.println(amount + " Paid via Upi");
    }
}
