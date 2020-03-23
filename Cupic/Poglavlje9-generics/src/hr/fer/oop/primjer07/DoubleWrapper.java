package hr.fer.oop.primjer07;

public class DoubleWrapper {

    private Double value;

    public DoubleWrapper(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if (value == null) {
            return "";
        }
        return value.toString();
    }
}
