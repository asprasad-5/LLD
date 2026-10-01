package RemoteControl.ApplianceCommands.Fan.Havells;

import RemoteControl.Command;
import RemoteControl.ApplianceVendor.Fan.HavellsFan;

public class HavellsFanOffCommand implements Command {

    private HavellsFan fan;

    public HavellsFanOffCommand(HavellsFan fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.setSpeed(0);
        fan.turnOff();
    }
}
