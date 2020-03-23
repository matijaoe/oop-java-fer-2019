package zad3;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Matija
 */
public class Main {

    public static void main(String[] args) {

        Set<Vehicle> vehicles = new HashSet<>();
        vehicles = DBLoader.loadVehicles();

        double sum = 0;

        for (Vehichle vehicle : vehicles) {
            if (vehicle instanceof Rentable) {
                sum += ((Rentable) vehicle).getRentingPrice();
            }
        }

        System.out.println(total != 0
                ? "Total price is:" + total
                : "No rentable vehicles with set renting prices found");

    }
}
