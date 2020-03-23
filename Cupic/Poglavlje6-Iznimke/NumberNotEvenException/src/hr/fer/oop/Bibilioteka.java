package hr.fer.oop;

/**
 *
 * @author Matija
 */
public class Bibilioteka {

    public static int prepolovi(int broj) {

        if ((broj & 1) == 1) {
            throw new NumberNotEvenException("Predan je broj " + broj + ".");
        }
        return broj >> 1;
    }
}
