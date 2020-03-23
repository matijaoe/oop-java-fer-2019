package triple;

/**
 *
 * @author Matija
 */
class Triple<T> {

    private T a, b, c;

    public Triple(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public T getElement(int index) {
        switch (index) {
            case 1:
                return this.a;
            case 2:
                return this.b;
            case 3:
                return this.c;
            default:
                throw new IllegalArgumentException();
        }

    }

    public T setElement(int index, T value) {
        switch (index) {
            case 1:
                this.a = value;
            case 2:
                this.a = value;
            case 3:
                this.c = value;
            default:
                throw new IllegalArgumentException();
        }
    }

}
