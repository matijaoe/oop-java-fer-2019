package zad1;

/**
 *
 * @author Matija
 */
class KeyValue<K, V> {

    private K key;
    private V value;

    public KeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

}

class SingleTypeKeyValue<T> extends KeyValue<T, T> {

    private T keyS, valueS;

    public SingleTypeKeyValue(T keyS, T valueS) {
        super(keyS, valueS);
    }

    public T getKeyS() {
        return keyS;
    }

    public void setKeyS(T keyS) {
        this.keyS = keyS;
    }

    public T getValueS() {
        return valueS;
    }

    public void setValueS(T valueS) {
        this.valueS = valueS;
    }

}

class XY<Double> extends SingleTypeKeyValue<Double> {

    private Double key, value;

    public XY(Double keyS, Double valueS) {
        super(keyS, valueS);
    }

    public Double getKeyS() {
        return key;
    }

    public Double getValueS() {
        return value;
    }

    /*public static boolean isIncreasingFunction(XY[] data) {
        XY[] sortedData = new XY[data.length];

        if (data.length != 2) {
            return true;
        }

        boolean increasing = true;
        for (int i = 1; i < data.length; i++) {
            if (data[i].value > data[i - 1].value) {
                increasing = true;
            } else {
                increasing = false;
            }
        }
        return true;

    }*/

}
