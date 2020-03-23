package hr.fer.oop.primjer06;

import hr.fer.oop.primjer05.IntWrapper;

public class Zamjena {

    public static void main(String[] args) {
        IntWrapper prva = new IntWrapper(5);
        IntWrapper druga = new IntWrapper(8);

        obradi(prva, druga);

        System.out.format("Prva: %d, druga: %d\n",
                prva.getValue(), druga.getValue());

    }

    private static void obradi(IntWrapper a, IntWrapper b) {
        if (Math.random() < 0.5) {
            a.setValue(a.getValue() + (int) (10 * Math.random()));
        } else {
            b.setValue(b.getValue() + (int) (10 * Math.random()));
        }
    }

}
