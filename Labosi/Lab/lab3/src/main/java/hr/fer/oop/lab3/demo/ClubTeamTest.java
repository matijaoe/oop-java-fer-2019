package hr.fer.oop.lab3.demo;

import hr.fer.oop.lab3.ClubTeam;
import hr.fer.oop.lab3.FootballPlayer;
import hr.fer.oop.lab3.welcomepack.Constants;
import hr.fer.oop.lab3.welcomepack.PlayingPosition;

public class ClubTeamTest {

    public static void main(String[] args) {

        final double DELTA = 0.001;
        ClubTeam defaultTeam = new ClubTeam();

        defaultTeam.setReputation(-1);
        if (defaultTeam.getReputation() != Constants.DEFAULT_REPUTATION) {
            System.err.println("TEST FAILED: Reputacija je izvan raspona!");
        }
        defaultTeam.setReputation(101);
        if (defaultTeam.getReputation() != Constants.DEFAULT_REPUTATION) {
            System.err.println("TEST FAILED: Reputacija je izvan raspona!");
        }

        FootballPlayer player = new FootballPlayer();
        defaultTeam.registerPlayer(player);
        if (!defaultTeam.isPlayerRegistered(player)) {
            System.err.println("TEST FAILED: Igrac je trebao biti registriran!");
        }

        FootballPlayer unskilledPlayer = new FootballPlayer("Slacker", Constants.DEFAULT_COUNTRY, 1, 1,
                PlayingPosition.DF);
        defaultTeam.registerPlayer(unskilledPlayer);
        if (defaultTeam.isPlayerRegistered(unskilledPlayer)) {
            System.err.println("TEST FAILED: Igrac ne bi smio biti registriran!!");
        }

        ClubTeam reputationTeam = new ClubTeam();
        for (int i = 0; i < 20; i++) {
            FootballPlayer sequentialPlayer = new FootballPlayer("NAME" + i, Constants.DEFAULT_COUNTRY, 10, 100,
                    PlayingPosition.GK);
            reputationTeam.registerPlayer(sequentialPlayer);
        }
        double expected = (10 * Constants.THIRTY_PERCENT + 100 * Constants.SEVENTY_PERCENT) * 20;
        if (Math.abs(reputationTeam.calculateRating() - expected) > DELTA) {
            System.err.println("TEST FAILED: Reputacija tima ne izracunava se dobro!!");
        }

        System.out.println("Ako nemate 'TEST FAILED' poruke onda je ovaj osnovni test prosao."
                + "\nSada napisite neke svoje testove kako biste isprobali druge funkcionalnosti.");

    }
}
