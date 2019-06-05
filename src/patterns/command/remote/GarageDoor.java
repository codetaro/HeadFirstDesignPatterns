package patterns.command.remote;

public class GarageDoor {
    String location;

    public GarageDoor() {
    }

    public GarageDoor(String location) {
        this.location = location;
    }

    public void up() {
        System.out.println(location + " garage door is up");
    }

    public void down() {
        System.out.println(location + " garage door is down");
    }

    public void stop() {
        System.out.println(location + " garage door is stopped");
    }

    public void lightOn() {
        System.out.println(location + " garage light is on");
    }

    public void lightOff() {
        System.out.println(location + " garage light is off");
    }
}
