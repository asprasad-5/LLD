package RemoteControl.ApplianceCommands.Light.Syska;

import RemoteControl.Command;
import RemoteControl.ApplianceVendor.Light.SyskaLight;

public class SyskaLightOnCommand implements Command {

    private SyskaLight light;

    public SyskaLightOnCommand(SyskaLight light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
