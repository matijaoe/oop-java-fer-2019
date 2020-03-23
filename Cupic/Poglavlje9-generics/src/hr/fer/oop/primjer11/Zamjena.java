package hr.fer.oop.primjer11;

import hr.fer.oop.primjer10.Wrapper;

/**
 *
 * @author Matija
 */
public class Zamjena {

    public static void main(String[] args) {

        Wrapper<Integer> prva = new Wrapper<>(Integer.valueOf(5));
        Wrapper<Integer> druga = new Wrapper<>(8);

        obradi(prva, druga);

        System.out.format("Prva: %d, druga: %d\n",
                prva.getValue(), druga.getValue());

    }

    private static void obradi(Wrapper<Integer> a, Wrapper<Integer> b) {
        if (Math.random() < 0.5) {
            a.setValue(a.getValue() + (int) (10 * Math.random()));
        } else {
            b.setValue(b.getValue() + (int) (10 * Math.random()));
        }
    }
}
