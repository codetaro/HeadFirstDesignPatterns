package patterns.compound.simduck;

public interface Observer {
    // 需要传入正在呱呱叫的对象
    public void update(QuackObservable duck);
}
