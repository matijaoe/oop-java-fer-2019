package vjezba.spremnik;

/**
 *
 * @author Matija
 */
public class Main {

    public static void main(String[] args) {

        int i = 0;
        try {
            try (Spremnik s1 = new Spremnik("pero"); Spremnik s2 = new Spremnik("ana")) {
                System.out.print("N1;");
                s1.write(5);
                System.out.print("N2;");
                s2.write(-1);
                System.out.print("N3;");
            } catch (ArithmeticException ex) {
                System.out.print("AE;");
            } finally {
                System.out.print("FI1;");
            }
        } catch (RuntimeException ex) {
            System.out.print("RE;");
        } finally {
            System.out.print("FI2;");
        }
    }
}
