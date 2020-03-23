package hr.fer.oop.lab3;

import hr.fer.oop.lab3.welcomepack.Constants;
import hr.fer.oop.lab3.welcomepack.Formation;
import hr.fer.oop.lab4.exceptions.TeamCountryNullException;

/**
 * This class represents a football national team, with its name, formation and
 * country. Maximum number of allowed registered players for the national team
 * is 23.
 *
 * @author Matija
 */
public class NationalTeam extends Team {

    private String country = Constants.DEFAULT_COUNTRY;

    /**
     * Constructs a new instance of {@code NationalTeam}. The name, formation
     * and country cannot be changed after the initial calling of this
     * constructor.
     *
     * @param name
     * @param formation
     * @param country
     */
    public NationalTeam(String name, Formation formation, String country) {
        super(name, formation, Constants.MAX_NO_PLAYERS_NATIONAL);
        boolean foundException = false;

        try {
            if (country != null) {
                this.country = country;
            } else {
                throw new TeamCountryNullException();
            }
        } catch (TeamCountryNullException e) {
            e.printStackTrace();
            this.country = "no country";
            foundException = true;

        } finally {
            if (foundException) {
                System.out.println("Country set to no country");
            }
        }
    }

    /**
     * Constructs a new instance of type {@code NationalTeam}.
     */
    public NationalTeam() {
        super(Constants.MAX_NO_PLAYERS_NATIONAL);
    }

    /**
     * If a team is a national team, a player need to have the same country as a
     * national team; whereas if a team is a club team, a player needs to have
     * player skill which is higher or equal to club's reputation (note: in
     * either case player registration will be successful if there is a space
     * for a player)
     *
     * @param player player
     * @return true if a player is added, false otherwise.
     */
    public boolean registerPlayer(FootballPlayer player) {
        if (player == null) {
            return false;
        }
        if (!player.getCountry().equals(country)
                || getRegisteredPlayers().size() >= getRegisteredPlayers().getMaxSize()) {
            return false;
        }

        getRegisteredPlayers().add(player);
        return true;
    }

    /**
     * Calculates and returns calculated team rating as follows:
     *
     * Club team: 70% sum of skills from registered players + 30% sum of
     * emotions from registered players;
     *
     *
     * National team: 30% sum of skills from registered players + 70% sum of
     * emotions from registered players.
     *
     * @return returns a team rating.
     */
    @Override
    public double calculateRating() {
        return Constants.THIRTY_PERCENT * getRegisteredPlayers().calculateSkillSum()
                + Constants.SEVENTY_PERCENT * getRegisteredPlayers().calculateEmotionSum();
    }
}
