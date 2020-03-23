package hr.fer.oop.practice.z2_generics;

public class TypedSensorReading<T> implements SensorReading {

    private String measurementType;
    private String measurementUnit;
    private T readingValue;

    public TypedSensorReading(String measurementType, String measurementUnit, T readingValue) {
        this.measurementType = measurementType;
        this.measurementUnit = measurementUnit;
        this.readingValue = readingValue;
    }

    @Override
    public String getMeasurementType() {
        return measurementType;
    }

    @Override
    public String getMeasurementUnit() {
        return measurementUnit;
    }

    @Override
    public T getReadingValue() {
        return readingValue;
    }

}
