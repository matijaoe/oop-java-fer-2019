package hr.fer.oop.lab3;

import hr.fer.oop.lab3.welcomepack.SimpleFootballPlayerCollection;

/**
 * This class represents a collection of football players.
 *
 * @author Matija
 */
public class SimpleFootballPlayerCollectionImpl implements SimpleFootballPlayerCollection {

    private FootballPlayer[] players;

    /**
     * Constructs the size of the player collection.
     *
     * @param size
     */
    public SimpleFootballPlayerCollectionImpl(int size) {
        players = new FootballPlayer[size];
    }

    /**
     * Returns the number of players currently stored in a collection.
     *
     * @return current number of players within a collection.
     */
    @Override
    public int size() {
        int count = 0;
        for (FootballPlayer player : players) {
            if (player != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Checks whether a collection contains a player.
     *
     * @param player player
     * @return true if a collection contains a player, false otherwise.
     */
    @Override
    public boolean contains(FootballPlayer player) {
        if (player == null) {
            return false;
        }
        for (FootballPlayer p : players) {
            if (p != null) {
                if (player.equals(p)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Adds a player in a collection if he has not been previously added and if
     * there is a space available for a player within a collection.
     *
     * @param player player
     * @return true if a player is added, false otherwise.
     */
    @Override
    public boolean add(FootballPlayer player) {
        if (!contains(player)) {
            for (int i = 0; i < players.length; i++) {
                if (players[i] == null) {
                    players[i] = player;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Clears all players from a collection.
     */
    @Override
    public void clear() {
        for (int i = 0; i < players.length; i++) {
            players[i] = null;
        }
    }

    /**
     * Maximum number of players who can be stored in a collection, e.g., if a
     * collection is used to store starting eleven then this method should
     * return 11;
     *
     * @return maximum number of players a collection's capacity.
     */
    @Override
    public int getMaxSize() {
        return players.length;
    }

    /**
     * Calculates the sum of emotions from all players within a collection.
     *
     * @return the sum of emotions.
     */
    @Override
    public int calculateEmotionSum() {
        int emotionSum = 0;
        for (FootballPlayer player : players) {
            if (player != null) {
                emotionSum += player.getEmotion();
            }
        }
        return emotionSum;
    }

    /**
     * Calculates the sum of skills from all players within a collection.
     *
     * @return the sum of emotions.
     */
    @Override
    public int calculateSkillSum() {
        int skillSum = 0;
        for (FootballPlayer player : players) {
            if (player != null) {
                skillSum += player.getPlayingSkill();
            }
        }
        return skillSum;
    }

    /**
     * Method used to get the underlying array in which players are actually
     * stored.
     *
     * @return an array
     */
    @Override
    public FootballPlayer[] getPlayers() {
        return players;
    }

}
