package patterns.compound.simduck;

public class GooseAdapter implements Quackable {  // 适配器会实现目标接口
    Observable observable;
    Goose goose;

    public GooseAdapter(Goose goose) {  // 构造器需要传入要适配的对象
        this.goose = goose;
        observable = new Observable(this);
    }

    @Override
    public void quack() {
        goose.honk();  // 委托到被适配对象的方法
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }

    @Override
    public void removeObserver(Observer observer) {
        observable.removeObserver(observer);
    }

    @Override
    public String toString() {
        return "Goose pretending to be a Duck";
    }
}
