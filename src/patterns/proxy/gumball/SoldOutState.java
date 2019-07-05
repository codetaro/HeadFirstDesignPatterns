package patterns.proxy.gumball;

/**
 * In the Sold Out state, we really can't do anything until someone
 * refills the Gumball Machine.
 */
public class SoldOutState implements State {
    transient GumballMachine gumballMachine;

    /**
     * Default constructor
     */
    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    /**
     *
     */
    public void insertQuarter() {
        System.out.println("You can't insert a quarter, the machine is sold out");
    }

    /**
     *
     */
    public void ejectQuarter() {
        System.out.println("You can't eject, you haven't inserted a quarter yet");
    }

    /**
     *
     */
    public void turnCrank() {
        System.out.println("You turned, but there are no gumballs");
    }

    /**
     *
     */
    public void dispense() {
        System.out.println("No gumball dispensed");
    }

    @Override
    public void refill() {
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public String toString() {
        return "sold out";
    }
}