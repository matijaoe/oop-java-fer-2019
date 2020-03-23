package hr.fer.oop.primjer12;

/**
 *
 * @author Matija
 */
public class Pair<K, V> implements KeyValue<K, V> {

    private K key;
    private V value;

    public Pair(K key, V value) {
        super();
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public void setValue(V value) {
        this.value = value;
    }

}
