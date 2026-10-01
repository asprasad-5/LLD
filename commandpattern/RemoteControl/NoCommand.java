package RemoteControl;

public class NoCommand implements Command {

    @Override
    public void execute() {
        // No-op: Null Object Pattern
    }

    @Override
    public void undo() {
        // No-op: Null Object Pattern
    }
}
