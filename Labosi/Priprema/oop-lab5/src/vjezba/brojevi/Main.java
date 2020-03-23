package vjezba.brojevi;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        String[] names = new String[] {
                "Ivana", "Matija", "Tea", "Marin", "Ivo",
                "Dora", "Lovro"
        };

        Map<String, Set<String>> map = new HashMap<>();
        map.put("Ivana", new HashSet<>(Arrays.asList("Matija", "Tea")));
        map.put("Marin", new HashSet<>(Arrays.asList("Ivana", "Matija", "Dora", "Ivo", "Tea")));
        map.put("Matija", new HashSet<>(Arrays.asList("Ivana")));
        map.put("Tea", new HashSet<>(Arrays.asList("Dora", "Ivo", "Matija", "Ivana")));
        map.put("Lovro", new HashSet<>(Arrays.asList("Ivana", "Matija", "Tea")));

        Set<String> mostKnownSet = LabTask.theMostKnown(map);
        System.out.println(mostKnownSet);

        Map<String, Set<String>> map2 = new HashMap<>();
        map2.put("Ivana", new HashSet<>());
        map2.put("Marin", new HashSet<>());
        map2.put("Matija", new HashSet<>());
        Set<String> mostKnownSet2 = LabTask.theMostKnown(map2);
        System.out.println(mostKnownSet2);


    }
}
