package patterns.state.gumball;

public class GumballMachine {
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State soldOutState;

    // 创建一个实例变量持有当前状态
    State state = soldOutState;
    int count = 0;

    public GumballMachine(int numberGumballs) {
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);

        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    // 系统中所有可以发生的动作
    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    void setState(State state) {
        this.state = state;
    }

    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
        }
    }

    // Getters
    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public int getCount() {
        return count;
    }

    // more of an internal action the machine invokes on itself
    public void dispense() {
    }

    // 其它方法
    public void refill(int numGumBalls) {
        this.count += numGumBalls;
        System.out.println("The gumball machine was just refilled; it's new count is: " + this.count);
//        state.refill();
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004\n");
        result.append("Inventory: " + count + " gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\nMachine is " + state);
        result.append("\n");
        return result.toString();
    }
}
