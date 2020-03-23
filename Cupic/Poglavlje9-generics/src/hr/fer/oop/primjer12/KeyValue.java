package hr.fer.oop.primjer12;

public interface KeyValue<K, V> {

    public K getKey();

    public V getValue();

    public void setValue(V value);

}
