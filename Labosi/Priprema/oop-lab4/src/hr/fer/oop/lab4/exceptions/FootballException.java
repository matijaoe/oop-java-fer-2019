package hr.fer.oop.lab4.exceptions;

/**
 *
 * @author Matija
 */
public class FootballException extends RuntimeException {

    public FootballException() {
        super("Error in project");
    }

    public FootballException(String message) {
        super(message);
    }

}
