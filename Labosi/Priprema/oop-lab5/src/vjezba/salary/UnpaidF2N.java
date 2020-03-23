package vjezba.salary;

import java.util.*;

/*
public class UnpaidF2N {

    public static Map<Integer, Set<String>> underpayed(Map<String, Map<Integer, List<Integer>>> salaries) {



        Map<Integer, Integer> avg_placa_po_godini = new HashMap<>();
        for (Integer godina : salaries.values().keySet()) {

            int broj_ljudi = 0;
            int total_placa = 0;
            for (Map.Entry<String, Map<Integer, List<Integer>> osoba : salaries.entrySet()) {

                int placa = (int) (osoba.getValue().get(godina).stream().mapToInt(i -> i.intValue()).sum() / 12);

                broj_ljudi++;

                total_placa += placa;

            }

            int prosjek = total_placa / broj_ljudi;

            avg_placa_po_godini.put(godina, prosjek);
        }

        Map<Integer, Set<String>> slabiradnici_po_godini = new HashMap<>();

        for (Map.Entry<Integer, Integer> god : avg_placa_po_godini.entrySet()) {


            Set<String> radnici = new HashSet<>();
            for (Map.Entry<String, Map<Integer, List<Integer>> osoba : salaries.entrySet()) {

                int placa = (int) (osoba.getValue().get(godina).stream().mapToInt(i -> i.intValue()).sum() / 12);

                if (placa < 0.7 * god.getValue()) {
                    radnici.add(osoba.getKey());

                }


            }

            slabiradnici_po_godini.put(god.getKey(), radnici);
        }

        return slabiradnici_po_godini;

    }
}
*/
