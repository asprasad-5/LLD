package RemoteControl.ApplianceVendor.Light;

public class SyskaLight {

    private boolean powerOn;
    private int intensity; // 1 to 10
    private boolean nightMode;

    public SyskaLight() {
        this.powerOn = false;
        this.intensity = 5;
        this.nightMode = false;
    }

    public void on() {
        this.powerOn = true;
        System.out.println("Syska Light: Light powered ON (Intensity: " + intensity + "/10).");
    }

    public void off() {
        this.powerOn = false;
        System.out.println("Syska Light: Light powered OFF.");
    }

    public void setIntensity(int intensity) {
        this.intensity = Math.max(1, Math.min(10, intensity));
        System.out.println("Syska Light: Intensity set to " + this.intensity + "/10.");
    }

    public void activateNightMode() {
        this.nightMode = true;
        this.intensity = 1;
        System.out.println("Syska Light: Night mode activated (Dim warm glow).");
    }

    public void deactivateNightMode() {
        this.nightMode = false;
        this.intensity = 5;
        System.out.println("Syska Light: Night mode deactivated.");
    }

    public boolean isPowerOn() {
        return powerOn;
    }

    public int getIntensity() {
        return intensity;
    }

    public boolean isNightMode() {
        return nightMode;
    }
}
