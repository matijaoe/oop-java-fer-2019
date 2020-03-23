package vjezba.muzicari;

import java.util.HashMap;
import java.util.Map;

public class Util3 {

    public static Map<String, Double> averageSkillFiltrered(
            Map<String, Map<String, Integer>> musicians,
            String role) {

        Map<String, Double> averageSkill = new HashMap<>();

        for (Map.Entry<String, Map<String, Integer>> entry : musicians.entrySet()) {
            String name = entry.getKey();

            double sum = 0;

            Map<String, Integer> map = entry.getValue();
            for (Map.Entry<String, Integer> e : map.entrySet()) {

                if (!map.containsKey(role)) {
                    break;
                }
                int skill = e.getValue();
                sum += skill;
            }
            double avg = sum / map.size();

            if (sum != 0.0) {
                averageSkill.put(name, avg);
            }
        }

        return averageSkill;
    }
}
