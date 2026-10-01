package RemoteControl.ApplianceCommands.Gate.Somfy;

import RemoteControl.Command;
import RemoteControl.ApplianceVendor.Gate.SomfyGate;

public class SomfyGateOffCommand implements Command {

    private SomfyGate gate;

    public SomfyGateOffCommand(SomfyGate gate) {
        this.gate = gate;
    }

    public void execute() {
        gate.slideClose();
    }
}
