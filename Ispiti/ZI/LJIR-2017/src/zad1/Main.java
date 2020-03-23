package zad1;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {

        int counter = 0;
        List<Stavka> lista = new ArrayList<>();

        Path file = Path.of("racun.txt");

        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new BufferedInputStream(
                                new FileInputStream("racun.txt")),
                        "UTF-8"));

        String line;
        while((line = br.readLine()) != null) {
            if (counter == 0) {
                counter++;
                continue;
            }
            String[] stavkaLine = line.split(",");
            lista.add(new Stavka(stavkaLine[0], Double.parseDouble(stavkaLine[1]),
                    Integer.parseInt(stavkaLine[2]), Double.parseDouble(stavkaLine[3])));
        }


        // a

        final Comparator<Stavka> FULL_PRICE = (s1,s2) ->
                (s1.jedinicnaCijena * s1.kolicina) - (s2.jedinicnaCijena * s2.kolicina) > 0 ? 1 : -1;


        System.out.println("Stavke s PDV-om vecim od 10% (sortirano prema ukupnoj " +
                "cijeni stavke, od najvece prema najmanjoj):");
        lista.stream().
                filter(s -> s.getPdv() > 0.1).
                sorted(FULL_PRICE.reversed()).
                map(s -> s.getNaziv().toUpperCase()).
                forEach(System.out::println);

        System.out.println("\nProsjecna jedinicna cijena onih stavaka cija kolicina je manja od 5:");
        double avg = lista.stream().
                filter(s -> s.getKolicina() < 5).
                mapToDouble(Stavka::getJedinicnaCijena).
                average().
                getAsDouble();
        System.out.println(avg);

        System.out.println("\nUkupan iznos racuna: ");
        double total = lista.stream().
                mapToDouble(s -> s.getJedinicnaCijena() * s.getKolicina() * 1.25).
                sum();
        System.out.println(total);







    }

}
