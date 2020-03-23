package vjezba.friends;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Pair {

    private String first;
    private String second;

    public Pair(String first, String second) {
        this.first = first;
        this.second = second;
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    public static void main(String[] args) {

        Pair p1 = new Pair("Gordan", "Nikola");
        Pair p2 = new Pair("Mihaela", "Nikola");
        Pair p3 = new Pair("Gordan", "Mario");

        Collection<Pair> col = new HashSet<>();
        col.add(p1);
        col.add(p2);
        col.add(p3);

        Map<String, Set<Pair>> map = LabTask.getFriends(col);
        for (Map.Entry<String, Set<Pair>> e : map.entrySet()) {
            System.out.format(e.getKey() + " -> ");
            for (Set<Pair> p : map.values()) {
                System.out.println(p);
            }
        }
    }
}
