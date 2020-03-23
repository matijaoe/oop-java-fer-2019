package fer.oop.zadaci;

/**
 *
 * @author Matija
 */
public class Zad2 {

    public static void main(String[] args) {
        int[] polje = new int[]{10, 20, 30, 10, 20};
        for (int i = 0; i < 2; i++) {
            System.out.println(duplicates(polje)[i]);
        }

    }

    public static int[] duplicates(int[] polje) {
        int[] rezultat = new int[2];
        int mostTimes = polje[0];
        int counterMax = 0;
        int counter = 0;

        for (int n : polje) {
            counter = 0;
            for (int i = 0; i < polje.length; i++) {
                if (polje[i] == n) {
                    counter++;
                }
                if (counter > counterMax) {
                    counterMax = counter;
                    mostTimes = polje[i];
                }
            }
        }
        rezultat[0] = mostTimes;
        rezultat[1] = counterMax;

        return rezultat;
    }
}
