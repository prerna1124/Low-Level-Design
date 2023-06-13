package FactoryDesignPattern;

public class VegPizza implements Pizza{
    @Override
    public void cook() {
        System.out.println("Cooking the Veg pizza.");
    }

    @Override
    public void bake() {
        System.out.println("Baking the Veg pizza.");
    }

    @Override
    public void cut() {
        System.out.println("Cutting the Veg pizza.");
    }
}
