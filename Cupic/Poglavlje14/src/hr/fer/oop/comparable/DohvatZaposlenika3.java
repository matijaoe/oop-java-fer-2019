package hr.fer.oop.comparable;


import java.util.Set;
import java.util.TreeSet;

@SuppressWarnings("Duplicates")
public class DohvatZaposlenika3 {

    public static void main(String[] args) {

        Set<Zaposlenik> set = new TreeSet<>();

        Zaposlenik prvi = new Zaposlenik("1", "Pero", "Perić");
        set.add(prvi);
        set.add(new Zaposlenik("2", "Agata", "Agić"));
        set.add(new Zaposlenik("3", "Ivana", "Ivić"));

        for (Zaposlenik zaposlenik : set) {
            System.out.println(zaposlenik);
        }
        System.out.println();

        Zaposlenik trazeni = new Zaposlenik("1", "Pero", "Perić");

        boolean postoji = set.contains(prvi);
        System.out.println("Zaposlenik " + prvi + " postoji: " + postoji);

        postoji = set.contains(trazeni);
        System.out.println("Zaposlenik " + trazeni + " postoji: " + postoji);


    }
}
