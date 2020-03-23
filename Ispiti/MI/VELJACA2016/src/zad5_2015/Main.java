package zad5_2015;

public class Main {

    public static void main(String[] args) {
        int x = 5, y = 0, z;
        try (A a1 = new A(1)) {
            A a2 = new A(2);
            try {
                A a3 = new A(3);
                z = x / y;
            } catch (Exception innerexc) {
                System.out.println("inner exc");
            } finally {
                System.out.println("finally 1");
            }
            try (A a4 = new A(4)) {
                z = x / y;
            } finally {
                System.out.println("finally 2");
            }
            A a5 = new A(5);
        } catch (Exception exc) {
            System.out.println("exception");
        } finally {
            System.out.println("outer finally");
        }
    }

}
