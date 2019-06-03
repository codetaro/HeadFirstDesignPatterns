package patterns.command.remote;

public class RemoteControlWithUndo {
    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;  // 前一个命令被记录在这里

    public RemoteControlWithUndo() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        // 将每个插槽都预先指定成NoCommand对象，以便确定每个插槽永远都有命令对象
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;  // 一开始没有所谓的“前一个命令”
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPressed(int slot) {
        if (onCommands[slot] != null) {
            onCommands[slot].execute();
        }
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPressed(int slot) {
        if (offCommands[slot] != null) {
            offCommands[slot].execute();
        }
        undoCommand = offCommands[slot];
    }

    public void undoButtonWasPressed() {
        undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n------ Remote Control -------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuffer.append("[slot " + i + "] " + onCommands[i].getClass().getName()
                    + "    " + offCommands[i].getClass().getName() + "\n");
        }

        stringBuffer.append("[undo] " + undoCommand.getClass().getName());

        return stringBuffer.toString();
    }
}
