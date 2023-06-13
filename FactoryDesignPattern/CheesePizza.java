package FactoryDesignPattern;

public class CheesePizza implements Pizza{
    @Override
    public void cook() {
        System.out.println("Cooking the cheese pizza.");
    }

    @Override
    public void bake() {
        System.out.println("Baking the cheese pizza.");
    }

    @Override
    public void cut() {
        System.out.println("Cutting the cheese pizza.");
    }
}
