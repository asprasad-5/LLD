package RemoteControl.ApplianceVendor.Fan;

public class HavellsFan {

    public enum Mode {
        NORMAL,
        BREEZE,
        SLEEP
    }

    private boolean running;
    private int speed; // 1 to 5
    private Mode mode;
    private boolean reverseRotation;

    public HavellsFan() {
        this.running = false;
        this.speed = 1;
        this.mode = Mode.NORMAL;
        this.reverseRotation = false;
    }

    public void turnOn() {
        this.running = true;
        System.out.println("Havells Fan: Turned ON at speed " + speed + " [" + mode + " mode].");
    }

    public void turnOff() {
        this.running = false;
        System.out.println("Havells Fan: Turned OFF.");
    }

    public void setSpeed(int speed) {
        if (speed < 1) {
            this.speed = 1;
        } else if (speed > 5) {
            this.speed = 5;
        } else {
            this.speed = speed;
        }
        System.out.println("Havells Fan: Speed set to " + this.speed + ".");
    }

    public void setMode(Mode mode) {
        this.mode = mode;
        System.out.println("Havells Fan: Mode changed to " + mode + ".");
    }

    public void toggleReverse() {
        this.reverseRotation = !this.reverseRotation;
        System.out.println("Havells Fan: Reverse rotation " + (reverseRotation ? "ENABLED (Winter mode)" : "DISABLED (Summer mode)") + ".");
    }

    public boolean isRunning() {
        return running;
    }

    public int getSpeed() {
        return speed;
    }

    public Mode getMode() {
        return mode;
    }

    public boolean isReverseRotation() {
        return reverseRotation;
    }
}
