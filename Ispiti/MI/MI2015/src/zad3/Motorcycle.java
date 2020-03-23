package zad3;

/**
 *
 * @author Matija
 */
public class Motorcycle extends Vehicle implements Rentable {

    private MotorcycleType type;
    private double rentingPrice;

    private static final double VIP_DISCOUNT_PERCENT = 0.85;

    public Motorcycle(String manufacturer, String model, int id, int power,
            int numberOfPassengers, double regularPrice, MotorcycleType type) {
        super(manufacturer, model, id, power, numberOfPassengers, regularPrice);
        this.type = type;
    }

    @Override
    public double getVipPriceDiscount() {
        return VIP_DISCOUNT_PERCENT;
    }

    @Override
    public void addRentingPrice(double rentingPrice) {
        this.rentingPrice = rentingPrice;
    }

    @Override
    public double getRentingPrice() {
        return this.rentingPrice;
    }

}
