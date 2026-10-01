package RemoteControl;

/*
In this example, we are taking a home control remote that has on and off buttons that can be configured to different appliances.
Each appliance can be mapped to one on and off button. (Configurable slots, defaults to 3)
There is also a macro on and off button that can be configured to control multiple appliances at once.
*/

public class SimpleRemoteControl {

    private static final int DEFAULT_SLOTS = 3;

    private final Command[] onCommands;
    private final Command[] offCommands;
    private Command undoCommand;

    private Command macroOnCommand;
    private Command macroOffCommand;

    public SimpleRemoteControl() {
        this(DEFAULT_SLOTS);
    }

    public SimpleRemoteControl(int slots) {
        int count = Math.max(1, slots);
        this.onCommands = new Command[count];
        this.offCommands = new Command[count];

        Command noCommand = new NoCommand();
        for (int i = 0; i < count; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        this.undoCommand = noCommand;
        this.macroOnCommand = noCommand;
        this.macroOffCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        if (slot >= 0 && slot < onCommands.length) {
            this.onCommands[slot] = onCommand != null ? onCommand : new NoCommand();
            this.offCommands[slot] = offCommand != null ? offCommand : new NoCommand();
        } else {
            System.out.println("Invalid slot index: " + slot);
        }
    }

    public void onButtonWasPushed(int slot) {
        if (slot >= 0 && slot < onCommands.length) {
            onCommands[slot].execute();
            undoCommand = onCommands[slot];
        } else {
            System.out.println("Invalid slot index: " + slot);
        }
    }

    public void offButtonWasPushed(int slot) {
        if (slot >= 0 && slot < offCommands.length) {
            offCommands[slot].execute();
            undoCommand = offCommands[slot];
        } else {
            System.out.println("Invalid slot index: " + slot);
        }
    }

    public void undoButtonWasPushed() {
        System.out.println("--- Undo Pressed ---");
        undoCommand.undo();
    }

    // Macro command configuration
    public void setMacroCommand(Command macroOn, Command macroOff) {
        this.macroOnCommand = macroOn != null ? macroOn : new NoCommand();
        this.macroOffCommand = macroOff != null ? macroOff : new NoCommand();
    }

    public void macroOnButtonWasPushed() {
        System.out.println("--- Macro ON Pressed ---");
        macroOnCommand.execute();
        undoCommand = macroOnCommand;
    }

    public void macroOffButtonWasPushed() {
        System.out.println("--- Macro OFF Pressed ---");
        macroOffCommand.execute();
        undoCommand = macroOffCommand;
    }

    // Backward-compatible slot aliases
    public void setAppliance0(Command on, Command off) {
        setCommand(0, on, off);
    }

    public void setAppliance1(Command on, Command off) {
        setCommand(1, on, off);
    }

    public void setAppliance2(Command on, Command off) {
        setCommand(2, on, off);
    }

    public void onAppliance0() {
        onButtonWasPushed(0);
    }

    public void offAppliance0() {
        offButtonWasPushed(0);
    }

    public void onAppliance1() {
        onButtonWasPushed(1);
    }

    public void offAppliance1() {
        offButtonWasPushed(1);
    }

    public void onAppliance2() {
        onButtonWasPushed(2);
    }

    public void offAppliance2() {
        offButtonWasPushed(2);
    }

    public void on(int slot) {
        onButtonWasPushed(slot);
    }

    public void off(int slot) {
        offButtonWasPushed(slot);
    }

    public int getSlotCount() {
        return onCommands.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n------ Remote Control Setup ------\n");
        for (int i = 0; i < onCommands.length; i++) {
            sb.append("[Slot ").append(i).append("] ON: ")
              .append(onCommands[i].getClass().getSimpleName())
              .append(" | OFF: ")
              .append(offCommands[i].getClass().getSimpleName())
              .append("\n");
        }
        sb.append("[Macro]  ON: ")
          .append(macroOnCommand.getClass().getSimpleName())
          .append(" | OFF: ")
          .append(macroOffCommand.getClass().getSimpleName())
          .append("\n");
        sb.append("[Undo]   ")
          .append(undoCommand.getClass().getSimpleName())
          .append("\n----------------------------------\n");
        return sb.toString();
    }
}
