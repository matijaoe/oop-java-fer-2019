package hr.fer.zemris.java.primjeri;

/**
 *
 * @author Matija
 */
public class SumaReda {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Program mora imati jedan argument!");
            System.exit(1);
        }
        double broj = Double.parseDouble(args[0]);

        System.out.println("Računam sumu...");

        double suma = racunajSumu(broj);

        System.out.println("f(" + broj + ")=" + suma);
    }

    private static double racunajSumu(double broj) {
        double suma = 0.0;
        double potencija = 1.0;
        double faktorijela = 1.0;

        suma += 1.0;

        for (int i = 0; i < 10; i++) {
            potencija = potencija * broj;
            faktorijela = faktorijela * i;
            suma += potencija / faktorijela;
        }

        return suma;
    }
}
