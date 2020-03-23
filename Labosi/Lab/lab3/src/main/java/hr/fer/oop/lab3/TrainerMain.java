package hr.fer.oop.lab3;

import hr.fer.oop.lab3.welcomepack.Constants;
import hr.fer.oop.lab3.welcomepack.PlayingPosition;
import hr.fer.oop.lab3.welcomepack.Formation;
import hr.fer.oop.lab3.welcomepack.Manager;

/**
 *
 * @author Matija
 */
public class TrainerMain {

    public static final int[] SKILL = {65, 34, 45, 99, 89, 60, 55, 90, 23, 61, 62, 67,
        80, 85, 56, 34, 80, 81, 97, 81};
    public static final int PLAYERS_SIZE = 20;

    public static void main(String[] args) {

        ClubTeam team = new ClubTeam();
        Coach manager1 = new Coach("Ban Vasten", "Dutch", 66, 70, Formation.F442);

        manager1.setManagingTeam(team);

        // stvaranje i registracija igraca:
        for (int i = 0; i < 20; i++) {
            team.registerPlayer(new FootballPlayer(Constants.DEFAULT_PLAYER_NAME,
                    Constants.DEFAULT_COUNTRY, 10, SKILL[i], PlayingPosition.DF));
        }

        manager1.pickStartingEleven();

        manager1.performTeamTrainingSession();
        manager1.pickStartingEleven();
    }
}
