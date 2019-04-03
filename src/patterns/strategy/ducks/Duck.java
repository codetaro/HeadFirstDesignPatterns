package patterns.strategy.ducks;

public abstract class Duck {

    // Behavior interfaces
    QuackBehavior quackBehavior;
    FlyBehavior flyBehavior;

    public Duck() {}

    public abstract void display();

    public void swim() {
        System.out.println("All patterns.strategy.ducks float, even decoys!");
    }

    // Delegate to behavior classes
    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }

    // Setters
    public void setQuackBehavior(QuackBehavior qb) {
        this.quackBehavior = qb;
    }

    public void setFlyBehavior(FlyBehavior fb) {
        this.flyBehavior = fb;
    }
}
