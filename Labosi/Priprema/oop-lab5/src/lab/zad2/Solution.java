package lab.zad2;


import java.util.*;

class Solution implements StudentDatabase {

    Map<String, Map<String, Integer>> database;
    Map<String, Integer> courseMap;

    public Solution() {
        database = new HashMap<>();

    }

    @Override
    public void addEntry(String student, String course, int score) {


        if (database.get(student) == null) {
            courseMap = new HashMap<>();
        }

        courseMap.put(course, score);
        database.put(student, courseMap);

    }

    @Override
    public Integer getScore(String student, String course) {
        Integer score = 0;



        for (Map.Entry<String, Map<String, Integer>> entry : database.entrySet()) {

            if (entry.getKey().equals(student)) {

                for (Map.Entry<String, Integer> e : entry.getValue().entrySet()) {
                    if (e.getKey().equals(course)) {
                        score = e.getValue();
                    }

                }
            }
        }
        if (score == 0) {
            return null;
        }
        return score;
    }

    @Override
    public Collection<Integer> getNaturallyOrderedScoresByCourse(String course) {
        List<Integer> list = new ArrayList<>();

        for (Map.Entry<String, Map<String, Integer>> entry : database.entrySet()) {
            if (entry.getValue().containsKey(course)) {
                int score = getScore(entry.getKey(), course);
                list.add(score);

            }
        }


        Collections.sort(list);

        return list;

    }
}
