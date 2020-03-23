package fer.oop.zadaci;

/**
 *
 * @author Matija
 */
public class Zad1 {

    public static void main(String[] args) {
        int[] arr = new int[5];
        increasing(arr);
        for (int n : arr) {
            System.out.println(n);
        }
    }

    static void increasing(int[] arr) {
        int dg = -2;
        int gg = 2;

        for (int i = 0; i < arr.length; i++) {
            int randomNum = (int) (Math.random() * (gg + 1) + dg);
            arr[i] = randomNum;
            if (randomNum != 0) {
                dg -= Math.abs(randomNum);
                gg += Math.abs(randomNum);
            }
        }
    }
}
