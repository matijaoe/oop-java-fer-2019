package zad1;

/**
 *
 * @author Matija
 */
public class DoubleTuple extends Tuple<Double> {

    private Double[] tuple;

    public DoubleTuple(Double... values) {
        super(values);
    }

    public DoubleTuple(int dimension) {
        super(dimension);
    }

    public void multiplyWith(int n) {
        for (int i = 0; i < this.len(); i++) {
            double newValue = this.get(i) * 2;
            this.set(i, newValue);
        }
    }

    public static Tuple<Double> avg(Tuple<? extends Number> first, Tuple<? extends Number> second) {
        Tuple<Double> averageT = new Tuple<>(first.len());

        for (int i = 0; i < first.len(); i++) {

            double sum = first.get(i).doubleValue() + second.get(i).doubleValue();;
            double avg = sum / 2;

            averageT.set(i, avg);
        }
        return averageT;
    }

}
