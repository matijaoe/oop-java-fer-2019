package zad3;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;

// Mapa sadrži ime studenta i njegove ocjene iz svih predmeta
// (ne bilježi se koja ocjena pripada kojem predmetu)
public class Grades2 {

    private Map<String, List<Integer>> gradesMap;

    public Grades2() {
        gradesMap = new TreeMap<>();
    }

    // Ako se ponovno unese ocjena za već postojećeg studenta, dodaje se u njegovu listu ocjena
    public void add(String name, Integer grade) {
        if (gradesMap.containsKey(name)) {
            List<Integer> grades = gradesMap.get(name);
            grades.add(grade);
            gradesMap.put(name, grades); // Je li ovo potrebno? Nije, jer se automatski azurira vrijedost
        } else {
            List<Integer> grades = new ArrayList<>();
            grades.add(grade);
            gradesMap.put(name, grades);
        }
    }

    public void print() {
        for (Map.Entry<String, List<Integer>> entry : gradesMap.entrySet()) {
            System.out.print(entry.getKey() + ": ");

            List<Integer> grades = entry.getValue();

            double sum = 0.0;
            for (Integer grade : grades) {
                System.out.print(grade + ", ");
                sum += grade.intValue();
            }
            System.out.println("(" + sum / grades.size() + ")");
        }
    }
}