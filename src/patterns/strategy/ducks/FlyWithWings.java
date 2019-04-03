package patterns.strategy.ducks;

/**
 * Implementation of FlyBehavior for real patterns.strategy.ducks
 */
public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I'm flying!!");
    }
}
