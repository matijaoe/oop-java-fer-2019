package hr.fer.oop.lab2.vjezba;

import java.util.Scanner;

/**
 * Napisati program koji ce ovisno o dvije granice unesene generirati random
 * brojeve izmedju tih granica. Korisnik ce zamisliti broj izmedju granica koje
 * je unio. Program mu ispisuje brojeve izmedju granica a na svaki ispisani broj
 * ce korisnik unijeti v da je veci m da je manji ili ! da je pogodio program.
 * Nakon pogotka gotov je rad programa.
 *
 * @author Matija
 */
public class NumberGuesser {

    private static int donjaGranica, gornjaGranica;
    private static String input = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Unesite donju granicu > ");
        donjaGranica = sc.nextInt();
        System.out.println("Unesite gornju granicu > ");
        gornjaGranica = sc.nextInt();

        if (!isValid()) {
            System.err.println("Unjeli ste neispravne granice. Program se prekida.");
            System.exit(1);
        }

        System.out.println("Pokusat cu pogoditi tvoj broj na temelju unesenih granica");
        System.out.format("\nUnesi\t 'm' ako je tvoj broj manji,\n\t 'v' ako je "
                + "veci,\n\t '!' ako sam ga pogodio.\n");

        while (!input.equals("!")) {
            int randomNum = getRandomNumber();
            System.out.format("Je li %d tvoj broj?\n", randomNum);
            input = sc.next();
            if (input.equals("m")) {
                gornjaGranica = randomNum - 1;
            } else if (input.equals("v")) {
                donjaGranica = randomNum + 1;
            }
        }
        System.out.println("Hvala na koristenju!");
    }

    public static int getRandomNumber() {
        return (int) (Math.random() * (gornjaGranica - donjaGranica + 1)) + donjaGranica;
    }

    public static boolean isValid() {
        return donjaGranica < gornjaGranica;
    }
}
