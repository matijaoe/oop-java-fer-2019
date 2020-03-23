package zad1;

class Car {
    private String manufacturer;
    private String model;
    private int yearOfManufacture;
    private int numberOfKilometers;
    private String color;
    private int horsepower;
    private double gasConsumption;


    public Car(String manufacturer, String model, int yearOfManufacture, int numberOfKilometers,
               String color, int horsepower, double gasConsumption) {

    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public int getNumberOfKilometers() {
        return numberOfKilometers;
    }

    public String getColor() {
        return color;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public double getGasConsumption() {
        return gasConsumption;
    }
}
