package RemoteControl.ApplianceCommands.Gate.Godrej;

import RemoteControl.Command;
import RemoteControl.ApplianceVendor.Gate.GodrejGate;

public class GodrejGateOnCommand implements Command {

    private GodrejGate gate;

    public GodrejGateOnCommand(GodrejGate gate) {
        this.gate = gate;
    }

    public void execute() {
        gate.openGate();
    }
}
