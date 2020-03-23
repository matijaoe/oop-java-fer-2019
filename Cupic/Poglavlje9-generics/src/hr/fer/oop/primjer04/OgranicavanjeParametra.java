package hr.fer.oop.primjer04;

public class OgranicavanjeParametra {

    public static void main(String[] args) {

        Number n = veci(Integer.valueOf(2), Integer.valueOf(5));
        Integer n2 = veci(Integer.valueOf(2), Integer.valueOf(5));

        //moze se pohraniti u Number, ali ne moze u specificni tip
        // posto su argumenti razlicog tipa, oba se pretvaraju u Number, vraca
        // Number i zato se moze pohraniti samo iskljucivo u Number varijablu
        Number n3 = veci(Integer.valueOf(2), Long.valueOf(5));
        //Integer n4 = veci(Integer.valueOf(2), Long.valueOf(5));
        //Long n5 = veci(Integer.valueOf(2), Long.valueOf(5));;
        Comparable<?> n6 = veci(Integer.valueOf(2), Long.valueOf(5));
        // ovo radi jer oboje integer i long implementiraju paramtrizirano sucelje
        // java.lang.Comparable pa ce T bit vezan na Number&Comparable<?>
    }

    public static <T extends Number> T veci(T n1, T n2) {
        return n1.doubleValue() >= n2.doubleValue() ? n1 : n2;
    }
}
