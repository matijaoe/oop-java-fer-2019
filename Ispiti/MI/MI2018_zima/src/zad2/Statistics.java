package zad2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Matija
 */
public class Statistics {

    public Statistics() {
    }

    public static void printGamesByMonth(List<PrizeGame> games) {
        List<Set<String>> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            list.add(new TreeSet<>());
        }

        for (PrizeGame game : games) {
            int month = game.getDrawDate().getMonthValue();
            list.get(month - 1).add(game.getName());
        }

        for (int i = 0; i < 12; i++) {
            if (list.get(i).size() > 0) {
                System.out.format("%d.\n", i + 1);
                for (String game : list.get(i)) {
                    System.out.println("\t- " + game);
                }
            }
        }
    }

    public static Set<String> gameWinners(List<PrizeGame> games, String gameName) {
        Set<String> winners = new TreeSet<>();

        for (PrizeGame game : games) {
            if (game.getName().equals(gameName)) {
                for (Prize prize : game.getPrizes()) {
                    winners.addAll(prize.getWinners());
                }
            }
        }
        return winners;
    }
}
