package patterns.state.gumball;

import java.util.*;

/**
 *
 */
public interface State {

    /**
     *
     */
    public void insertQuarter();

    /**
     *
     */
    public void ejectQuarter();

    /**
     *
     */
    public void turnCrank();

    /**
     *
     */
    public void dispense();

}