package zad3;

/**
 *
 * @author Matija
 */
public class Truck extends Vehicle {

    private int maxWeight;

    private static final double VIP_DISCOUNT_PERCENT = 0.95;

    public Truck(String manufacturer, String model, int id, int power,
            int numberOfPassengers, double regularPrice, int maxWeight) {
        super(manufacturer, model, id, power, numberOfPassengers, regularPrice);
        this.maxWeight = maxWeight;
    }

    @Override
    public double getVipPriceDiscount() {
        return VIP_DISCOUNT_PERCENT;
    }

}
