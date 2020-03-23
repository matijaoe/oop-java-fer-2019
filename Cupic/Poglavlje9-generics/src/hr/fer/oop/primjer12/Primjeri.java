package hr.fer.oop.primjer12;

public class Primjeri {

    public static void main(String[] args) {

        KeyValue<Integer, Integer> kvadrat = new Square(4);
        System.out.format(
                "%d^2 = %d\n",
                kvadrat.getKey(),
                kvadrat.getValue());
    }

    KeyValue<Integer, String> posta = new Pair<>(10000, "Zagreb");
    KeyValue<String, String> suprug = new Pair<>("Jasna", "Ivo");
}
