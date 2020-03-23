package zad1;

import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Set<Driver> drivers = DBLoader.loadDrivers();
        drivers
                .stream()
                .filter(d -> d.getAddress().equals("France"))
                //.sorted((a,b) -> Long.compare(a.getOib(), b.getOib()))
                .sorted(Comparator.comparing(Driver::getOib))
                .forEach(d -> System.out.println(d));


        Set<Long> oibs = drivers
                .stream()
                .filter(d -> d.getSurname().startsWith("G"))
                .map(Driver::getOib)
                .collect(Collectors.toSet());

        System.out.println(oibs);

        drivers
                .stream()
                .mapToInt(d -> d.getFirstname().length())
                .average()
                .ifPresentOrElse(
                        avg -> System.out.println(avg),
                        () -> System.out.println("No value"));
    }
}


