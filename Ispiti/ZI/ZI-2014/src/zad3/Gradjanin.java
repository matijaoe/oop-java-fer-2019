package zad3;

import java.util.Random;

public class Gradjanin implements Runnable {
    private int id;
    private HotDogKiosk kiosk;

    public Gradjanin(int id, HotDogKiosk kiosk) {
        this.id = id;
        this.kiosk = kiosk;
    }

    @Override
    public void run() {
        Random random = new Random();
        switch (random.nextInt(5)) {
            case 0:
                gluhaSoba();
                break;
            case 1:
                bestezinskaSoba();
                break;
            default:
                kupiHotDog();
                break;
        }
    }

    private void gluhaSoba() {
        System.out.format("%d ušao u gluhu sobu\n", id);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.format("%d izašao iz gluhe sobu\n", id);
    }

    private void bestezinskaSoba() {
        System.out.format("%d lebdi\n", id);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.format("%d prestao lebdjeti\n", id);
    }

    private String kupiHotDog() {
        System.out.format("Građanin %d stao u red za hotdog\n", id);
        int brojRacuna = kiosk.prodajKupcu();
        System.out.format("%d dobio hotdog i račun br %d\n",
                id, brojRacuna);
        return null;
    }
}