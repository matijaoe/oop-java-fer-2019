package zad1;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyFileVisitor extends SimpleFileVisitor<Path> {
    private List<String> extensions;
    private Map<String, Integer> map;
    private String sequence;

    public MyFileVisitor(String sequence, List<String> extensions) {
        this.extensions = extensions;
        this.sequence = sequence;
        map = new HashMap<>();
        for (String extension : this.extensions) {
            map.put(extension, 0);
        }
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        for (String extension : this.extensions) {
            String filename = file.getFileName().toString();
            if (filename.endsWith(extension) && filename.contains(sequence)) {
                map.put(extension, map.get(extension) + 1);
            }
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public String toString() {
        String s = "\n";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            s += entry.getKey() + " : " + entry.getValue() + "\n";
        }
        return s;
    }
}
