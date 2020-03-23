package fer.oop.zadaci;

/**
 *
 * @author Matija
 */
public class Zad5 {

    public static void main(String[] args) {

    }

    public static int frequency(int[] polje, int broj) {
        int counter = 0;

        for (int n : polje) {
            if (n == broj) {
                counter++;
            }
        }

        return counter;
    }
}
