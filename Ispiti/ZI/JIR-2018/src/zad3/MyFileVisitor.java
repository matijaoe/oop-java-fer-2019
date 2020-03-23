package zad3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Map;

import static java.nio.file.Files.readAllLines;
import static zad3.NumberCounter.countNumbers;

public class MyFileVisitor extends SimpleFileVisitor<Path> {

    private List<String> lines;
    private Map<String , Integer> map;

    //TO DO: Dopisati ostatak
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) throws IOException {
        if (file.toString().toLowerCase().endsWith(".java")) {
            lines = readAllLines(file);
            int numberCount = countNumbers(lines);
            map.put(file.toString(), numberCount);
        }

        return FileVisitResult.CONTINUE;

    }

    public Map<String, Integer> getMap() {
        return map;
    }
}
