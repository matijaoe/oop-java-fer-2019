package zad1;

import java.io.*;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class MainLogic {
    public static void main(String[] args) {
        List<Car> listOfCars = new LinkedList<Car>();
        String filename = "/Archive.zip";

        //otvaranje .zip datoteke
        try (ZipFile zip = new ZipFile(filename)) {
            Enumeration<? extends ZipEntry> entries = zip.entries();

            ////iteriranje elementima u zip datoteci i pronalazak tekstualnih datoteka
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();

                if (entry.toString().endsWith(".txt")) {
                    //stvaranje InputStream-a nad tekstualnom datotekom
                    try (InputStream stream = zip.getInputStream(entry)) {
                        BufferedReader br = new BufferedReader(new InputStreamReader(new
                                BufferedInputStream(stream), "UTF-8"));
                        //stvaranje instanci klase Car
                        while (true) {
                            String line = br.readLine();
                            if (line == null || line.trim().isEmpty()) break;
                            String[] parts = line.split(";");

                            Car car = new Car(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), parts[4], Integer.parseInt(parts[5]), Double.parseDouble(parts[6]));
                            listOfCars.add(car);
                        }

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            Writer bw = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(new
                    FileOutputStream("/izvjestaj.txt")), "UTF-8"));

            List<String> manufacturers = new LinkedList<>();
            listOfCars.stream().
                    map(Car::getManufacturer).
                    distinct().
                    forEach(manufacturers::add);

            //ispis broja automobila po proizvođaču u datoteku
            for (String m : manufacturers) {
                long count = listOfCars.stream().
                        filter(car -> car.getManufacturer().equals(m)).
                        count();

                bw.write(m + " : " + count + "\n");
            }


            bw.write(Double.toString(
                    listOfCars.stream().
                            filter(k -> k.getYearOfManufacture() < 2015).
                            mapToDouble(Car::getGasConsumption).
                            average().
                            getAsDouble()));

            bw.close();


        } catch (IOException e) {
        }
    }
}

