package zad1;

/**
 *
 * @author Matija
 */
public class Prodavac {

    public static void zabiljezi(String zapis) {

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

            //TODO #4 (zadaca): sto ako su predani negativni brojevi?
        } //TODO #2: isprobajte zakomentirana prosljedivanja iznimki
        catch (NullPointerException ex) {
            System.err.println("Nije poslan zapis!");

            // omatanje i prosljedjivanje iznimke
            // sto ako se proslijedi bez omatanja?
            //throw new IllegalArgumentException("Nije poslan zapis",ex);
        } catch (NumberFormatException ex) {
            System.err.println("Zapis ne sadrzi brojeve!");
            //throw new IllegalArgumentException("Zapis ne sadrzi brojeve", ex);

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println("Zapis nema barem 3 elementa");
            //throw new IllegalArgumentException("Zapis nema barem 3 elementa",ex); 

        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
            //throw ex;

        } catch (ArithmeticException ex) {
            System.err.println(ex.getMessage());

        } catch (Exception ex) {
            System.err.println("Neka druga greska u zapisu: " + ex.getMessage());
            //throw new IllegalArgumentException("Neka druga greska u zapisu",ex);
        }

    }

    public static void main(String[] args) {
        Prodavac.zabiljezi("12345.45,4,0.12"); // Jedinicna cijena: 3086.3325
        Prodavac.zabiljezi("a,2,2.3"); // Zapis ne sadrzi brojeve!
        Prodavac.zabiljezi("1,2"); // Zapis nema barem 3 elementa
        Prodavac.zabiljezi(null); // Nije poslan zapis!
        Prodavac.zabiljezi(" 4, 0,1"); // Jedinicna cijena: Infinity
        Prodavac.zabiljezi(" 4, 0,4"); // Jedinicna cijena: NaN
        Prodavac.zabiljezi("44, 3, 100"); // Negativna jedinicna cijena!
        Prodavac.zabiljezi("102,12,3,4,5,6,7,8,9,0"); // Jedinicna cijena: 8.25
        Prodavac.zabiljezi(",,"); // Zapis nema barem 3 elementa
        Prodavac.zabiljezi("-7,2,-10");
    }
}
