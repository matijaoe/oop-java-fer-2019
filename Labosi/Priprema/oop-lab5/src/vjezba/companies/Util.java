package vjezba.companies;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Util {

    public static Map<String, Double> avgNumber(
            Map<String, List<Integer>> companies) {

        Map<String, Double> avgNumber = new HashMap<>();

        for (Map.Entry<String, List<Integer>> entry : companies.entrySet()) {

            String companyName = entry.getKey();
            List<Integer> employees = entry.getValue();

            double sum = 0.;
            for (Integer i : employees) {
                sum += i;
            }
            double avg = sum / employees.size();

            avgNumber.put(companyName, avg);
        }

        return avgNumber;
    }
}
