package patterns.command.remote;

public class TV {
    String location;

    public TV(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " TV is on");
        setInputChannel();
    }

    public void off() {
        System.out.println(location + " TV is off");
    }

    public void setInputChannel() {
        System.out.println(location + " TV channel is set for DVD");
    }

    public void setVolumn() {
    }
}
