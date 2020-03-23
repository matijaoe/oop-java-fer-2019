package zad1;

import java.util.HashSet;
import java.util.Set;

public class DBLoader {


    public static Set<Driver> loadDrivers() {
        Set<Driver> drivers = new HashSet<>();
        drivers.add(new Driver("Josip", "Valenčić", "Croatia", 2345));
        drivers.add(new Driver("Leo", "Mbappe", "France", 45453));
        drivers.add(new Driver("Jaques", "Griezzman", "France", 46793));
        drivers.add(new Driver("Franck", "Lenglet", "France", 14444));
        drivers.add(new Driver("Mitja", "Kekeđ", "Slovenia", 50001));
        return drivers;
    }
}
