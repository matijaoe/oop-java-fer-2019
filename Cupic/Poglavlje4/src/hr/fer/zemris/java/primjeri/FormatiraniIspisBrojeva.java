package hr.fer.zemris.java.primjeri;

import java.text.DecimalFormat;

/**
 *
 * @author Matija
 */
public class FormatiraniIspisBrojeva {

    public static void ispis(double[] polje, String format) {
        DecimalFormat formatter = new DecimalFormat(format);

        for (int i = 0; i < polje.length; i++) {
            System.out.println("(" + i + "): [" + formatter.format(polje[i]) + "]");
        }

    }

    public static void main(String[] args) {
        double[] brojevi = new double[]{
            3.712, 55.813, 55.816, -4.18};

        ispis(brojevi, "000.00");
        System.out.println("-------------------");
        ispis(brojevi, "+000.00;-000.00");

    }
}
