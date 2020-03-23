package hr.fer.oop.lab3;

import hr.fer.oop.lab3.welcomepack.Constants;
import hr.fer.oop.lab3.welcomepack.Formation;
import hr.fer.oop.lab3.welcomepack.ManageableTeam;
import hr.fer.oop.lab3.welcomepack.SimpleFootballPlayerCollection;
import hr.fer.oop.lab4.exceptions.TeamFormationNullException;
import hr.fer.oop.lab4.exceptions.TeamNameNullException;

/**
 * This class represents a football team, along with its name and formation. It
 * implements a collection containing registered players and starting eleven
 * players of type {@code FootballPlayer}. This class is used as a base class
 * for its subclasses.
 *
 * @author Matija
 */
public abstract class Team implements ManageableTeam {

    private String name = Constants.DEFAULT_TEAM_NAME;
    private Formation formation = Constants.DEFAULT_FORMATION;
    private SimpleFootballPlayerCollection registeredPlayers;
    private SimpleFootballPlayerCollection startingEleven
            = new SimpleFootballPlayerCollectionImpl(Constants.STARTING_ELEVEN_SIZE);

    /**
     * Base constructor for its subclasses. Name and formation cannot be changed
     * after calling this constructor.
     *
     * @param name team name
     * @param formation team formation
     * @param registeredPlayersSize number of registered players in the team
     */
    public Team(String name, Formation formation, int registeredPlayersSize) {
        this.registeredPlayers = new SimpleFootballPlayerCollectionImpl(registeredPlayersSize);
        boolean foundException = false;

        try {
            if (name != null) {
                this.name = name;
            } else {
                throw new TeamNameNullException();
            }
        } catch (TeamNameNullException e) {
            e.printStackTrace();
            this.name = "NoName";
            foundException = true;

        } finally {
            if (foundException) {
                System.out.println("Name is set to noName");
            }
        }
        setFormation(formation);
    }

    /**
     * Base constructor for its subclasses.
     *
     * @param registeredPlayersSize number of registered players in the team
     */
    public Team(int registeredPlayersSize) {
        this.registeredPlayers
                = new SimpleFootballPlayerCollectionImpl(registeredPlayersSize);
    }

    /**
     *
     * Adds a player to starting eleven if a player is in registered player
     * collection and there is a space for him within starting eleven.
     * registriranih igraca te ima mjesta u prvih 11.
     *
     * @param player a football player
     * @return true if a player is added, false otherwise.
     */
    @Override
    public boolean addPlayerToStartingEleven(FootballPlayer player) {
        if (isPlayerRegistered(player) && !startingEleven.contains(player)
                && startingEleven.size() < Constants.STARTING_ELEVEN_SIZE) {
            startingEleven.add(player);
            return true;
        }
        return false;
    }

    /**
     * Checks whether a player is registered in a team.
     *
     * @param player a football player
     * @return true if a player is registered, false otherwise.
     */
    @Override
    public boolean isPlayerRegistered(FootballPlayer player) {
        return registeredPlayers.contains(player);
    }

    /**
     * Returns a collection of registered players.
     *
     * @return registered players
     */
    @Override
    public SimpleFootballPlayerCollection getRegisteredPlayers() {
        return registeredPlayers;
    }

    /**
     * Returns a collection of starting eleven players.
     *
     * @return starting eleven
     */
    @Override
    public SimpleFootballPlayerCollection getStartingEleven() {
        return startingEleven;
    }

    /**
     * Sets the formation if it is not null.
     *
     * @param formation formation
     */
    @Override
    public void setFormation(Formation formation) {
        boolean foundException = false;

        try {
            if (formation != null) {
                this.formation = formation;
            } else {
                throw new TeamFormationNullException();
            }

        } catch (TeamFormationNullException e) {
            e.printStackTrace();
            this.formation = Formation.F442;
            foundException = true;

        } finally {
            if (foundException) {
                System.out.println("Formation set to 442");
            }
        }
    }

    /**
     * Returns the formation.
     *
     * @return formation
     */
    @Override
    public Formation getFormation() {
        return formation;
    }

    /**
     * Clears a collection of starting eleven.
     */
    @Override
    public void clearStartingEleven() {
        startingEleven.clear();
    }

    public static void main(String[] args) {

    }

}
