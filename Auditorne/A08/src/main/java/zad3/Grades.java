package zad3;

import java.util.HashMap;
import java.util.Map;

/**
 * Napisati klasu koja će, koristeći mapu, pohraniti ocjene studenata na nekom predmetu.
 * a) Za svakog studenta pohraniti samo jednu ocjenu. Izračunati i ispisati prosjek ocjena na
 * predmetu.
 * b) Za svakog studenta pohraniti listu ocjena, prilikom ispisa izračunati i ispisati i ukupni
 * prosjek ocjena za svakog studenta.
 * c) Za svakog studenta spremiti popis predmeta koje je položio te ocjenu iz svakog predmeta.
 * Napisati metodu koja će izračunati prosjek ocjena za zadani predmet.
 */

// Mapa sadrži ime studenta i njegovu ocjenu iz nekog predmeta
public class Grades {

    private Map<String, Integer> gradesMap;

    public Grades() {
        gradesMap = new HashMap<>();
    }

    // Ako se ponovno unese ocjena za već postojećeg studenta, stara ocjena će nestati!
    public void add(String name, Integer grade) {
        gradesMap.put(name, grade);
    }

    public void print() {
        for (Map.Entry<String, Integer> entry : gradesMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
