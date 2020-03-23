package lab.zad3;

import java.util.*;

class Solution implements StudentStatistics {

    Map<String, List<Integer>> database;
    List<Integer> grades;

    public Solution() {
        database = new HashMap<>();
    }


    @Override
    public void addStudentPoints(String student, Integer... points) {

        if (!database.containsKey(student)) {
            grades = new ArrayList<>();
        }

        for (Integer i : points) {
            grades.add(i);
        }

        database.put(student, grades);

    }

    @Override
    public Integer getTotalPoints() {
        int sum = 0;
        for (List<Integer> entry : database.values()) {
            for (Integer n : entry) {
                sum += n;
            }
        }
        return sum;
    }

    @Override
    public Integer getStudentSize() {
        return database.size();
    }

    @Override
    public Integer getTotalPointsForStudent(String student) {

        Integer sum = 0;

        if (!database.containsKey(student)) {
            return null;
        }

        for (Integer i : database.get(student)) {
            sum += i;
        }


        return sum;
    }
}
