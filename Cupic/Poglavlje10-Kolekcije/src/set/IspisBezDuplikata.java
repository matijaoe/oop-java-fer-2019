package set;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class IspisBezDuplikata {

    public static void main(String[] args) {

        System.out.println("Prvi pokušaj:");
        System.out.println("--------------");
        ispisi(ukloni1(args));

        System.out.println("Drugi pokušaj:");
        System.out.println("--------------");
        ispisi(ukloni2(args));

        System.out.println("Treci pokušaj:");
        System.out.println("--------------");
        ispisi(ukloni3(args));

    }

    private static Collection<String> ukloni1(String[] args) {
        return napuniSkup(args, new HashSet<String>());
    }

    private static Collection<String> ukloni2(String[] args) {
        return napuniSkup(args, new TreeSet<String>());
    }

    private static Collection<String> ukloni3(String[] args) {
        return napuniSkup(args, new LinkedHashSet<String>());
    }

    private static Set<String> napuniSkup(String[] args, Set<String> set) {
        for (String s : args) {
            set.add(s);
        }
        return set;
    }

    public static void ispisi(Collection<String> kolekcija) {
        for (String s : kolekcija) {
            System.out.println(s);
        }
    }
}
