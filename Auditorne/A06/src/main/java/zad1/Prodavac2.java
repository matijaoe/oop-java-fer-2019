package zad1;

/**
 *
 * @author Matija
 */
public class Prodavac2 {

    public static void zabiljezi(String zapis) {

        try {
            try {
                String[] elementi = zapis.split(",");
                float[] podatci = new float[3];

                //arbitrarno: ignoriramo visak, gledamo samo prva 3
                for (int i = 0; i < 3; i++) {
                    podatci[i] = Float.parseFloat(elementi[i]);
                    if (podatci[i] < 0) {
                        throw new IllegalArgumentException("Negativna vrijednost!");
                    }
                }

                float jedinicnaCijena = (podatci[0] - podatci[2]) / podatci[1];

                if (podatci[1] == 0) {
                    throw new ArithmeticException("Dijeljenje s 0!");
                }
                if (jedinicnaCijena < 0) {
                    throw new IllegalArgumentException("Negativna jedinicna cijena!");
                }

                System.out.println("Jedinicna cijena: " + jedinicnaCijena);

            } catch (NullPointerException ex) {
                throw new IllegalArgumentException("Nije poslan zapis", ex);
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("Zapis ne sadrzi brojeve", ex);

            } catch (ArrayIndexOutOfBoundsException ex) {
                throw new IllegalArgumentException("Zapis nema barem 3 elementa", ex);

            } catch (IllegalArgumentException ex) {
                throw ex;

            } catch (ArithmeticException ex) {
                throw new IllegalArgumentException("Brojevi manji od nule!");

            } catch (Exception ex) {
                throw new IllegalArgumentException("Neka druga greska u zapisu", ex);
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void main(String[] args) {
        Prodavac2.zabiljezi("12345.45,4,0.12"); // Jedinicna cijena: 3086.3325
        Prodavac2.zabiljezi("a,2,2.3"); // Zapis ne sadrzi brojeve!
        Prodavac2.zabiljezi("1,2"); // Zapis nema barem 3 elementa
        Prodavac2.zabiljezi(null); // Nije poslan zapis!
        Prodavac2.zabiljezi(" 4, 0,1"); // Jedinicna cijena: Infinity
        Prodavac2.zabiljezi(" 4, 0,4"); // Jedinicna cijena: NaN
        Prodavac2.zabiljezi("44, 3, 100"); // Negativna jedinicna cijena!
        Prodavac2.zabiljezi("102,12,3,4,5,6,7,8,9,0"); // Jedinicna cijena: 8.25
        Prodavac2.zabiljezi(",,"); // Zapis nema barem 3 elementa
        Prodavac2.zabiljezi("-7,2,-10");
    }
}
