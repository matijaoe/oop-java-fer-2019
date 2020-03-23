package zad1;

import java.util.Collection;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        // Tree set se sortira po zadanom komparatoru
        Collection<PoslovniPartner> col = new TreeSet<>( new PoslovniPartnerComparator());

        Osoba o1 = new Osoba("42345678901", "Darko", "Darić");
        Osoba o2 = new Osoba("58855678121", "Bianka", "Banić");
        Osoba o3 = new Osoba("28964789143", "Ivan", "Ivić");
        Osoba o4 = new Osoba("15678842125", "Ante", "Antić");
        Osoba o5 = new Osoba("35678842125", "Mate", "Matić");

        Tvrtka t1 = new Tvrtka("66879845127", "Meho und jaranen");
        Tvrtka t2 = new Tvrtka("45174579172", "Otraj-dotraj");
        Tvrtka t3 = new Tvrtka("25174579172", "Kupi-prodaj");

        t1.getZaposlenici().add(o1);
        t1.getZaposlenici().add(new Osoba("42345678901", "Darko", "Darić"));
        t1.getZaposlenici().add(o1);
        t1.getZaposlenici().add(o4);

        t2.getZaposlenici().add(o3);
        t2.getZaposlenici().add(o2);
        t2.getZaposlenici().add(o1);

        t3.getZaposlenici().add(o2);
        t3.getZaposlenici().add(o3);
        t3.getZaposlenici().add(o4);


        col.add(t1);
        col.add(o5);
        col.add(t2);
        col.add(t3);

        for(PoslovniPartner p : col ){
            System.out.println(p);
        }
    }
}