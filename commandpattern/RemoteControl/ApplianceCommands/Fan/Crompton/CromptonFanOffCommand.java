package RemoteControl.ApplianceCommands.Fan.Crompton;

import RemoteControl.Command;
import RemoteControl.ApplianceVendor.Fan.CromptonFan;

public class CromptonFanOffCommand implements Command {

    private CromptonFan fan;

    public CromptonFanOffCommand(CromptonFan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.decreaseSpeed();
        fan.switchOFF();
    }

    @Override
    public void undo() {
        fan.switchOn();
        fan.increaseSpeed();
    }
}
