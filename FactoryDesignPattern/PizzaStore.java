package FactoryDesignPattern;

public class PizzaStore {
    public static void main(String[] args) {
        Pizza pizza = PizzaFactory.getPizza("cheese");
        pizza.cook();
        pizza.bake();
        pizza.cut();
    }
}
