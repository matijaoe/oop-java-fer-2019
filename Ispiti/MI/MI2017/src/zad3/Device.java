package zad3;

/**
 *
 * @author Matija
 */
public abstract class Device {

    private final String id;
    private boolean isPoweredOn;

    public Device(String id, boolean isPoweredOn) {
        this.id = id;
        this.isPoweredOn = isPoweredOn;
    }

    public String getId() {
        return id;
    }

    public boolean isIsPoweredOn() {
        return isPoweredOn;
    }

    public void setIsPoweredOn(boolean isPoweredOn) {
        this.isPoweredOn = isPoweredOn;
    }

    public void switchPower() {
        this.isPoweredOn = !isPoweredOn;
    }

}
