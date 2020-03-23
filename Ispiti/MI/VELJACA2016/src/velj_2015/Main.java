package velj_2015;

/**
 *
 * @author Matija
 */
public class Main {

    public static void main(String[] args) {
        int x = 5, y = 0, z;
        try (A a1 = new A(1)) {
            try {
                A a2 = new A(2);
                z = x / y;
            } catch (Exception innerexc) {
                System.out.println("inner exc");
            } finally {
                System.out.println("finally 1");
            }
            try (A a3 = new A(3)) {
                z = x / y;
            } finally {
                System.out.println("finally 2");
            }
        } catch (Exception exc) {
            System.out.println("exception");
        } finally {
            System.out.println("outer finally");
        }
    }
}
