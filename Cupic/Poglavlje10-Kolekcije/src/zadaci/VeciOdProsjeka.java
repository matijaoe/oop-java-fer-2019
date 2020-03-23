package zadaci;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;

/**
 *
 * @author Matija
 */
public class VeciOdProsjeka {

    public static void main(String[] args) {

        List<Double> brojevi = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNextDouble()) {
                brojevi.add(scanner.nextDouble());
            } else {
                String uneseno = scanner.next();
                if (uneseno.equals("quit")) {
                    break;
                }
                System.out.println("Nepoznat unos!");
            }
        }
        scanner.close();

        OptionalDouble avgOpt = prosjek(brojevi);
        if (!avgOpt.isPresent()) {
            System.out.println("Niste usnijeli niti jedan broj!");
            return;
        }

        Double limit = avgOpt.getAsDouble() * 1.2;

        List<Double> zaIspis = new ArrayList<>();
        for (Double d : brojevi) {
            if (d >= limit) {
                zaIspis.add(d);
            }
        }

//        zaIspis.sort(Collections.reverseOrder());
//        System.out.println(zaIspis);
        zaIspis.sort(Collections.reverseOrder(Double::compareTo));
        zaIspis.forEach(d -> System.out.println(d));

    }

    private static OptionalDouble prosjek(List<Double> brojevi) {
        if (brojevi.isEmpty()) {
            return OptionalDouble.empty();
        }

        double suma = 0;
        for (Double d : brojevi) {
            suma += d;
        }

        return OptionalDouble.of(suma / brojevi.size());
    }

}
