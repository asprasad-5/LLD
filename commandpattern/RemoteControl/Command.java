package RemoteControl;

public interface Command {
    public void execute();

    public default void undo() {
    }
}
