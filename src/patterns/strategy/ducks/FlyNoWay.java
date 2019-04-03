package patterns.strategy.ducks;

/**
 * Implementation of FlyBehavior for patterns.strategy.ducks that cannot fly
 */
public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
