package RemoteControl;

import RemoteControl.ApplianceCommands.Fan.Crompton.CromptonFanOffCommand;
import RemoteControl.ApplianceCommands.Fan.Crompton.CromptonFanOnCommand;
import RemoteControl.ApplianceCommands.Light.Philips.PhilipsLightOffCommand;
import RemoteControl.ApplianceCommands.Light.Philips.PhilipsLightOnCommand;
import RemoteControl.ApplianceCommands.Light.Syska.SyskaLightOffCommand;
import RemoteControl.ApplianceCommands.Light.Syska.SyskaLightOnCommand;
import RemoteControl.ApplianceVendor.Fan.CromptonFan;
import RemoteControl.ApplianceVendor.Light.PhilipsLight;
import RemoteControl.ApplianceVendor.Light.SyskaLight;

public class RemoteControlTest {

    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl(3);

        // 1. Receivers (Vendor Appliances)
        PhilipsLight livingRoomLight = new PhilipsLight();
        SyskaLight kitchenLight = new SyskaLight();
        CromptonFan ceilingFan = new CromptonFan();

        // 2. Concrete Commands
        PhilipsLightOnCommand livingRoomLightOn = new PhilipsLightOnCommand(livingRoomLight);
        PhilipsLightOffCommand livingRoomLightOff = new PhilipsLightOffCommand(livingRoomLight);

        SyskaLightOnCommand kitchenLightOn = new SyskaLightOnCommand(kitchenLight);
        SyskaLightOffCommand kitchenLightOff = new SyskaLightOffCommand(kitchenLight);

        CromptonFanOnCommand fanOn = new CromptonFanOnCommand(ceilingFan);
        CromptonFanOffCommand fanOff = new CromptonFanOffCommand(ceilingFan);

        // 3. Configure Remote Control Slots
        remote.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remote.setCommand(1, kitchenLightOn, kitchenLightOff);
        remote.setCommand(2, fanOn, fanOff);

        System.out.println(remote);

        // 4. Test Slot 0 (Living Room Light) + Undo
        System.out.println("--- Testing Slot 0 ---");
        remote.onButtonWasPushed(0);
        remote.offButtonWasPushed(0);
        remote.undoButtonWasPushed();

        // 5. Test Slot 2 (Fan) + Undo
        System.out.println("\n--- Testing Slot 2 ---");
        remote.onButtonWasPushed(2);
        remote.undoButtonWasPushed();

        // 6. Test Macro Command (Party Mode: All appliances ON / All appliances OFF)
        System.out.println("\n--- Setting up Macro Command (Party Mode) ---");
        Command[] partyOn = { livingRoomLightOn, kitchenLightOn, fanOn };
        Command[] partyOff = { livingRoomLightOff, kitchenLightOff, fanOff };

        MacroCommand partyOnMacro = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partyOff);

        remote.setMacroCommand(partyOnMacro, partyOffMacro);

        System.out.println("\n--- Testing Macro ON ---");
        remote.macroOnButtonWasPushed();

        System.out.println("\n--- Testing Macro Undo (Reverses all in reverse order) ---");
        remote.undoButtonWasPushed();
    }
}
