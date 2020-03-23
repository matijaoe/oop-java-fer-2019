package zad2;

import java.util.Collections;
import java.util.List;

import static zad2.Car.*;

class Program {
    public static void main(String[] args) {

        List<Politician> politicians = DBLoader.loadPoliticians();
        List<Car> cars = DBLoader.loadCars();

        Collections.sort(politicians);

        for (Politician politician : politicians) {
            System.out.println(politician.toString());
        }
        System.out.println();



        cars.sort(BY_ID);
        //Collections.sort(cars, BY_ID);
        cars.forEach(car -> System.out.println(car));
        System.out.println();

        cars.sort(BY_MANUFACTURER.reversed().thenComparing(BY_OWNER));
        cars.forEach(car -> System.out.println(car));



    }
}
