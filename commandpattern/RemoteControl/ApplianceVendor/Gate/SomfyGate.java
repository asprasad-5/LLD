package RemoteControl.ApplianceVendor.Gate;

public class SomfyGate {

    private int openingPercentage; // 0 (closed) to 100 (fully open)
    private boolean obstructionDetected;

    public SomfyGate() {
        this.openingPercentage = 0;
        this.obstructionDetected = false;
    }

    public void slideOpen() {
        if (obstructionDetected) {
            System.out.println("Somfy Gate: Warning! Obstruction detected in safety sensor. Cannot open.");
            return;
        }
        this.openingPercentage = 100;
        System.out.println("Somfy Gate: Slid fully OPEN (100%).");
    }

    public void slideClose() {
        if (obstructionDetected) {
            System.out.println("Somfy Gate: Safety obstruction triggered! Gate stopped closing.");
            return;
        }
        this.openingPercentage = 0;
        System.out.println("Somfy Gate: Slid fully CLOSED (0%).");
    }

    public void partialOpen(int percentage) {
        this.openingPercentage = Math.max(0, Math.min(100, percentage));
        System.out.println("Somfy Gate: Positioned to " + this.openingPercentage + "% opening (Pedestrian mode).");
    }

    public void emergencyStop() {
        System.out.println("Somfy Gate: EMERGENCY STOP activated at " + openingPercentage + "%.");
    }

    public void setObstructionDetected(boolean detected) {
        this.obstructionDetected = detected;
    }

    public int getOpeningPercentage() {
        return openingPercentage;
    }

    public boolean isClosed() {
        return openingPercentage == 0;
    }

    public boolean isOpen() {
        return openingPercentage == 100;
    }
}
