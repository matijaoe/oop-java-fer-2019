package zad1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Matija
 */
public class Main {

    public static void main(String[] args) {

        Set<Integer> numbers = new TreeSet<>();
        boolean foundEx = false;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                if (foundEx) {
                    scanner.next();
                    foundEx = false;
                }
                int n = scanner.nextInt();
                if (n <= 0) {
                    break;
                }
                numbers.add(n);

            } catch (Exception ex) {
                System.err.println(ex);
                foundEx = true;
            }
        }

        // Traženi ispis bez duplikata, sortirano:
        for (Integer broj : numbers) {
            System.out.println(broj);
        }

        // Demonstracija najmanjiProst:
        try {
            int prim = najmanjiProst(numbers);
            System.out.println("Najmanji prim broj je: " + prim);
        } catch (NoPrimeNumberException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static int najmanjiProst(Set<Integer> numbers) {
        for (Integer broj : numbers) {
            if (isPrime(broj)) {
                return broj;
            }
        }
        throw new NoPrimeNumberException("U kolekciji nema prim brojeva.");
    }

    private static boolean isPrime(int broj) {
        if (broj < 2) {
            return false;
        }

        // Zaokružimo zbog numeričkih pogrešaka...
        int granica = (int) (Math.sqrt(broj) + 0.5);
        for (int test = 2; test <= granica; test++) {
            if (broj % test == 0) {
                return false;
            }
        }
        return true;
    }
}

class NoPrimeNumberException extends RuntimeException {

    public NoPrimeNumberException(String message) {
        super(message);
    }
}
