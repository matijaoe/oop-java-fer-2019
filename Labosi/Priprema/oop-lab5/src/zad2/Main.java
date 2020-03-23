package zad2;

public class Main {

    public static void main(String[] args) {

        MyNumber number = new MyNumber(123);
        for (Integer i : number) {
            System.out.format(" %d", i);
        }
        System.out.println();

        number = new MyNumber(-4781);
        for (Integer i : number) {
            System.out.format(" %d", i);
        }
        System.out.println();


        IntegerSet set = new IntegerSet();
        set.add(157);
        set.add(12345);
        set.add(-3005);

        for (MyNumber numbers : set) {
            System.out.format("Broj %s ima znamenke:", numbers.toString());
            for (Integer i : numbers) {
                System.out.format(" %d", i);
            }
            System.out.println();
        }
    }
}
