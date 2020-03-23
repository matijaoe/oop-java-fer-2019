package zad3;

/**
 *
 * @author Matija
 */
public abstract class Vehicle {

    private String manufacturer;
    private String model;
    private int id;
    private int power;
    private int numberOfPassengers;
    private double regularPrice;

    public Vehicle(String manufacturer, String model, int id, int power,
            int numberOfPassengers, double regularPrice) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.id = id;
        this.power = power;
        this.numberOfPassengers = numberOfPassengers;
        this.regularPrice = regularPrice;
    }

    public abstract double getVipPriceDiscount();

    public double getPrice(boolean isVIP) {
        if (isVIP) {
            return regularPrice * getVipPriceDiscount();
        }
        return regularPrice;
    }
}
