package zad1;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class HandballVisitor extends SimpleFileVisitor<Path> {
    private static List<Player> listOfPlayers = new LinkedList<Player>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
            throws IOException {
        if (file.toString().toLowerCase().endsWith(".txt")) {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new BufferedInputStream(
                                    new FileInputStream(file.toString())),
                            "UTF-8")
            );


            String team = file.toString().
                    replace("Handball\\", "").
                    replace(".txt", "");


            String line;
            while ((line = br.readLine()) != null) {
                String[] playerLine = line.split(";");

                String name = playerLine[0];
                String surname = playerLine[1];
                int number = Integer.valueOf(playerLine[2]);
                int goals = Integer.valueOf(playerLine[3]);
                int assists = Integer.valueOf(playerLine[4]);

                Player p = new Player(name, surname, number, goals, assists, team);
                listOfPlayers.add(p);
            }

        }
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) throws IOException {

        Path rukomet = Paths.get("Handball");
        FileVisitor<Path> visitor = new HandballVisitor();


        Files.walkFileTree(rukomet, visitor);

        //ispis sortirane liste strijelaca >5; koristiti Stream API nad listom igrača !
        listOfPlayers.stream().
                filter(p -> p.getGoals() > 5).
                sorted(Comparator.comparing(Player::getGoals).reversed()).
                forEach(p -> System.out.println(
                        p.getTeam() + " - " +
                                p.getSurname() + " : " +
                                p.getGoals()));

        //ispis prosjeka golova svakog tima; koristiti Stream API nad listom igrača !
        List<String> teams = new ArrayList<>();
        listOfPlayers.stream().map(p -> p.getTeam()).distinct().forEach(t -> teams.add(t));

        for (String team : teams){
            listOfPlayers.stream().
                    filter(p -> p.getTeam().equals(team)).
                    mapToInt(Player::getGoals).
                    average().
                    ifPresent(value -> System.out.println(team + " average : " + value));
        }

    }
}