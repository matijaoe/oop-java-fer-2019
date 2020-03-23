package vjezba.salary;

import java.util.*;


// Neznam dokraja
public class LabTask2 {

    public static Map<Integer, Set<String>> underpayed(
            Map<String, Map<Integer, List<Integer>>> salaries) {

        Map<Integer, List<Double>> averagesList = new HashMap<>();
        Map<Integer, Integer> averages = new HashMap<>();

        Map<String, Map<Integer, Double>> averagePerWorker = new HashMap<>();
        Map<Integer, Double> insideMap = new HashMap<>();

        Map<Integer, Set<String>> underpaid = new HashMap<>();


        // trazim prosjeke godina, godine su key, a value je lista prosjeka svakog radnika za tu godinu
        for (Map.Entry<String, Map<Integer, List<Integer>>> entry : salaries.entrySet()) {
            String worker = entry.getKey();

            for (Map<Integer, List<Integer>> e : salaries.values()) {

                for (Map.Entry<Integer, List<Integer>> e2 : e.entrySet()) {

                    Integer key = e2.getKey();
                    List<Integer> values = e2.getValue();

                    double sum = 0;
                    for (Integer pay : values) {
                        sum += pay;
                    }

                    double avg = sum / values.size();
                    //dodajem radnika u mapu, worker je key, a projek njegovih godina je value kao mapa
                    insideMap.put(key, avg);
                    averagePerWorker.put(worker, insideMap);

                    if (!averagesList.containsKey(key)) {
                        List<Double> salaryList = new ArrayList<>();
                        salaryList.add(avg);
                        averagesList.put(key, salaryList);
                    } else {
                        List<Double> salaryList = averagesList.get(key);
                        salaryList.add(avg);
                        averagesList.put(key, salaryList);
                    }
                }
            }

        }

        // racunam ukupni projek godine
        for (Map.Entry<Integer, List<Double>> e : averagesList.entrySet()) {
            double sum = 0;
            for (Double d : e.getValue()) {
                sum += d;
            }
            int avg = (int) sum / e.getValue().size();
            averages.put(e.getKey(), avg);
        }

        return underpaid;
    }
}