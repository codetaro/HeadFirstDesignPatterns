package patterns.adapter.turkey;

import java.util.Random;

public class DuckAdapter implements Turkey {
    Duck duck;
    Random rand;

    public DuckAdapter(Duck duck) {
        this.duck = duck;
        rand = new Random();
    }

    @Override
    public void gobble() {
        duck.quack();
    }

    @Override
    public void fly() {
/*
         Since Ducks fly a lot longer than Turkeys,
         we decided to only fly the Duck on average
         one of five times
*/
        if (rand.nextInt(5) == 0) duck.fly();
    }
}
