package zad3;

/**
 *
 * @author Matija
 */
public class Car extends Vehicle implements Rentable {

    private boolean hasAC;
    private int numberOfDoors;
    private double rentingPrice;

    private static final double VIP_DISCOUNT_PERCENT = 0.90;

    public Car(String manufacturer, String model, int id,
            int power, int numberOfPassengers, double regularPrice,
            boolean hasAC, int numberOfDoors) {
        super(manufacturer, model, id, power, numberOfPassengers, regularPrice);
        this.hasAC = hasAC;
        this.numberOfDoors = numberOfDoors;
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
