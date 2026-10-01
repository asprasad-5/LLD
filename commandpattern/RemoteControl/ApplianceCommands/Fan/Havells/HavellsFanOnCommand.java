package RemoteControl.ApplianceCommands.Fan.Havells;

import RemoteControl.Command;
import RemoteControl.ApplianceVendor.Fan.HavellsFan;
import RemoteControl.ApplianceVendor.Fan.HavellsFan.Mode;

public class HavellsFanOnCommand implements Command {

    private HavellsFan fan;

    public HavellsFanOnCommand(HavellsFan fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.turnOn();
        fan.setMode(Mode.SLEEP);
        fan.setSpeed(3);
    }
}
