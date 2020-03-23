package zad5;

/**
 *
 * @author Matija
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{15, 10};
        try {
            A a40 = new A(40);
            for (int i = 1; i >= -1; i--) {
                m1(arr, i);
            }
            A a50 = new A(50);
        } catch (Exception e) {
            System.out.println("main exc");
        } finally {
            System.out.println("main finally");
        }
        System.out.println("main done");
    }

    private static void m1(int[] arr, int i) throws Exception {
        try (A a1 = new A(i)) {
            m2(arr[i] + arr[i + 1], i);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("m1 exc");
        }
        System.out.println("m1 done");
    }

    private static int m2(int x, int y) throws Exception {
        int r = 0;
        try (A a2 = new A(x + y)) {
            r = x / y;
        } finally {
            System.out.println("m2 finally");
        }
        System.out.println("m2 done");
        return r;
    }
}
