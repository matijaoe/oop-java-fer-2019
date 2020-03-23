package hr.fer.oop;

import java.awt.BorderLayout;

/**
 *
 * @author Matija
 */
public class Main {

    public static void main(String[] args) {

        try {
            System.out.println("Rez = " + Bibilioteka.prepolovi(Integer.parseInt(args[0])));
        } catch (NumberNotEvenException ex) {
            System.out.println("Funkcija 'prepolovi' nije primjenjiva na predani broj.");
        }
    }
}
