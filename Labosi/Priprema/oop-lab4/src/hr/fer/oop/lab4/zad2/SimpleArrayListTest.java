package hr.fer.oop.lab4.zad2;

public class SimpleArrayListTest {

    public static void main(String[] args) {

        SimpleArrayList<Integer> integerList = new SimpleArrayList<>();
        SimpleArrayList<Double> doubleList = new SimpleArrayList<>();

        integerList.add(4);
        integerList.add(null); // false
        integerList.add(54);

        doubleList.add(1.2);
        doubleList.add(12.55);
        doubleList.add(9.);

        System.out.println("\nInteger list:");
        for (int i = 0; i < integerList.size(); i++) {
            System.out.println("\t" + integerList.get(i));
        }

        System.out.println("\nDouble List:");
        for (int i = 0; i < doubleList.size(); i++) {
            System.out.println("\t" + doubleList.get(i));
        }
    }

}
