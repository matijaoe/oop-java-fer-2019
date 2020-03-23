package zad2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class EmployeeMain {

    public static void main(String[] args) {

        List<Employee> staff = new ArrayList();
        BufferedReader br;

        try {
            br = new BufferedReader(new InputStreamReader(new BufferedInputStream(new
                    FileInputStream("data.txt")), "UTF-8"));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                String[] inputData = strLine.split(";");
                staff.add(new Employee(inputData[0], Double.parseDouble(inputData[1]),
                        Integer.parseInt(inputData[2]), Integer.parseInt(inputData[3]), Integer.parseInt(inputData[4])));
            }
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }

        EmployeeMain.printEmployees(staff, new JuniorEmployee());
        EmployeeMain.printEmployees(staff, new SeniorEmployee());

        // raise everyone's salary by 15%
        staff.forEach((e) -> {
            e.raiseSalary(15);
        });

        //SeniorEmployee
        EmployeeMain.printEmployees(staff, new Predicate<Employee>() {
            @Override
            public boolean test(Employee t) {
                return t.getSalary() >= 80000;
            }
        });

        //JuniorEmployee
        EmployeeMain.printEmployees(staff, t -> t.getSalary() < 80000);

        //theMostSimilarEmployees
        theMostSimilarEmployees(staff,
                (a, b) -> (int) (Math.abs(a.getHireDay().toEpochDay() -
                        b.getHireDay().toEpochDay())),
                (a, b) -> System.out.format("The most employees are: %n\t%s%n\t%s%n", a, b)
        );
    }

    private static void printEmployees(Iterable<Employee> employees, Predicate<Employee>
            predicate) {
        for (Employee employee : employees) {
            if (predicate.test(employee)) {
        // print out information about all Employee objects
                System.out.println(employee);
            }
        }
    }

    public static void theMostSimilarEmployees(Iterable<Employee> employees, BiFunction<Employee,
                Employee, Integer> similarity, BiConsumer<Employee, Employee> action) {

        class EmployeePair {

            public Employee first, second;

            public EmployeePair(Employee first, Employee second) {
                this.first = first;
                this.second = second;
            }
        }

        EmployeePair pair = null;
        int min = Integer.MAX_VALUE;

        for (Employee first : employees) {
            for (Employee second : employees) {
                if (first == second) {
                    continue;
                }

                if (pair == null || similarity.apply(first, second) < min) {
                    pair = new EmployeePair(first, second);
                    min = similarity.apply(first, second);
                }
            }
        }

        if (pair != null) {
            action.accept(pair.first, pair.second);
        }
    }
}
