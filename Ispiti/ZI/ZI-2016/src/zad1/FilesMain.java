package zad1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FilesMain {

    public static void main(String[] args) {
        if (args.length <= 2) {
            throw new IllegalArgumentException();
        }

        List<String> extensions = Arrays.asList(
                Arrays.copyOfRange(args, 2, args.length));
        MyFileVisitor visitor = new MyFileVisitor(args[1], extensions);

        try {
            Files.walkFileTree(Paths.get(args[0]), visitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Broj datoteka za svaku traženu ekstenziju:" +
                visitor.toString());
    }
}