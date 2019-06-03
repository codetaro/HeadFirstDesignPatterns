package patterns.command.remote;

public class CeilingFan {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    String location;
    int speed;

    public CeilingFan(String location) {
        this.location = location;
        speed = OFF;
    }

    public void high() {
        setSpeed(HIGH);
        System.out.println(location + " fan is on high");
    }

    public void medium() {
        setSpeed(MEDIUM);
        System.out.println(location + " fan is on medium");
    }

    public void low() {
        setSpeed(LOW);
        System.out.println(location + " fan is on low");
    }

    public void off() {
        setSpeed(OFF);
        System.out.println(location + " fan is off");
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
