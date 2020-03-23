package vjezba.companies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util2 {

    public static Map<String, List<Integer>> trend(
            Map<String, List<Integer>> companies) {

        Map<String, List<Integer>> trend = new HashMap<>();
        List<Integer> listaRazlika = new ArrayList<>();

        for (Map.Entry<String, List<Integer>> entry : companies.entrySet()) {

            String companyName = entry.getKey();
            List<Integer> employees = entry.getValue();

            for (int i = 1; i < employees.size(); i++) {
                int razlika = employees.get(i) - employees.get(i-1);
                listaRazlika.add(razlika);
            }

            trend.put(companyName, listaRazlika);
        }

        return trend;
    }

}

