package RemoteControl.ApplianceVendor.Light;

public class PhilipsLight {

    public enum State {
        ON,
        OFF
    }

    public enum ColorTone {
        WARM_WHITE,
        COOL_DAYLIGHT,
        AMBER,
        NEON_BLUE
    }

    private State state;
    private int brightnessLevel; // 1 to 100
    private ColorTone colorTone;

    public PhilipsLight() {
        this.state = State.OFF;
        this.brightnessLevel = 75;
        this.colorTone = ColorTone.WARM_WHITE;
    }

    public void turnOn() {
        this.state = State.ON;
        System.out.println("Philips Light: Turned ON at " + brightnessLevel + "% brightness [" + colorTone + "].");
    }

    public void turnOff() {
        this.state = State.OFF;
        System.out.println("Philips Light: Turned OFF.");
    }

    public void on() {
        turnOn();
    }

    public void off() {
        turnOff();
    }

    public void setBrightness(int level) {
        if (level < 0) {
            this.brightnessLevel = 0;
        } else if (level > 100) {
            this.brightnessLevel = 100;
        } else {
            this.brightnessLevel = level;
        }
        System.out.println("Philips Light: Brightness set to " + this.brightnessLevel + "%.");
    }

    public void dim() {
        this.brightnessLevel = Math.max(0, this.brightnessLevel - 10);
        System.out.println("Philips Light: Dimmed to " + this.brightnessLevel + "%.");
    }

    public void brighten() {
        this.brightnessLevel = Math.min(100, this.brightnessLevel + 10);
        System.out.println("Philips Light: Brightened to " + this.brightnessLevel + "%.");
    }

    public void setColorTone(ColorTone tone) {
        this.colorTone = tone;
        System.out.println("Philips Light: Color tone set to " + tone + ".");
    }

    public State getState() {
        return state;
    }

    public int getBrightnessLevel() {
        return brightnessLevel;
    }

    public ColorTone getColorTone() {
        return colorTone;
    }
}
