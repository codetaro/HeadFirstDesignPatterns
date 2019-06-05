package patterns.command.remote;

public class Stereo {
    String location;

    public Stereo(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " stereo is on");
    }

    public void off() {
        System.out.println(location + " stereo is off");
    }

    public void setCd() {
        System.out.println(location + " stereo is set for CD input");
    }

    public void setDvd() {
        System.out.println(location + " stereo is set for DVD input");
    }

    public void setRadio() {
        System.out.println(location + " stereo is set for Radio");
    }

    /**
     * Code to set the volumn
     * valid range: 1-11
     *
     * @param vol
     */
    public void setVolumn(int vol) {
        System.out.println(location + " stereo volumn set to " + vol);
    }
}
