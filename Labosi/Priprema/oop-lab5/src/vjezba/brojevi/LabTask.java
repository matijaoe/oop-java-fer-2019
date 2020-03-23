package vjezba.brojevi;

import java.util.*;

public class LabTask {

    public static Set<String> theMostKnown(Map<String, Set<String>> map) {

        List<String> allNames = new ArrayList<>();
        Set<String> mostKnown = new TreeSet<>();


        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            allNames.addAll(entry.getValue());
        }

        if (allNames.isEmpty()) {
            return mostKnown;
        }

        int max = 0;

        for (String name : allNames) {
            int occurrences = Collections.frequency(allNames, name);
            if (occurrences >= max ) {
                max = occurrences;
                mostKnown.add(name);
            }
        }

        return mostKnown;
    }
}

