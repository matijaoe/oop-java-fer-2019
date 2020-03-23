package hr.fer.oop.lab3;

import hr.fer.oop.lab3.welcomepack.Constants;
import hr.fer.oop.lab3.welcomepack.PlayingPosition;

/**
 * This class represents a football player, his name, representing country and
 * emotion level inherited from {@code Person}, with an addition of his playing
 * skill level and playing position.
 *
 * @author Matija
 */
public class FootballPlayer extends Person {

    private int playingSkill = Constants.DEFAULT_PLAYING_SKILL;
    private PlayingPosition playingPosition = Constants.DEFAULT_PLAYING_POSITION;

    /**
     * Constructs a new instance of type {@code FootballPlayer}. Variables name,
     * country and emotion cannot be changed after calling this constructor.
     * Variables playing skill and playing position can be altered by calling
     * their 'set' methods later.
     *
     * @param name player's name
     * @param country player's coutry
     * @param emotion player's emotion level
     * @param playingSkill player's playing skill level
     * @param playingPosition player's playing position
     */
    public FootballPlayer(String name, String country, int emotion,
            int playingSkill, PlayingPosition playingPosition) {
        super(name, country, emotion);
        setPlayingSkill(playingSkill);
        setPlayingPosition(playingPosition);
    }

    /**
     * Constructs a new instance of type {@code FootballPlayer}.
     */
    public FootballPlayer() {
        super();
    }

    /**
     * Returns the player's playing skill level.
     *
     * @return player's playing skill level in range [1-100]
     */
    public int getPlayingSkill() {
        return playingSkill;
    }

    /**
     * Sets the player's playing skill level. Value must be in range [1-100]
     * otherwise it will be set to its default value stated in
     * {@code Constants}.
     *
     * @param playingSkill playing skill level in range [1-100]
     */
    public void setPlayingSkill(int playingSkill) {
        if (playingSkill < Constants.MIN_PLAYING_SKILL
                || playingSkill > Constants.MAX_PLAYING_SKILL) {
            System.err.println("Playing skill is out of range!");
        } else {
            this.playingSkill = playingSkill;
        }
    }

    /**
     * Return the player's playing position (GK/DF/MF/FW).
     *
     * @return player's playing position
     */
    public PlayingPosition getPlayingPosition() {
        return playingPosition;
    }

    /**
     * Sets the player's playing position (GK/DF/MF/FW).
     *
     * @param playingPosition player's playing position
     */
    public void setPlayingPosition(PlayingPosition playingPosition) {
        if (playingPosition == null) {
            System.err.println("Playing position can't be null!");
        } else {
            this.playingPosition = playingPosition;
        }
    }
}
