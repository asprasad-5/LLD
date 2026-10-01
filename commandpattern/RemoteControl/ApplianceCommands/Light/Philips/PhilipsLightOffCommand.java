package RemoteControl.ApplianceCommands.Light.Philips;

import RemoteControl.Command;
import RemoteControl.ApplianceVendor.Light.PhilipsLight;

public class PhilipsLightOffCommand implements Command {

    private PhilipsLight light;

    public PhilipsLightOffCommand(PhilipsLight light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
}
