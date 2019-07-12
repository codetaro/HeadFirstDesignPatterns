package patterns.compound.simduck;

public class DuckSimulator {
    AbstractGooseFactory gooseFactory = new QuackableGooseFactory();

    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();

        simulator.simulate(duckFactory);
    }

    private void simulate(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = gooseFactory.createQuackableGoose();

        System.out.println("\nDuck Simulator: ");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);  // 可以把被包装的鹅当作鸭子的Quackable对象

        System.out.println("The ducks quacked " + QuackCounter.getNumberOfQuacks() + " times");
    }

    // 重载simulate()方法来模拟一只鸭子
    private void simulate(Quackable duck) {
        duck.quack();
    }
}
