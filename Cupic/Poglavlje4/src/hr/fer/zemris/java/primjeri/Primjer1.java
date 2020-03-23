package hr.fer.zemris.java.primjeri;

public class Primjer1 {

    public static void main(String[] args) {
        System.out.println(Matematika.kaoTekst('[', ']', 1, 4, 8.2, 13.1));
        System.out.println(Matematika.kaoTekst('[', ']', 3.3));
        System.out.println(Matematika.kaoTekst('[', ']'));

        System.out.println(Matematika.kaoTekst(1, 4, 8.2, 13.1));

        System.out.println("Suma je: " + Matematika.suma(2, 4, 12));
    }
}
