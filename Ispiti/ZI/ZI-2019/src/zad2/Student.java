package zad2;

import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparable<Student> {

    private String jmbag;
    private String firstname;
    private String surname;
    private Double avgGrade;

    public Student(String jmbag, String firstname, String surname, Double avgGrade) {
        this.jmbag = jmbag;
        this.firstname = firstname;
        this.surname = surname;
        this.avgGrade = avgGrade;
    }

    @Override
    public boolean equals (Object o) {
        if (!(o instanceof Student)) {
            return false;
        }
        Student other = (Student) o;
        return Objects.equals(this.jmbag, other.jmbag);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(jmbag);
    }

    @Override
    public int compareTo(Student s) {
        return this.jmbag.compareTo(s.jmbag);
    }

    public static final Comparator<Student> BY_SURNAME =
            (o1, o2) -> o1.surname.compareTo(o2.surname);
    public static final Comparator<Student> BY_AVG_GRADE =
            (o1, o2) -> Double.compare(o1.avgGrade, o2.avgGrade);


    public String getJmbag() {
        return jmbag;
    }

    public void setJmbag(String jmbag) {
        this.jmbag = jmbag;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(Double avgGrade) {
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "Student { " +
                "jmbag='" + jmbag + '\'' +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", avgGrade=" + avgGrade +
                " }";
    }
}
