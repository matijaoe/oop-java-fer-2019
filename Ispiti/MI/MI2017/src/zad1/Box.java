package zad1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Matija
 */
public class Box<T> {

    List<T> box = new ArrayList<T>();

    public void add(T... items) {
        for (T item : items) {
            box.add(item);
        }
    }

    public Collection<T> getItems() {
        return box;
    }
}
