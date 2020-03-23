package zad3;

public class Robot implements Runnable {
    private HotDogKiosk kiosk;

    public Robot(HotDogKiosk kiosk) {
        this.kiosk = kiosk;
    }

    @Override
    public void run() {
        while (true) {
            kiosk.pripremi();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}