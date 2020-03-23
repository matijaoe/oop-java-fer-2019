package zad2;

import zad2.Car.CarLight;

/**
 *
 * @author Matija
 */
public class Main {

    public static void main(String[] args) {
        Car fiat = new Car("Fiat");
        Car skoda = new Car("Skoda");
        Part fiatLight = fiat.createLight(126985);
        Part skodaLight = skoda.createLight(439580);
        fiatLight.powerUp();
        skodaLight.powerUp();
        display(fiatLight);
        display(skodaLight);
    }

    private static void display(Part part) {
        System.out.println(part.toString() + ": "
                + ((CarLight) part).getLightsOn());
    }
}
