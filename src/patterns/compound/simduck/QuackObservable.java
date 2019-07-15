package patterns.compound.simduck;

public interface QuackObservable {
    public void registerObserver(Observer observer);

    public void notifyObservers();

    public void removeObserver(Observer observer);
}
