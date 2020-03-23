package zad3;

/**
 *
 * @author Matija
 */
public class Fridge extends RemoteAbs {

    private int temperature;

    public Fridge(String id, boolean isPoweredOn, int temperature, boolean isRemoteSessionActive) {
        super(id, isPoweredOn, isRemoteSessionActive);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

}
