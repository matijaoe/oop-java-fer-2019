package hr.fer.oop;

/**
 *
 * @author Matija
 */
public class NumberNotEvenException extends IllegalArgumentException {

    private static final long serialBersionUID = 1L;

    public NumberNotEvenException() {
    }

    public NumberNotEvenException(String message) {
        super(message);
    }

    public NumberNotEvenException(Throwable cause) {
        super(cause);
    }

    public NumberNotEvenException(String message, Throwable cause) {
        super(message, cause);
    }

}
