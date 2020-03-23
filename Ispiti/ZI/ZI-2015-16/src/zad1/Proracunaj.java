package zad1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Proracunaj {

    public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException, IOException {
        if (args.length <= 1) {
            throw new IllegalArgumentException();
        }

        List<String> ekstenzije = Arrays.asList(Arrays.copyOfRange(args, 1, args.length));
        MyFileVisitor visitor = new MyFileVisitor(ekstenzije);

        try {
            Files.walkFileTree(Paths.get(args[0]), visitor);
            Files.walkFileTree(Paths.get(args[0]), visitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Ukupna veličina: " + visitor.getSum() / 1024 / 1024 + " MB");
        for (Datoteka d : visitor.getDesetNajvecih()) {
            System.out.println(d.getNaziv() + ": " + d.getVelicina());
        }
    }
}