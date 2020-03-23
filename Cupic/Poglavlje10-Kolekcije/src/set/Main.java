package set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Matija
 */
public class Main {

    public static void main(String[] args) {

        String[] imena = new String[]{"Josip", "Andrej", "Karlo", "Marin", "Andrej", "Matej"};

        Collection<String> list = new ArrayList<String>(Arrays.asList(imena));

        for (String ime : list) {
            System.out.println(ime);
        }

        System.out.println();

        //Collection<String> set = new HashSet<>(Arrays.asList(imena));
        Set<String> set = new HashSet<String>(list);

        set.forEach((name) -> {
            System.out.println(name);
        });

//        HashSet<Integer> set1 = new HashSet();
//        set1.add(5);
//        set1.add(15);
//        set1.add(35);
//        set1.add(1);
//        set1.add(-4);
//        System.out.println(set1);
//        TreeSet<Integer> set2 = new TreeSet<>(set1);
//        System.out.println(set2);
//        System.out.println(set1);
    }

}
