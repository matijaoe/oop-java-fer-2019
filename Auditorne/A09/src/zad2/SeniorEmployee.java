package zad2;

import java.util.function.Predicate;

public class SeniorEmployee implements Predicate<Employee> {

    @Override
    public boolean test(Employee t) {
        return t.getSalary() >= 80000;
    }
}