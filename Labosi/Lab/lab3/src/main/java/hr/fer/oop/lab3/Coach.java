package hr.fer.oop.lab3;

import hr.fer.oop.lab3.welcomepack.Constants;
import hr.fer.oop.lab3.welcomepack.Formation;
import hr.fer.oop.lab3.welcomepack.ManageableTeam;
import hr.fer.oop.lab3.welcomepack.Manager;
import hr.fer.oop.lab3.welcomepack.SimpleFootballPlayerCollection;

/**
 * This class represents a football coach, his name, representing country and
 * emotion level inherited from {@code public abstract class Person}, with the
 * addition of his coaching skill level and favorite formation.
 *
 * @author Matija
 */
public class Coach extends Person implements Manager, ITrainer {

    private int coachingSkill = Constants.DEFAULT_COACHING_SKILL;
    private Formation formation = Constants.DEFAULT_FORMATION;
    private ManageableTeam managingTeam;

    /**
     * Constructs a new object of type {@code Coach}. Variables name, country
     * and emotion cannot be changed after calling this constructor. Variables
     * coaching skill and formation can be altered by calling their 'set'
     * methods later.
     *
     * @param name
     * @param country
     * @param emotion
     * @param coachingSkill
     * @param formation
     */
    public Coach(String name, String country, int emotion, int coachingSkill, Formation formation) {
        super(name, country, emotion);
        setCoachingSkill(coachingSkill);
        setFormation(formation);

    }

    /**
     * Constructs a new object of type {@code Coach}.
     */
    public Coach() {
        super();
    }

    /**
     * Returns the coach's coachins skill level.
     *
     * @return coach's coaching skill level in range [1-100]
     */
    public int getCoachingSkill() {
        return coachingSkill;
    }

    /**
     * Sets the coach's coaching skill level. Value must be in range [1-100]
     * otherwise it will be set to its default value stated in
     * {@code Constants}.
     *
     * @param coachingSkill - coaching skill level in range [1-100]
     */
    public void setCoachingSkill(int coachingSkill) {
        if (coachingSkill < Constants.MIN_COACHING_SKILL
                || coachingSkill > Constants.MAX_COACHING_SKILL) {
            System.err.println("Coaching skill is out of range!");
        } else {
            this.coachingSkill = coachingSkill;
        }
    }

    /**
     * Return the coach's favorite formation (e.g. 442)
     *
     * @return coach's favorite formation
     */
    public Formation getFormation() {
        return formation;
    }

    /**
     * Sets the coach's favorite formation.
     *
     * @param formation coach's formation
     */
    public void setFormation(Formation formation) {
        if (formation == null) {
            System.err.println("Formation can't be null!");
        } else {
            this.formation = formation;
        }
    }

    /**
     * A method used to pick the starting eleven from a team he manages (NOTE:
     * only the players from registered players collection are eligible); a
     * method must be careful to pick such players who can form a team formation
     * (e.g., a number of forwards within first eleven should match a number of
     * forwards in a team formation).
     */
    @Override
    public void pickStartingEleven() {
        int gk = managingTeam.getFormation().getNoGK();
        int df = managingTeam.getFormation().getNoDF();
        int mf = managingTeam.getFormation().getNoMF();
        int fw = managingTeam.getFormation().getNoFW();

        managingTeam.clearStartingEleven();

        int startingElevenMaxSize = managingTeam.getStartingEleven().getMaxSize();

        for (FootballPlayer player : managingTeam.getRegisteredPlayers().getPlayers()) {

            if (player != null
                    && managingTeam.getStartingEleven().size() != startingElevenMaxSize) {

                // checks how many players of that position are already in the
                // starting eleven, depending on the chosen formation
                switch (player.getPlayingPosition()) {
                    // goalkeeper, always 1
                    case GK:
                        if (gk > 0) {
                            managingTeam.addPlayerToStartingEleven(player);
                            gk--;
                        }
                        break;
                    // defender, 4 by default in F442 formation
                    case DF:
                        if (df > 0) {
                            managingTeam.addPlayerToStartingEleven(player);
                            df--;
                        }
                        break;
                    // midfielder, 4 by default in F442 formation
                    case MF:
                        if (mf > 0) {
                            managingTeam.addPlayerToStartingEleven(player);
                            mf--;
                        }
                        break;
                    // forward, 2 by default in F442 formation    
                    case FW:
                        if (fw > 0) {
                            managingTeam.addPlayerToStartingEleven(player);
                            fw--;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }/*
    @Override
    public void pickStartingEleven() {

        managingTeam.clearStartingEleven();

        int startingElevenMaxSize = managingTeam.getStartingEleven().getMaxSize();
        FootballPlayer[] allPlayers = managingTeam.getRegisteredPlayers().getPlayers();
        FootballPlayer mostSkilled;

        for (int i = 0; i < startingElevenMaxSize; i++) {
            mostSkilled = retrieveMostSkilledPlayer(allPlayers);
            managingTeam.addPlayerToStartingEleven(mostSkilled);
            // dodaje mi samo prvog u starting eleven, i sve ostalo bude null
            // trebam nekako tog maknut iz allPlayers pa da metod atrazi najveceg
            // od preostalih
            for (FootballPlayer fp : allPlayers) {
                if (managingTeam.getStartingEleven().contains(fp)) {
                    fp = null;

                }
            }

        }
    }*/

    /**
     * Returns the most skilled player in the team.
     *
     * @param allPlayers
     * @return mostSkilled player
     */
    public FootballPlayer retrieveMostSkilledPlayer(FootballPlayer[] allPlayers) {
        FootballPlayer searcedPlayer = null;
        int biggest = 0;

        for (int i = 0; i < managingTeam.getRegisteredPlayers().size(); i++) {

            if (allPlayers[i] != null && allPlayers[i].getPlayingSkill() >= biggest) {
                searcedPlayer = allPlayers[i];
                biggest = allPlayers[i].getPlayingSkill();
            }
        }
        return searcedPlayer;

    }

    /**
     * A manager uses his formation to set team's formation.
     */
    @Override
    public void forceMyFormation() {
        managingTeam.setFormation(formation);
    }

    /**
     *
     * With this method, a manager sets a team he manages if a team is not null.
     *
     * @param team - coach's managing team
     */
    @Override
    public void setManagingTeam(ManageableTeam team) {
        if (team == null) {
            System.err.println("Team can't be null!");
        } else {
            this.managingTeam = team;
        }
    }

    /**
     *
     */
    @Override
    public void performTeamTrainingSession() {
        for (FootballPlayer p : managingTeam.getRegisteredPlayers().getPlayers()) {
            if (!managingTeam.getStartingEleven().contains(p)) {
                if (p == null) {
                    break;
                }
                if (p.getPlayingSkill() < this.getCoachingSkill()) {
                    p.setPlayingSkill((int) ((this.getCoachingSkill() * 0.1) + p.getPlayingSkill()));
                }
            }
        }
    }
}
