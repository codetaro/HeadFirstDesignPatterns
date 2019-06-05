package patterns.command.remote;

public class RemoteLoaderWithMacro {

    public static void main(String[] args) {
        RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

        // 1. 创建想要进入宏的命令集合
        Light light = new Light("Living Room");
        TV tv = new TV("Living Room");
        Stereo stereo = new Stereo("Living Room");
        Hottub hottub = new Hottub();

        LightOnCommand lightOn = new LightOnCommand(light);
        StereoOnCommand stereoOn = new StereoOnCommand(stereo);
        TVOnCommand tvOn = new TVOnCommand(tv);
        HottubOnCommand hottubOn = new HottubOnCommand(hottub);

        LightOffCommand lightOff = new LightOffCommand(light);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);
        TVOffCommand tvOff = new TVOffCommand(tv);
        HottubOffCommand hottubOff = new HottubOffCommand(hottub);

        // 2. 创建两个数组，其中一个用来记录开启命令，另一个用来记录关闭命令
        Command[] partyOn = {lightOn, stereoOn, tvOn, hottubOn};
        Command[] partyOff = {lightOff, stereoOff, tvOff, hottubOff};

        MacroCommand partyOnMarco = new MacroCommand(partyOn);
        MacroCommand partyOffMarco = new MacroCommand(partyOff);

        // 3. 将宏命令指定给按钮
        remoteControl.setCommand(0, partyOnMarco, partyOffMarco);

        // 4. 按下按钮，测试是否正常工作
        System.out.println(remoteControl);
        System.out.println("--- Pushing Macro On ---");
        remoteControl.onButtonWasPressed(0);
        System.out.println("--- Pushing Macro Off---");
        remoteControl.offButtonWasPressed(0);
    }
}