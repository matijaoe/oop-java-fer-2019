package zadaci;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Matija
 */
public class ispisiObrnuto {

    public static void main(String[] args) {
        String[] polje = new String[]{"ja", "sam", "jebeni", "kreten", "ali",
            "kreten", "ne", "znači", "da", "jebeni", "znači", "ja", "glup"
        };

//        ispisiObrnuto1(polje);
//        System.out.println();
//        ispisiObrnuto2(polje);
//        System.out.println();
//        ispisiObrnuto3(polje);
//        System.out.println();
        ispisiObrnuto4(polje);
        System.out.println();
        ispisiObrnuto5(polje);
    }

    private static void ispisiObrnuto1(String[] polje) {

        for (int i = polje.length - 1; i >= 0; i--) {
            String kandidat = polje[i];
            boolean kasnijeIspisati = false;

            for (int j = i - 1; j >= 0; j--) {
                if (polje[j].equals(kandidat)) {
                    kasnijeIspisati = true;
                    break;
                }
            }
            if (kasnijeIspisati) {
                continue;
            }
            System.out.println(kandidat);
        }
    }

    private static void ispisiObrnuto2(String[] polje) {

        List<String> zaIspis = new ArrayList<>();

        for (String kandidat : polje) {
            if (!zaIspis.contains(kandidat)) {
                zaIspis.add(kandidat);
            }
        }

        Collections.reverse(zaIspis);

        for (String elem : zaIspis) {
            System.out.println(elem);
        }
    }

    private static void ispisiObrnuto3(String[] polje) {

        Set<String> razliciti = new HashSet<String>();
        List<String> zaIspis = new ArrayList<>();

        for (String kandidat : polje) {
            if (!razliciti.contains(kandidat)) {
                razliciti.add(kandidat);
                zaIspis.add(kandidat);
            }
        }

        Collections.reverse(zaIspis);

        for (String elem : zaIspis) {
            System.out.println(elem);
        }
    }

    private static void ispisiObrnuto4(String[] polje) {
        Set<String> razliciti = new HashSet<String>();
        List<String> zaIspis = new ArrayList<>();

        for (String kandidat : polje) {
            // ako se uspio dodat - vraca true. Ako ne (jer je duplikat) - vraca false
            if (razliciti.add(kandidat)) {
                zaIspis.add(kandidat);
            }
        }

        Collections.reverse(zaIspis);

        for (String elem : zaIspis) {
            System.out.println(elem);
        }

    }

    private static void ispisiObrnuto5(String[] polje) {

        Set<String> razliciti = new LinkedHashSet<>();
        // linked jer pamti poredak kojim smo unosili

        for (String kandidat : polje) {
            razliciti.add(kandidat);
        }

        // pretvaramo u listu jer samo nju mozemo reversati
        List<String> zaIspis = new ArrayList<>(razliciti);
        Collections.reverse(zaIspis);

        for (String elem : zaIspis) {
            System.out.println(elem);
        }
    }
}
