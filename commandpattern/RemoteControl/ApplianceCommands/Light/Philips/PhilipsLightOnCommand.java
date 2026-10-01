package RemoteControl.ApplianceCommands.Light.Philips;

import RemoteControl.Command;
import RemoteControl.ApplianceVendor.Light.PhilipsLight;

public class PhilipsLightOnCommand implements Command {

    private PhilipsLight light;

    public PhilipsLightOnCommand(PhilipsLight light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }
}
