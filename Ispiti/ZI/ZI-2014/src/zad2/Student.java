package zad2;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Student implements Comparable<Student> {

    private String ime;
    private String prezime;
    private String JMBAG;

    public Student(String ime, String prezime, String JMBAG) {
        this.ime = ime;
        this.prezime = prezime;
        this.JMBAG = JMBAG;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getJMBAG() {
        return JMBAG;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(JMBAG, student.JMBAG);

    }

    @Override
    public int hashCode() {
        return this.getJMBAG().hashCode();
    }


    @Override
    public int compareTo(Student o) {
        return this.getJMBAG().compareTo(o.getJMBAG());
    }

    @Override
    public String toString() {
        return "Student{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", JMBAG='" + JMBAG + '\'' +
                '}';
    }

    public static void main(String[] args) {

        List<Student> lista = Ucitavac.ucitaj();
        Set<Student> studenti = new TreeSet<>(lista);

        lista.forEach(student -> System.out.println(student));
        System.out.println();
        studenti.forEach(student -> System.out.println(student));
        System.out.println();


        List<Integer> duljine = lista.stream().
                filter(s -> (s.getIme().length() + s.getPrezime().length()) > 10).
                map(s -> s.getPrezime().length()).
                collect(Collectors.toList());

        int[] statistika = new int[]{-1, -1, -1};
        duljine.forEach(s -> System.out.println(s));
        System.out.printf("Suma duljina: %d, min duljina: %d, max duljina: %d",
                statistika[0], statistika[1], statistika[2]
        );
    }
}
