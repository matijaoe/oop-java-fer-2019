package vjezba.muzicari;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// za svakog muzicara ispisuje njegovo ime te listu rola za
// koju imaju najvecu vjestinu
public class Util2 {

    public static Map<String, Set<String>> bestQualifications(
            Map<String, Map<String, Integer>> musicians) {

        Map<String, Set<String>> bestQuals = new HashMap<>();


        for (Map.Entry<String, Map<String, Integer>> entry : musicians.entrySet()) {
            String name = entry.getKey();

            int maxSkill = 0;
            int countMax = 0;

            // Inicijalizira set tako da bude potpuno nova lista za svaki entry
            // inace ce se za svaki entry nakraju stavit isti set kao value jer se auto-updjeta kroz for petlju
            Set<String> bestRoles = new HashSet<>();

            Map<String, Integer> map = entry.getValue();

            for (Map.Entry<String, Integer> e : map.entrySet()) {
                String role = e.getKey();
                int skill = e.getValue();

                if (skill >= maxSkill) {
                    if (skill > maxSkill) {
                        maxSkill = skill;
                        bestRoles.clear();
                    }
                    bestRoles.add(role);
                }
            }
            bestQuals.put(name, bestRoles);


        }

        return bestQuals;
    }
}
