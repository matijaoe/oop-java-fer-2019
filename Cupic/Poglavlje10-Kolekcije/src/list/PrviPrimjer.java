package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Matija
 */
public class PrviPrimjer {

    public static void main(String[] args) {

        List<String> lista = new ArrayList<>();
        lista.add("Ivo");
        lista.add("Ana");
        lista.add("Pero");
        lista.add("Ivana");
        System.out.println(lista); // [Ivo, Ana, Pero, Ivana]

        Set<String> slova = new HashSet<>(Arrays.asList("A", "B"));

        lista.addAll(slova);
        System.out.println(lista); // [Ivo, Ana, Pero, Ivana, A, B]

        lista.addAll(2, slova);
        System.out.println(lista); // [Ivo, Ana, A, B, Pero, Ivana, A, B]

        //lista.replaceAll(t -> t.toUpperCase()); // lambda
        lista.replaceAll(String::toUpperCase);
        System.out.println(lista); // [IVO, ANA, A, B, PERO, IVANA, A, B]

        Comparator<String> comp = String::compareTo;

        lista.sort(comp);
        System.out.println(lista); // [A, A, ANA, B, B, IVANA, IVO, PERO]

        lista.sort(comp.reversed());
        System.out.println(lista); // [PERO, IVO, IVANA, B, B, ANA, A, A]

        lista.sort(null); // prirodan poredak, za stringove je abecedno default
        System.out.println(lista); // [A, A, ANA, B, B, IVANA, IVO, PERO]

        List<String> dio = lista.subList(2, 6);
        System.out.println(dio.get(0)); // ANA
        System.out.println(dio); // [ANA, B, B, IVANA]

        dio.clear(); // modifikacije podliste mijenja i originalnu listu!! Maknuli se elementi podliste iz glavne liste.
        System.out.println(lista); // [A, A, IVO, PERO]
        System.out.println(dio); // []

    }
}
