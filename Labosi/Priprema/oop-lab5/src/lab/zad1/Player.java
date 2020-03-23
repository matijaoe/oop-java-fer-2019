package lab.zad1;

import java.util.*;

class Player {

    private String name;
    private int points;

    public Player(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPoints();
    }

}

class PointCompetitionTable {

    List<Player> table;
    private Integer points;

    public PointCompetitionTable() {
        table = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        table.add(player);
        this.points = player.getPoints();
    }

    public List<Player> getCurrentTable() {



        Collections.sort(table, (o1, o2) -> o2.getPoints() - o1.getPoints());

        return table;


    }

    public List<Player> getByName() {

        Collections.sort(table, (o1, o2) -> o1.getName().compareTo(o2.getName()));

        return table;

    }
}



