package vjezba.salary;

import java.util.*;

public class LabTask {


    public static Map<Integer, Integer> averages(
            Map<String, Map<Integer, List<Integer>>> salaries) {

        Map<Integer, List<Double>> averagesList = new HashMap<>();
        Map<Integer, Integer> averages = new HashMap<>();

        for (Map<Integer, List<Integer>> entry : salaries.values()) {

            for (Map.Entry<Integer, List<Integer>> e : entry.entrySet()) {

                Integer key = e.getKey();
                List<Integer> values = e.getValue();

                double sum = 0;
                for (Integer pay : values) {
                    sum += pay;
                }

                double avg = sum / values.size();
                //System.out.println("year: " + key + " - " + avg);

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


        for (Map.Entry<Integer, List<Double>> e : averagesList.entrySet()) {
            double sum = 0;
            for (Double d : e.getValue()) {
                sum += d;
            }
            //System.out.println(e.getKey() + " " + sum);
            int avg = (int) sum / e.getValue().size();
            //System.out.println(e.getKey() + " " + avg + "- size: " + e.getValue().size() + "\n");
            averages.put(e.getKey(), avg);
        }

        return averages;
    }



}


