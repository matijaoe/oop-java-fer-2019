package zad5;

/**
 *
 * @author Matija
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{15, 10};
        for (int i = 1; i >= -1; i--) {
            try (A a40 = new A(40)) {
                m1(arr, i);
                A a50 = new A(50);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("array exc");
            } catch (Exception e) {
                System.out.println("main exc");
                break;
            } finally {
                System.out.println("main finally");
            }
        }
        System.out.println("main done");
    }

    private static void m1(int[] arr, int j) throws Exception {
        try (A a1 = new A(j)) {
            m2(arr[j] + arr[j + 1], j);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("m1 exc");
        }
        System.out.println("m1 done");
    }

    private static int m2(int x, int y) {
        int r = 0;
        try {
            A a2 = new A(x + y);
            r = x / y;
        } finally {
            System.out.println("m2 finally");
        }
        System.out.println("m2 done");
        return r;
    }
}
