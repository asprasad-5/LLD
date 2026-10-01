package RemoteControl.ApplianceCommands.Fan.Crompton;

import RemoteControl.Command;
import RemoteControl.ApplianceVendor.Fan.CromptonFan;

public class CromptonFanOnCommand implements Command {

    private CromptonFan fan;

    public CromptonFanOnCommand(CromptonFan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.switchOn();
        fan.increaseSpeed();
    }

    @Override
    public void undo() {
        fan.decreaseSpeed();
        fan.switchOFF();
    }
}
