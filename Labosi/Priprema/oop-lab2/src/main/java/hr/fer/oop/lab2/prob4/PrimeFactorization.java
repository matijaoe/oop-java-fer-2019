package hr.fer.oop.lab2.prob4;

public class PrimeFactorization {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        System.out.println("You requested decomposition of number" + n
                + "into prime factors. Here they are:");

        for (int i = 2, count = 0; n > 1; i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                    System.out.println(String.format("%1$d. %2$d", ++count, i));
                }
            }
        }

    }
}
