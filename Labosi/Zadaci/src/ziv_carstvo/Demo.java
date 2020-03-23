package ziv_carstvo;

public class Demo {

    public static void main(String[] args) {
        Album a = new Album(10);
        Duplikati d = new Duplikati();

        int i = 0;
        while (!a.isFull()) {
            Paketic p = new Paketic();
            System.out.println("Raspakiravam " + ++i + ". paketic:");
            p.print();
            while (!p.isEmpty() && !a.isFull()) {
                Slicica s = p.takeOne();
                if (!a.add(s)) {
                    d.add(s);
                }
            }
            a.print();
            d.print();
            System.out.println("*************************************************************************");
        }

        Paketic p1 = new Paketic();
        p1.takeOne();
        p1.takeOne();
        p1.takeOne();
        p1.takeOne();
        p1.takeOne();
        p1.takeOne(); //OVO NIJE DOBRO! Kako cemo to popraviti?

        Slicica s = new Slicica();
        a.add(s); //OVO NIJE DOBRO! Kako cemo to popraviti?
    }
}
