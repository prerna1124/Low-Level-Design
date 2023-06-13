package FactoryDesignPattern;

public class NonVegPizza implements Pizza{
    @Override
    public void cook() {
        System.out.println("Cooking the NonVegPizza pizza.");
    }

    @Override
    public void bake() {
        System.out.println("Baking the NonVegPizza pizza.");
    }

    @Override
    public void cut() {
        System.out.println("Cutting the NonVegPizza pizza.");
    }
}
