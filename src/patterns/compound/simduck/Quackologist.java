package patterns.compound.simduck;

// We need to implement the Observable interface or else
// we won't be able to register with a QuackObservable
public class Quackologist implements Observer {
    @Override
    public void update(QuackObservable duck) {
        // 打印出正在呱呱叫的Quackable对象
        System.out.println("Quackologist: " + duck + " just quacked.");
    }
}
