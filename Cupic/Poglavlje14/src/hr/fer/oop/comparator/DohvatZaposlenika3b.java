package hr.fer.oop.comparator;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

@SuppressWarnings("Duplicates")
public class DohvatZaposlenika3b {

    public static class UsporedbaPoSiframaRev implements Comparator<Zaposlenik> {

        @Override
        public int compare(Zaposlenik o1, Zaposlenik o2) {
            // reverse sorted
            return -o1.getSifra().compareTo(o2.getSifra());
        }
    }


    public static void main(String[] args) {

        Set<Zaposlenik> set = new TreeSet<>(new UsporedbaPoSiframaRev());

        Zaposlenik prvi = new Zaposlenik("1", "Pero", "Perić");
        set.add(prvi);
        set.add(new Zaposlenik("2", "Agata", "Agić"));
        set.add(new Zaposlenik("3", "Ivana", "Ivić"));

        for (Zaposlenik zaposlenik : set) {
            System.out.println(zaposlenik);
        }
        System.out.println();

        Zaposlenik trazeni = new Zaposlenik("1", "Pero", "Perić");

        boolean postoji = set.contains(trazeni);
        System.out.println("Zaposlenik " + trazeni + " postoji: " + postoji);


    }
}
