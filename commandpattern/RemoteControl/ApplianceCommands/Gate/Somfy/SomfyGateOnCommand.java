package RemoteControl.ApplianceCommands.Gate.Somfy;

import RemoteControl.Command;
import RemoteControl.ApplianceVendor.Gate.SomfyGate;

public class SomfyGateOnCommand implements Command {

    private SomfyGate gate;

    public SomfyGateOnCommand(SomfyGate gate) {
        this.gate = gate;
    }

    public void execute() {
        gate.slideOpen();
    }
}
