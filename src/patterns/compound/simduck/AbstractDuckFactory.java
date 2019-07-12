package patterns.compound.simduck;

public abstract class AbstractDuckFactory {

    // 每个方法创建一种鸭子
    public abstract Quackable createMallardDuck();

    public abstract Quackable createRedheadDuck();

    public abstract Quackable createDuckCall();

    public abstract Quackable createRubberDuck();
}
