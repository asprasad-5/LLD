package RemoteControl.ApplianceVendor.Gate;

public class GodrejGate {

    public enum Status {
        OPEN,
        CLOSED,
        STOPPED,
        MOVING
    }

    private Status status;
    private boolean locked;

    public GodrejGate() {
        this.status = Status.CLOSED;
        this.locked = true;
    }

    public void openGate() {
        if (locked) {
            System.out.println("Godrej Gate: Cannot open, gate is LOCKED. Unlock first.");
            return;
        }
        this.status = Status.OPEN;
        System.out.println("Godrej Gate: Gate is now OPEN.");
    }

    public void closeGate() {
        this.status = Status.CLOSED;
        System.out.println("Godrej Gate: Gate is now CLOSED.");
    }

    public void stopGate() {
        this.status = Status.STOPPED;
        System.out.println("Godrej Gate: Gate movement STOPPED.");
    }

    public void lock() {
        this.locked = true;
        System.out.println("Godrej Gate: Security lock ENGAGED.");
    }

    public void unlock() {
        this.locked = false;
        System.out.println("Godrej Gate: Security lock DISENGAGED.");
    }

    public Status getStatus() {
        return status;
    }

    public boolean isLocked() {
        return locked;
    }
}
