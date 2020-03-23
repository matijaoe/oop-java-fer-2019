package vjezba.salary;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("Duplicates")
public class Main {

    public static void main(String[] args) {

        Map<String, Map<Integer, List<Integer>>> salaries = new HashMap();

        Map<Integer, List<Integer>> map1 = new HashMap<>();
        map1.put(2013, Arrays.asList(8000, 8000, 9045, 9500, 8700, 9000, 9100, 9280, 10000, 12000, 10000, 12000));
        map1.put(2014, Arrays.asList(12000, 12550, 14000, 14000, 13000, 12000, 12000, 12800, 13600, 12000, 12850, 13600));
        map1.put(2015, Arrays.asList(10000, 14000, 13000, 12600, 12500, 14000, 14200, 15000, 15000, 18000, 18000, 18550));
        map1.put(2016, Arrays.asList(5000, 12550, 11000, 14050, 13000, 12000, 12000, 14000, 13860, 12000, 13500, 13600));
        salaries.put("021", map1);

        Map<Integer, List<Integer>> map2 = new HashMap<>();
        map2.put(2015, Arrays.asList(9000, 9500, 9800, 10000, 8700, 9500, 9800, 9980, 10000, 12000, 12000, 12000));
        map2.put(2016, Arrays.asList(14000, 14550, 14600, 14800, 15000, 15000, 15000, 15500, 17600, 18000, 18850, 20000));
        salaries.put("094", map2);

        Map<Integer, List<Integer>> map3 = new HashMap<>();
        map3.put(2016, Arrays.asList(10000, 5000, 5045, 5500, 6500, 6750, 9000, 9280, 10000, 10000, 10600, 11000));
        salaries.put("034", map3);

        Map<Integer, Integer> averages = LabTask.averages(salaries);
        for (Map.Entry<Integer, Integer> e : averages.entrySet()) {
            System.out.println(String.format("Average %d salary: %d HRK", e.getKey(), e.getValue()));
        }



    }


}
