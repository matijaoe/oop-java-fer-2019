package hr.fer.oop.primjer12;

public class Square implements KeyValue<Integer, Integer> {

    private Integer n;

    public Square(Integer n) {
        super();
        this.n = n;
    }

    @Override
    public Integer getKey() {
        return n;
    }

    @Override
    public Integer getValue() {
        return n * n;
    }

    @Override
    public void setValue(Integer value) {
        throw new UnsupportedOperationException("Square is read-only.");

    }
}
