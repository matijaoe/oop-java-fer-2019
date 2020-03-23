package hr.fer.zemris.java.primjeri;

/**
 * Ilustracija funkcija s varijabilnim brojem argumenata.
 *
 * @author marcupic
 */
public class Matematika {

    /**
     * Metoda prima 0 ili više cijelih brojeva i vraća njihovu sumu.
     *
     * @param brojevi 0 ili više cijelih brojeva
     * @return suma
     */
    public static int suma(int... brojevi) {
        int s = 0;

        for (int broj : brojevi) {
            s += broj;
        }
        return s;
    }

    /**
     *   * Metoda predani niz brojeva pretvara u string. String   * započinje
     * lijevim simbolom, slijede predani brojevi   * koji su razdvojeni zarezima
     * i završava desnim simbolom.   *  
     *
     * @param lijeviSimbol simbol s kojim mora započeti string  
     * @param desniSimbol simbol s kojim mora završiti string Primjer 5: metode
     * s varijabilnim brojem argumenata
     *
     *  
     * @param brojevi niz brojeva koje treba pretvoriti u string  
     * @return string koji predstavlja predani niz brojeva  
     */
    public static String kaoTekst(char lijeviSimbol, char desniSimbol, double... brojevi) {

        StringBuilder sb = new StringBuilder();
        sb.append(lijeviSimbol);

        boolean prvi = true;

        for (double broj : brojevi) {
            if (prvi) {
                prvi = false;
            } else {
                sb.append(", ");
            }
            sb.append(broj);
        }
        sb.append(desniSimbol);

        return sb.toString(); // !!!
    }

    /**
     *   * Metoda predani niz brojeva pretvara u string. String   * započinje
     * znakom '{', slijede predani brojevi koji su   * razdvojeni zarezima i
     * završava znakom '}'.   *  
     *
     * @param brojevi niz brojeva koje treba pretvoriti u string  
     * @return string koji predstavlja predani niz brojeva  
     */
    public static String kaoTekst(double... brojevi) {
        return kaoTekst('{', '}', brojevi);
    }
}
