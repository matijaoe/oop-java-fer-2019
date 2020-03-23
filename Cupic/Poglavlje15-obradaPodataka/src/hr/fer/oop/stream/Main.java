package hr.fer.oop.stream;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        /*Stream.of("Zagreb", "Osijek", "Krizevci")
                .filter(grad -> {
                    System.out.println("Ispitujem grad " + grad);
                    return grad.length() <= 6;
                });
                //.forEach(t -> System.out.println(t));*/

        Stream.of("1000", "50", "504", "125", "17", "217", "603")
                .filter(s -> {
                    System.out.println("Prvi filter: " + s);
                    return s.length() < 4;
                })
                .map(s -> {
                    System.out.println("Mapiranje " + s);
                    return Integer.valueOf(s);
                })
                .sorted((n1, n2) -> {
                    System.out.format("Komparator: (%d,%d)\n", n1, n2);
                    return n1.compareTo(n2);
                })
                .filter(b -> {
                    System.out.println("Drugi filter " + b);
                    return b < 200;
                })
                .forEachOrdered(System.out::println);
    }

}
