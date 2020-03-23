package hr.fer.oop.lab4.exceptions;

/**
 *
 * @author Matija
 */
public class TeamFormationNullException extends TeamCreationException {

    public TeamFormationNullException() {
        super("Team formation can't be null!");
    }
}
