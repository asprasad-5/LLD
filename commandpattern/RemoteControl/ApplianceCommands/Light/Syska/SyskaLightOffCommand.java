package RemoteControl.ApplianceCommands.Light.Syska;

import RemoteControl.Command;
import RemoteControl.ApplianceVendor.Light.SyskaLight;

public class SyskaLightOffCommand implements Command {

    private SyskaLight light;

    public SyskaLightOffCommand(SyskaLight light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
