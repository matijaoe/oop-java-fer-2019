package zad3;

import java.awt.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random r = new Random();
        HotDogKiosk kiosk = new HotDogKiosk();

        new Thread(new Robot(kiosk)).start();

        int id = 0;

        while (true) {
            Thread thread = new Thread(new Gradjanin(++id, kiosk));
            thread.start();
            Thread.sleep(r.nextInt(1000));
        }
    }
}