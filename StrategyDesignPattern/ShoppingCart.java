package StrategyDesignPattern;
import java.util.List;
import java.util.ArrayList;

public class ShoppingCart {
    List<Item> items;

    ShoppingCart() {
        items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    private float getTotalAmount() {
        float totalAmount = 0;
        for(Item item : items) {
            totalAmount += item.getPrice();
        }

        return totalAmount;
    }

    public void pay(PaymentStrategy paymentStrategy) {
        float totalAmount = getTotalAmount();
        paymentStrategy.pay(totalAmount);
    }
}
