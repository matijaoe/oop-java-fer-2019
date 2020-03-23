package hr.fer.oop.lab4.exceptions;

/**
 *
 * @author Matija
 */
public class FootballPlayerEmotionException extends FootballPlayerCreationException {

    public FootballPlayerEmotionException(String message, int minEm, int maxEm) {
        super(message + " " + minEm + " - " + maxEm);

    }

}
