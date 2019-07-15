package patterns.compound.simduck;

import java.util.ArrayList;
import java.util.Iterator;

public class Flock implements Quackable {
    Observable observable;
    ArrayList<Quackable> quackers = new ArrayList<>();

    public Flock() {
        observable = new Observable(this);
    }

    public void add(Quackable quacker) {
        quackers.add(quacker);
    }

    @Override
    // 此方法会对整群产生作用
    public void quack() {
        Iterator<Quackable> iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackable quacker = iterator.next();
            quacker.quack();
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        Iterator<Quackable> iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackable quacker = iterator.next();
            quacker.registerObserver(observer);
        }
    }

    @Override
    public void notifyObservers() {
        Iterator<Quackable> iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackable quacker = iterator.next();
            quacker.notifyObservers();
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        Iterator<Quackable> iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackable quacker = iterator.next();
            quacker.removeObserver(observer);
        }
    }

    @Override
    public String toString() {
        return "Flock of Ducks";
    }
}
