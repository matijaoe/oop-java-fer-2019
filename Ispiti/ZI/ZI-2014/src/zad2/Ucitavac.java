package zad2;

import java.util.ArrayList;
import java.util.List;

public class Ucitavac {


    public static List<Student> ucitaj() {
        List<Student> lista = new ArrayList<>();
        Student a = new Student("Josip", "Kazo", "9876543210");
        Student b = new Student("Ana-Marija", "Letić", "9845654321");
        Student c = new Student("Marko", "Javorić", "1234564789");
        Student d = new Student("Josip", "Kazo", "9876543210");
        Student e = new Student("Ana", "Rob", "4476543210");
        lista.add(a);
        lista.add(b);
        lista.add(c);
        lista.add(d);
        lista.add(e);

        return lista;

    }
}
