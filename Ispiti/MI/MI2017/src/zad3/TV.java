package zad3;

/**
 *
 * @author Matija
 */
public class TV extends Device {

    private int screenSize;

    public TV(String id, boolean isPoweredOn, int screenSize) {
        super(id, isPoweredOn);
        this.screenSize = screenSize;
    }
}
