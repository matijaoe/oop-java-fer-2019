package zad2;

import java.util.Comparator;
import java.util.Objects;

class Car {
    private String manufacturer;
    private String model;
    private String id;
    private float power;
    Politician owner;

    // TO DO Ovdje napisati zasebne komparatore po atributima id, manufacturer i owner. Pri tome koristite lambda izraze!
    public Car(String manufacturer, String model, String id, float power,
               Politician owner) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.id = id;
        this.power = power;
        this.owner = owner;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Car)) return false;
        Car other = (Car) o;
        return Objects.equals(this.id, other.getId());
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public static final Comparator<Car> BY_MANUFACTURER = ((o1, o2) -> o1.getManufacturer().compareTo(o2.getManufacturer()));
    public static final Comparator<Car> BY_ID = ((o1, o2) -> o1.getId().compareTo(o2.getId()));
    public static final Comparator<Car> BY_OWNER = (Comparator.comparing(Car::getOwner));

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getId() {
        return id;
    }

    public float getPower() {
        return power;
    }

    public Politician getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", id='" + id + '\'' +
                ", power=" + power +
                ", owner=" + owner +
                '}';
    }
}
