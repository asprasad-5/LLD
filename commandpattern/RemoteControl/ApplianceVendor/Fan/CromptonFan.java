package RemoteControl.ApplianceVendor.Fan;

public class CromptonFan {
    
    public enum Speed {
        HIGH,
        MEDIUM,
        LOW
    }

    public enum State {
        OFF,
        ON
    }

    private Speed fanSpeed;
    private State fanState;

    public CromptonFan() {
        this.fanSpeed = Speed.LOW;
        this.fanState = State.OFF;
    }

    public void switchOn() {
        this.fanState = State.ON;
        System.out.println("Crompton Fan: Switched ON (Speed: " + fanSpeed + ").");
    }

    public void switchOFF() {
        this.fanState = State.OFF;
        System.out.println("Crompton Fan: Switched OFF.");
    }

    public void increaseSpeed() {
        if (fanSpeed == null) {
            fanSpeed = Speed.LOW;
            return;
        }
        switch (fanSpeed) {
            case LOW:
                this.fanSpeed = Speed.MEDIUM;
                break;
            case MEDIUM:
                this.fanSpeed = Speed.HIGH;
                break;
            default:
                break;
        }
        System.out.println("Crompton Fan: Speed increased to " + this.fanSpeed + ".");
    }

    public void decreaseSpeed() {
        if (fanSpeed == null) {
            fanSpeed = Speed.LOW;
            return;
        }
        switch (fanSpeed) {
            case HIGH:
                this.fanSpeed = Speed.MEDIUM;
                break;
            case MEDIUM:
                this.fanSpeed = Speed.LOW;
                break;
            default:
                break;
        }
        System.out.println("Crompton Fan: Speed decreased to " + this.fanSpeed + ".");
    }

    public Speed getFanSpeed() {
        return fanSpeed;
    }

    public State getFanState() {
        return fanState;
    }
}
