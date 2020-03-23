package predavanje;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        String file = "input.txt";

        Stream<String> lines = Files.lines(Path.of(file), StandardCharsets.UTF_8);

        lines.
                flatMap(line -> Arrays.stream(line.trim().split(" "))).
                flatMap(line -> Arrays.stream(line.trim().split("\t"))).
                map(word -> word.
                        codePoints().
                        filter(Character::isLetter).
                        collect(
                                StringBuilder::new,
                                StringBuilder::appendCodePoint,
                                StringBuilder::append).
                        toString()).
                filter(word -> !word.equals("")).
                map(word -> new AbstractMap.SimpleEntry(word, 1)).
                collect(Collectors.groupingBy(AbstractMap.SimpleEntry::getKey, Collectors.counting())).
                forEach((k, v) -> System.out.println(k + " " + v));
    }
}
