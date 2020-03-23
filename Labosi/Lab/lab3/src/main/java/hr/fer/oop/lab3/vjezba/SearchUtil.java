package hr.fer.oop.lab3.vjezba;

import hr.fer.oop.lab3.FootballPlayer;
import hr.fer.oop.lab3.SimpleFootballPlayerCollectionImpl;
import hr.fer.oop.lab3.welcomepack.PlayingPosition;
import hr.fer.oop.lab3.welcomepack.SimpleFootballPlayerCollection;

public class SearchUtil {

    public static SimpleFootballPlayerCollection retrieveAboveMedianSkillPlayers(SimpleFootballPlayerCollection players) {

        SimpleFootballPlayerCollection searchedPlayers = new SimpleFootballPlayerCollectionImpl(20);
        double median = 0;

        if (players.getPlayers().length % 2 != 0) { // neparni
            median = players.getPlayers()[players.getPlayers().length / 2].getPlayingSkill();
        } else { // parni    
            median = (players.getPlayers()[players.getPlayers().length / 2 - 1].getPlayingSkill() + players.getPlayers()[players.getPlayers().length / 2].getPlayingSkill()) / 2;
        }

        for (int i = 0; i < players.size(); i++) {
            if (players.getPlayers()[i].getPlayingSkill() > median) {
                searchedPlayers.add(players.getPlayers()[i]);
            }
        }
        return searchedPlayers;
    }

    public static FootballPlayer retrieveLowSkilledPlayer(SimpleFootballPlayerCollection players, PlayingPosition playingPos) {

        FootballPlayer searcedPlayer = null;
        int lowest = 100;

        for (int i = 0; i < players.size(); i++) {
            if (players.getPlayers()[i].getPlayingPosition().equals(playingPos) && players.getPlayers()[i].getPlayingSkill() <= lowest) {
                searcedPlayer = players.getPlayers()[i];
                lowest = players.getPlayers()[i].getPlayingSkill();
            }
        }
        return searcedPlayer;
    }

    public static SimpleFootballPlayerCollection retrievePlayingPositionPlayers(SimpleFootballPlayerCollection players, PlayingPosition playingPos) {

        SimpleFootballPlayerCollection playersOnPosition = new SimpleFootballPlayerCollectionImpl(20);
        FootballPlayer[] newPlayers = players.getPlayers();

        for (FootballPlayer p : newPlayers) {
            if (p == null) {
                break;
            } else {
                if (p.getPlayingPosition().equals(playingPos)) {
                    playersOnPosition.add(p);
                }
            }
        }
        return playersOnPosition;
    }

}
