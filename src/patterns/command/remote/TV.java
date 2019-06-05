package patterns.command.remote;

public class TV {
    String location;
    int channel;
    int volume;

    public TV(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " TV is on");
    }

    public void off() {
        System.out.println(location + " TV is off");
    }

    public void setInputChannel() {
        this.channel = 3;
        System.out.println(location + " TV channel is set for DVD");
    }

    public void setVolume() {
        this.volume = 11;
        System.out.println(location + " TV volume set to " + volume);
    }
}
