package lab.zad5;



public class Main {

    public static void main(String[] args) {

        LengthCompetitionTable table = new LengthCompetitionTable();
        table.addPlayer(new Player("Pero", 53.10));
        table.addPlayer(new Player("Jura", 54.00));
        table.addPlayer(new Player("Ana", 47.95));
        table.addPlayer(new Player("Iva", 49.05));
        table.addPlayer(new Player("Zvonimir", 51.43));
        table.addPlayer(new Player("Ante", 46.57));

        System.out.println("Po duljinama");
        for(Player p: table.getByLength())
            System.out.println(p);

        System.out.println("\nPo abecedi");
        for(Player p: table.getByName())
            System.out.println(p);
    }
}
