package FactoryDesignPattern;

public class PizzaFactory {

    //Rather than writting this code everywhere
    //create one factory class and use the methods
    //of this to get the object of Pizza class.
    public static Pizza getPizza(String type) {
        Pizza p = null;
        if(type.equals("cheese")) {
            p = new CheesePizza();
        } else if(type.equals("veg")) {
            p = new VegPizza();
        } else {
            p = new NonVegPizza();
        }

        return p;
    }

}
