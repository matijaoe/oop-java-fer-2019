package hr.fer.oop.lab2.vjezba;

/**
 * Napisite program SumEvenNumbers (smjestite ga u paket ...). Program prihvaca
 * 2 argumenta preko naredbenog retka: dva 4-znam br (!) te ispisuje sumu svih
 * parnih znamenaka tih brojeva. Primjer: Input: 3478 5441 Output: 20
 *
 * /**
 *
 * @author Matija
 */
public class SumEvenNumbers {

    public static int sumOfEvens;

    public static void main(String[] args) {

        if (args.length != 2) {
            System.err.println("Please enter two 4-digit numbers.");
            System.exit(1);
        }

        for (String arg : args) {
            sumOfEvens = calculateSum(arg, sumOfEvens);
        }

        System.out.println("Sum of even digits from given numbers is "
                + sumOfEvens);

    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static int calculateSum(String arg, int sum) {
        for (char ch : arg.toCharArray()) {
            int n = Character.getNumericValue(ch);
            if (isEven(n)) {
                sum += n;
            }

        }
        return sum;
    }

}
