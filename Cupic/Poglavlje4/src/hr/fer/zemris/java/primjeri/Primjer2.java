package hr.fer.zemris.java.primjeri;

/**
 * statičko ukljucivanje
 */
import static hr.fer.zemris.java.primjeri.Matematika.*; // ukljucje sve metode navedene klase
//import static hr.fer.zemris.java.primjeri.Matematika.kaoTekst;

public class Primjer2 {

    public static void main(String[] args) {
        System.out.println(kaoTekst('[', ']', 1, 4, 8.2, 13.1));
        System.out.println(kaoTekst('[', ']', 3.3));
        System.out.println(kaoTekst('[', ']'));

        System.out.println(kaoTekst(1, 4, 8.2, 13.1));

        System.out.println("Suma je: " + suma(2, 4, 12));
    }
}
