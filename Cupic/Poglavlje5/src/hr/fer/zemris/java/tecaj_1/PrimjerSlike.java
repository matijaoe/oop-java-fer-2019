package hr.fer.zemris.java.tecaj_1;

/**
 *
 * @author Matija
 */
public class PrimjerSlike {

    public static void main(String[] args) {
        Slika slika = new Slika(5, 3);

        slika.upaliElement(0, 0);
        slika.upaliElement(0, 1);
        slika.upaliElement(0, 2);
        slika.upaliElement(1, 1);
        slika.upaliElement(2, 2);
        slika.upaliElement(3, 2);
        slika.upaliElement(4, 2);

        System.out.print(slika.toString());

    }
}
