package patterns.strategy.ducks;

public class DuckCall {

    QuackBehavior quackBehavior;

    public DuckCall() {
        this.quackBehavior = new Quack();
    }

    public void performQuack() {
        quackBehavior.quack();
    }
}
