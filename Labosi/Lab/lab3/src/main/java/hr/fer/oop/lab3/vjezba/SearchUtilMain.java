package hr.fer.oop.lab3.vjezba;

import hr.fer.oop.lab3.FootballPlayer;
import hr.fer.oop.lab3.SimpleFootballPlayerCollectionImpl;
import hr.fer.oop.lab3.welcomepack.PlayingPosition;
import hr.fer.oop.lab3.welcomepack.SimpleFootballPlayerCollection;

/**
 *
 * @author Matija
 */
public class SearchUtilMain {

    public static int counter = 0;

    public static void main(String[] args) {

        FootballPlayer Gavranovic = new FootballPlayer("Gavranovic", "Switzerland", 60, 65, PlayingPosition.FW);
        counter++;
        FootballPlayer Olmo = new FootballPlayer("Dani Olmo", "Spain", 77, 95, PlayingPosition.MF);
        counter++;
        FootballPlayer Dilaver = new FootballPlayer("Dilaver", "Austria", 100, 70, PlayingPosition.DF);
        counter++;
        FootballPlayer Livakovic = new FootballPlayer("Livakovic", "Croatia", 80, 80, PlayingPosition.GK);
        counter++;
        FootballPlayer Ademi = new FootballPlayer("Ademi", "Makedonija", 90, 90, PlayingPosition.MF);
        counter++;
        FootballPlayer Petkovic = new FootballPlayer("Petkovic", "Croatia", 40, 70, PlayingPosition.FW);
        counter++;
        FootballPlayer Stojanovic = new FootballPlayer("Stojanovic", "Slovenia", 60, 50, PlayingPosition.DF);
        counter++;
        FootballPlayer Majer = new FootballPlayer("Majer", "Croatia", 55, 86, PlayingPosition.MF);
        counter++;

        SimpleFootballPlayerCollection team = new SimpleFootballPlayerCollectionImpl(counter);

        team.add(Gavranovic);
        team.add(Olmo);
        team.add(Dilaver);
        team.add(Livakovic);
        team.add(Ademi);
        team.add(Petkovic);
        team.add(Stojanovic);
        team.add(Majer);

        FootballPlayer[] aboveMedianPlayers = SearchUtil.retrieveAboveMedianSkillPlayers(team).getPlayers();

        System.out.println("\nPlayers with skill above median: ");
        for (FootballPlayer p : aboveMedianPlayers) {
            if (p == null) {
                break;
            } else {
                System.out.println("\t- " + p.getName());
            }

        }

        FootballPlayer worstPlayer = SearchUtil.retrieveLowSkilledPlayer(team, PlayingPosition.DF);
        System.out.println("\nLowest skilled player:");
        System.out.println("\t- " + worstPlayer.getName() + " - " + worstPlayer.getPlayingSkill());

        FootballPlayer[] goalkeepers = SearchUtil.retrievePlayingPositionPlayers(team, PlayingPosition.GK).getPlayers();
        System.out.println("Goalkeepers:");
        for (FootballPlayer p : goalkeepers) {
            if (p == null) {
                break;
            }
            System.out.println("\t-" + p.getName());
        }

        FootballPlayer[] defenders = SearchUtil.retrievePlayingPositionPlayers(team, PlayingPosition.DF).getPlayers();
        System.out.println("\nDefenders:");
        for (FootballPlayer p : defenders) {
            if (p == null) {
                break;
            }
            System.out.println("\t-" + p.getName());
        }

        FootballPlayer[] midfielders = SearchUtil.retrievePlayingPositionPlayers(team, PlayingPosition.MF).getPlayers();
        System.out.println("\nMidfielders:");
        for (FootballPlayer p : midfielders) {
            if (p == null) {
                break;
            }
            System.out.println("\t-" + p.getName());
        }

        FootballPlayer[] forwards = SearchUtil.retrievePlayingPositionPlayers(team, PlayingPosition.FW).getPlayers();
        System.out.println("\nForwards:");
        for (FootballPlayer p : forwards) {
            if (p == null) {
                break;
            }
            System.out.println("\t-" + p.getName());
        }
    }

}
