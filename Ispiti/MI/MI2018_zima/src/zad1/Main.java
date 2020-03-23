package zad1;

/**
 *
 * @author Matija
 */
public class Main {

    public static void main(String[] args) {

        Tuple<String> tuple = new Tuple<>("a", "b", "c");
        System.out.println(tuple.toString()); // ispisuje (a, b, c)

        Tuple<Integer> t1 = new Tuple<>(4); //n-torka s 4 elementa
        t1.set(2, 1);
        t1.set(3, 4);
        t1.set(0, 5);
        t1.set(1, 3);
        System.out.println(t1.len()); // prints 4
        System.out.println(t1.get(1)); // prints 3
        System.out.println(t1.toString()); // ispisuje (5, 3, 1, 4)

        DoubleTuple t2 = new DoubleTuple(2.5, 3.0, 1.25, 1.5);

        t2.multiplyWith(2);
        System.out.println(t2.toString()); // ispisuje (5.0, 6.0, 2.5, 3.0)

        Tuple<Double> avg = DoubleTuple.avg(t1, t2);
        System.out.println(avg.toString()); // ispisuje (5.0, 4.5, 1.75, 3.5)
    }
}
