package set;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Matija
 */
public class FiltriranaImena {

    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            System.out.println("Očekivao sam imena dvaju datoteka!");
            return;
        }

        Collection<String> retci1 = Files.readAllLines(
                Paths.get(args[0]), StandardCharsets.UTF_8);
        Collection<String> retci2 = Files.readAllLines(
                Paths.get(args[1]), StandardCharsets.UTF_8);

        Set<String> prvi = new HashSet<>(retci1);
        Set<String> drugi = new HashSet<>(retci2);

        prvi.removeAll(drugi);

//        prvi.forEach((t) -> {
//            System.out.println(t);
//        });
        for (String ime : prvi) {
            System.out.println(ime);
        }
    }

}
