package lab.zad5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Player {

    private String name;
    private double length;

    public Player(String name, double length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public double getLength() {
        return length;
    }

    @Override
    public String toString() {
        return getName() + ": " + getLength();
    }


}

class LengthCompetitionTable {

    List<Player> table;
    private double length;

    public LengthCompetitionTable() {
        table = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        table.add(player);
    }

    public List<Player> getByLength() {

        Collections.sort(table, (o1, o2) -> {
            if (o1.getLength() < o2.getLength()) {
                return 1;
            } else if (o1.getLength() > o2.getLength()) {
                return -1;
            } else {
                return 0;
            }
        });

        return table;


    }

    public List<Player> getByName() {

        Collections.sort(table, (o1, o2) -> o1.getName().compareTo(o2.getName()));

        return table;

    }
}

