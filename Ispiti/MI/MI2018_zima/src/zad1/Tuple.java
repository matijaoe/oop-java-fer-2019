package zad1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matija
 */
public class Tuple<T> {

    private List<T> tuple;

    public Tuple(T... values) {
        tuple = new ArrayList<T>(values.length);

        for (T t : values) {
            tuple.add(t);
        }
    }

    public Tuple(int dimension) {
        tuple = new ArrayList<T>(dimension);
        for (int i = 0; i < dimension; i++) {
            tuple.add(null);
        }

    }

    public T get(int index) {
        return tuple.get(index);
    }

    public void set(int index, T value) {
        if (index < tuple.size()) {
            tuple.set(index, value);
        }

    }

    public int len() {
        return tuple.size();
    }

}
