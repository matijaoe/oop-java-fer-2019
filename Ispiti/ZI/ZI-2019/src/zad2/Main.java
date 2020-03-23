package zad2;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        List<Student> dataset = DBLoader.loadStudents();
        // Pozivom metode printStudents ispišite sve studente koji imaju prosjek veći od 3.5
        // (u pozivu morate koristiti primjerak objekta koji pripada anonimno razredu)
        printStudents(dataset,
                new Predicate<Student>() {
                    @Override
                    public boolean test(Student student) {
                        return student.getAvgGrade() > 3.5;
                    }
                });

        // Poziv metode firstAndLastStudent s vanjskim komparatorom koji je
        // definiran po atributu avgGrade u klasi Student s akcijom koja je
        // definirana u metodi printPair.
                firstAndLastStudent (dataset, Student.BY_AVG_GRADE,
                        (s1, s2) -> printPair(s1, s2));



        // Definirajte i kreirajte BiConsumer koji ispisuje apsolutnu vrijednost
        // razlike prosjecnih ocjena dvaju studentana kao Diff=x.xx
        BiConsumer<Student, Student> consumer = (s1, s2) ->
                System.out.println("Diff: \t" + Math.abs(s1.getAvgGrade()-s2.getAvgGrade()) + "\n");



        firstAndLastStudent(dataset, Student.BY_AVG_GRADE.reversed(), consumer);

    }



    public static void printStudents(Iterable<Student> students, Predicate<Student> predicate) {
        for (Student s: students) {
            if (predicate.test(s)) {
                System.out.println(s.toString());
            }
        }
    }
    public static void printPair(Student first, Student last) {
        System.out.format("First and last student: %n\t%s%n\t%s%n", first, last);
    }

    // Definirajte metodu firstAndLastStudent u kojoj se na temelju komparatora
    // comparator dolazi do prvog i posljednjeg studenta medu studentima te se nad
    // prvim i posljednjim izvodi akcija action
    public static void firstAndLastStudent(Iterable<Student> students, Comparator<Student>
            comparator, BiConsumer<Student, Student> action) {
        SortedSet<Student> set = new TreeSet<>(comparator);
        for (Student s : students) {
            set.add(s);
        }
        Student s1 = set.first();
        Student s2 = set.last();
        action.accept(s1, s2);
        return;
    }
}

