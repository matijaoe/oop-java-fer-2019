package hr.fer.oop.lab2.vjezba;

import java.util.Scanner;
import java.lang.Math;

public class KamenSkare {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Treba unijeti jedan argument.");
            return;
        }

        int N = Integer.parseInt(args[0]);
        int broj_pobjeda_racunalo = 0;
        int broj_pobjeda_korisnik = 0;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Upisi kamen (O), skare (8<) ili papir ([]): ");

            String odabir_korisnika = new String();
            odabir_korisnika = sc.next();
            odabir_korisnika = odabir_korisnika.trim();

            String odabir_racunala = new String();
            int broj_izbora = racunalo_rand();

            if (broj_izbora == 1) {
                odabir_racunala = "8<";
            }
            if (broj_izbora == 2) {
                odabir_racunala = "[]";
            }
            if (broj_izbora == 3) {
                odabir_racunala = "O";
            }

            if (odabir_racunala.equals(odabir_korisnika)) {
                System.out.println("Nerijeseno!");
            }

            String skare = "8<";
            String kamen = "O";
            String papir = "[]";

            if (odabir_racunala.equals(skare) && odabir_korisnika.equals(papir)
                    || odabir_racunala.equals(papir) && odabir_korisnika.equals(kamen)
                    || odabir_racunala.equals(kamen) && odabir_korisnika.equals(skare)) {
                System.out.println("Racunalo pobijedilo! ");
                broj_pobjeda_racunalo++;
            }

            if (odabir_racunala.equals(papir) && odabir_korisnika.equals(skare)
                    || odabir_racunala.equals(kamen) && odabir_korisnika.equals(papir)
                    || odabir_racunala.equals(skare) && odabir_korisnika.equals(kamen)) {
                System.out.println("Korisnik pobijedio! ");
                broj_pobjeda_korisnik++;
            }

            if (broj_pobjeda_korisnik == N) {
                System.out.println("\nUkupni pobjednik: korisnik!");
                break;
            }
            if (broj_pobjeda_racunalo == N) {
                System.out.println("\nUkupni pobjednik: racunalo!");
                break;
            }
        }

        sc.close();

    }

    private static int racunalo_rand() {
        int indeks;
        indeks = (int) (Math.random() * 10) % 3 + 1;
        return indeks;
    }

}
