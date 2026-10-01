package RemoteControl;

import java.util.List;

public class MacroCommand implements Command {

    private final Command[] commands;

    public MacroCommand(Command[] commands) {
        this.commands = commands != null ? commands : new Command[0];
    }

    public MacroCommand(List<Command> commands) {
        this.commands = commands != null ? commands.toArray(new Command[0]) : new Command[0];
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        // Undo in reverse execution order
        for (int i = commands.length - 1; i >= 0; i--) {
            commands[i].undo();
        }
    }
}
