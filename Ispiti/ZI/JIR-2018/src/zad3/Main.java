package zad3;

import java.io.IOException;
import java.nio.file.*;
import java.util.OptionalDouble;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter directory:");
            String dirName = sc.nextLine();
            Path path = Paths.get(dirName);

            //TODO: dopisati tip za varijablu visitor (obratiti pažnju na ostatak koda)
            MyFileVisitor visitor = new MyFileVisitor();

            //TODO: Pokreniti file visitor (ne morate pisati hvatanje IOExceptiona)
            Files.walkFileTree(path, visitor);


            //TODO: dovršiti tako da ispiše imena i broj brojeva u posjećenim *.java datotekama
            visitor.getMap().entrySet().stream().
                    forEach(entry -> System.out.println(
                            entry.getKey()+ " = "+
                                    entry.getValue() + " brojeva"));


            //TODO: dovršiti tako da ispiše prosječan broj brojeva u datotekama koje u imenu imaju riječ Main
            OptionalDouble optional = visitor.getMap().entrySet().stream().
                    filter(e -> e.getKey().contains("Main")).
                    mapToInt(e -> e.getValue()).
                    average();

            if (optional.isPresent())
                System.out.println("Prosjecan broj brojeva u datotekama koje sadrze rijec Main: " +
                        optional.getAsDouble());
            else
                System.out.println("Ne postoji java datoteka koja sadrzi rijec Main.");
        } catch (IOException e) {
            // do nothing
        }
    }
}


