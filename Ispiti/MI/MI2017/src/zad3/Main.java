package zad3;

import java.util.Set;

/**
 *
 * @author Matija
 */
public class Main {

    public static void main(String[] args) {

        Set<Device> devices = DBLoader.loadDevices();

        for (Device device : devices) {
            if (!device.isIsPoweredOn()) {
                device.switchPower();
            }

            if (device instanceof RemoteAbs) {
                RemoteAbs remoteDevice = (RemoteAbs) device;
                remoteDevice.startRemoteSession();

                if (device instanceof Fridge) {
                    Fridge fridge = (Fridge) device;
                    fridge.setTemperature(5);
                }

                if (device instanceof Bulb) {
                    Bulb bulb = (Bulb) device;
                    bulb.setColor(Color.RED);
                }

                remoteDevice.endRemoteSession();
            }
        }
    }

}
