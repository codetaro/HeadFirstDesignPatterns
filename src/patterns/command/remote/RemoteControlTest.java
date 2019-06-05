package patterns.command.remote;

public class RemoteControlTest {

    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light();
        GarageDoor garageDoor = new GarageDoor();
        LightOnCommand lightOn = new LightOnCommand(light);
        GarageDoorUpCommand garageUp = new GarageDoorUpCommand(garageDoor);

        remote.setCommand(lightOn);
        remote.buttonWasPressed();
        remote.setCommand(garageUp);
        remote.buttonWasPressed();
    }
}

/*
 * RemoteControlTest = Client = Customer
 * SimpleRemoteControl = Invoker = Waitress
 * Light = Receiver = Cook
 */