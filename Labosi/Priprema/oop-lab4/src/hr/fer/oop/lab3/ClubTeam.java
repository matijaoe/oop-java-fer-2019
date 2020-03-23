package hr.fer.oop.lab3;

import hr.fer.oop.lab3.welcomepack.Constants;
import hr.fer.oop.lab3.welcomepack.Formation;

/**
 * This class represents a football club team, with its name, formation and
 * reputation level, in range [1-100]. Maximum number of registered players for
 * a club team is 25.
 *
 * @author Matija
 */
public class ClubTeam extends Team {

    private int reputation = Constants.DEFAULT_REPUTATION;

    /**
     *
     * Constructs a new instance of type {@code ClubTeam}. The name and
     * formation cannot be changed after calling this constructor.
     *
     * @param name
     * @param formation
     * @param reputation
     */
    public ClubTeam(String name, Formation formation, int reputation) {
        super(name, formation, Constants.MAX_NO_PLAYERS_CLUB);
        setReputation(reputation);
    }

    /**
     * Constructs a new instance of type {@code ClubTeam}.
     */
    public ClubTeam() {
        super(Constants.MAX_NO_PLAYERS_CLUB);
    }

    /**
     * Returns team's reputation level.
     *
     * @return reputation
     */
    public int getReputation() {
        return reputation;
    }

    /**
     * Sets the team's reputation.
     *
     * @param reputation club's reputation level
     */
    public void setReputation(int reputation) {
        if (reputation < Constants.MIN_REPUTATION
                || reputation > Constants.MAX_REPUTATION) {
            System.err.println("Reputation is out of range!");
        } else {
            this.reputation = reputation;
        }
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
    @Override
    public boolean registerPlayer(FootballPlayer player) {
        if (player == null) {
            return false;
        }
        if (player.getPlayingSkill() < reputation || getRegisteredPlayers().size() >= getRegisteredPlayers().getMaxSize()) {
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
        return Constants.SEVENTY_PERCENT * getRegisteredPlayers().calculateSkillSum()
                + Constants.THIRTY_PERCENT * getRegisteredPlayers().calculateEmotionSum();
    }

}
