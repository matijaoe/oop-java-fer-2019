package zad4;

/**
 *
 * @author Matija
 */
public class Tuple<K, V> {

    private K e1;
    private V e2;

    public Tuple(K e1, V e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public K getE1() {
        return e1;
    }

    public V getE2() {
        return e2;
    }

}
