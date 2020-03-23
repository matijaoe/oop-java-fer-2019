package lab.zad1;

public class Main {

    public static void main(String[] args) {

        PointCompetitionTable table = new PointCompetitionTable();
        table.addPlayer(new Player("Pero", 91));
        table.addPlayer(new Player("Jura", 96));
        table.addPlayer(new Player("Ana", 100));
        table.addPlayer(new Player("Iva", 78));
        table.addPlayer(new Player("Zvonimir", 99));
        table.addPlayer(new Player("Ante", 82));

        System.out.println("Po bodovima");
        for (Player p : table.getCurrentTable())
            System.out.println(p);

        System.out.println("\nPo abecedi");
        for (Player p : table.getByName())
            System.out.println(p);
    }
}
