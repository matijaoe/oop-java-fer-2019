package zad3;

/**
 *
 * @author Matija
 */
public class Bulb extends RemoteAbs {

    private Color color;

    public Bulb(String id, boolean isPoweredOn, Color color, boolean isRemoteSessionActive) {
        super(id, isPoweredOn, isRemoteSessionActive);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
