package hr.fer.oop.practice.z2_generics;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class StringReadingConverter {

    public static Collection<TypedSensorReading<String>> convert(Collection<RawSensorReading> readings) {

        List<TypedSensorReading<String>> result = new LinkedList<>();

        for (RawSensorReading reading : readings) {
            if (reading.getReadingType().equals("String")) {
                result.add(new TypedSensorReading<>(
                        reading.getMeasurementType(),
                        reading.getMeasurementUnit(),
                        reading.getReadingValue()));
            }
        }

        return result;
    }
}
