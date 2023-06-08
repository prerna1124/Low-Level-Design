package StrategyDesignPattern;

public class StrategyPatternTesting {
    public static void main(String[] args) {
        Item item1 = new Item(101, "Mango", 150);
        Item item2 = new Item(102, "Curd", 45);

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(item1);
        cart.addItem(item2);

        cart.pay(new CreditCardPaymentStrategy("Prerna Sharma", "123456789876",234));
        cart.pay(new UpiPaymentStrategy("0000@okicici"));
    }
}
