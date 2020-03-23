package zad2;

public class Main {

    public static void main(String[] args) {

        HSElement e1 = new HSElement(53, "Matija");
        HSElement e2 = new HSElement(99, "Joseph");
        HSElement e3 = new HSElement(65, "Mark");
        HSElement e4 = new HSElement(69, "Mark");
        HSElement e5 = new HSElement(77, "Lucy");
        HSElement e6 = new HSElement(115, "Matija");
        HSElement e7 = new HSElement(101, "Eva");
        HSElement e8 = new HSElement(2, "Borna");



        HighScore hs = new HighScore();
        hs.add(e1);
        hs.add(e2);
        hs.add(e3);
        hs.add(e4);
        hs.add(e5);
        hs.add(e6);
        hs.add(e7);
        hs.add(e8);

        hs.print();
        System.out.println();
        hs.printBestHashSet();
        System.out.println();
        hs.printBestMap();


    }
}
