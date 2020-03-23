package hr.fer.oop.practice.z2_generics;

public class RawSensorReading implements SensorReading {

    private String measurementType;
    private String measurementUnit;
    private String readingType;
    private String readingValue;

    public RawSensorReading(String measurementType, String measurementUnit,
            String readingType, String readingValue) {
        this.measurementType = measurementType;
        this.measurementUnit = measurementUnit;
        this.readingType = readingType;
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

    public String getReadingType() {
        return readingType;
    }

    @Override
    public String getReadingValue() {
        return readingValue;
    }

}
