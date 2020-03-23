package zad3;

import java.util.Map;
import java.util.HashMap;

public class Grades3 {
    private Map<String, Map<String, Integer>> gradesMap;

    public Grades3() {
        gradesMap = new HashMap<>();
    }

    // Ako se ponovno unese ocjena za već postojećeg studenta i predmet,
    // prepisuje se stara ocjena
    public void add(String name, String course, Integer grade) {
        if (gradesMap.containsKey(name)) {
            Map<String, Integer> grades = gradesMap.get(name);
            grades.put(course, grade);
            //gradesMap.put(name, grades); // Je li ovo potrebno?
        } else {
            Map<String, Integer> grades = new HashMap<>();
            grades.put(course, grade);
            gradesMap.put(name, grades);
        }
    }

    public void print() {
        for (Map.Entry<String, Map<String, Integer>> entry : gradesMap.entrySet()) {
            System.out.print(entry.getKey() + ": ");

            Map<String, Integer> grades = entry.getValue();

            double sum = 0.0;
            for (Integer grade : grades.values()) {
                sum += grade.intValue();
            }
            System.out.println(sum / grades.size());
        }
    }

    public void printForCourse(String course) {
        int numStudents = 0;
        double gradesSum = 0.0;
        double avgCourse = 0.0;

        for (Map.Entry<String, Map<String, Integer>> entry : gradesMap.entrySet()) {
            Map<String, Integer> grades = entry.getValue();

            for (Map.Entry<String, Integer> entry2 : grades.entrySet()) {
                Integer grade = entry2.getValue();
                String course2 = entry2.getKey();
                if (course2.equals(course)) {
                    numStudents++;
                    gradesSum += grade;
                }
            }
        }

        if (numStudents > 0) {
            avgCourse = gradesSum / numStudents;
        }
        System.out.println("\nProsjek ocjena za predmet " + course + " je: " +
                avgCourse);
    }
}