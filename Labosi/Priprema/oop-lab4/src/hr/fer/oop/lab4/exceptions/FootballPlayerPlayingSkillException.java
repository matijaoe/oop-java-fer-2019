package hr.fer.oop.lab4.exceptions;

/**
 *
 * @author Matija
 */
public class FootballPlayerPlayingSkillException extends FootballPlayerCreationException {

    public FootballPlayerPlayingSkillException(String message, int minSkill, int maxSkill) {
        super(message + " " + minSkill + " - " + maxSkill);

    }

}
