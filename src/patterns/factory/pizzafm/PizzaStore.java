package patterns.factory.pizzafm;

import patterns.factory.pizzas.Pizza;
import patterns.factory.pizzas.SimplePizzaFactory;

public abstract class PizzaStore {
    SimplePizzaFactory factory;

    public PizzaStore() {
    }

    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    abstract Pizza createPizza(String type);
}
