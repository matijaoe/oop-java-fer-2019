package fer.oop.zadaci;

import java.util.Scanner;

/**
 *
 * @author Matija
 */
public class Main {

    static int suma = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = "";

        while (true) {
            input = sc.nextLine();

            if (!input.equals("KRAJ")) {
                suma += Integer.parseInt(input);
            } else {
                System.out.println(suma);
                break;
            }
        }
    }
}
