package hr.fer.oop.lab4.exceptions;

/**
 *
 * @author Matija
 */
public class TeamNameNullException extends TeamCreationException {

    public TeamNameNullException() {
        super("Team name can't be null!");
    }

}
