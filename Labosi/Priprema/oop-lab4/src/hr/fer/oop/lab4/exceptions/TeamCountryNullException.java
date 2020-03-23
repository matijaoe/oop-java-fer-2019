package hr.fer.oop.lab4.exceptions;

/**
 *
 * @author Matija
 */
public class TeamCountryNullException extends TeamCreationException {

    public TeamCountryNullException() {
        super("Team country can't be null!");
    }

}
