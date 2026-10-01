package RemoteControl.ApplianceCommands.Gate.Godrej;

import RemoteControl.Command;
import RemoteControl.ApplianceVendor.Gate.GodrejGate;

public class GodrejGateOffCommand implements Command {

    private GodrejGate gate;

    public GodrejGateOffCommand(GodrejGate gate) {
        this.gate = gate;
    }

    public void execute() {
        gate.closeGate();
        gate.lock();
    }
}
