package vjezba.muzicari;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


// ispisuje sve koji imaju odredenu rolu
class Util {

    public static List<String> fullfillTheRole(
            Map<String, Map<String, Integer>> musicians,
            java.util.function.Predicate<String> theRole) {

        List<String> rolesFulfilled = new ArrayList<>();

        for (Map.Entry<String, Map<String, Integer>> entry : musicians.entrySet()) {
            String name = entry.getKey();

            for (Map.Entry<String, Integer> map : entry.getValue().entrySet()) {
                if (theRole.test(map.getKey())) {
                    rolesFulfilled.add(name);
                    break;
                }
            }

        }
        return rolesFulfilled;
    }


}
