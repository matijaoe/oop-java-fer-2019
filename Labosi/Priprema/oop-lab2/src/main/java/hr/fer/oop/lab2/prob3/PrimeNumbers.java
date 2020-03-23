package hr.fer.oop.lab2.prob3;

public class PrimeNumbers {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.format("You requested calculation of %1$d prime numbers.\n", n);

        for (int i = 2, count = 0; count < n; i++) {
            if (isPrime(i)) {
                System.out.println(String.format("%1$d. %2$d", ++count, i));
            }
        }
    }

    private static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % 2 == 0) {
                return false;
            }
        }
        return true;
    }
}
