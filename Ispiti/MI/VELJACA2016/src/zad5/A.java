package zad5;

public class A implements AutoCloseable {

    private int x;

    public A(int x) {
        this.x = x;
        System.out.println("A " + x);
    }

    @Override
    public void close() throws Exception {
        System.out.println("close " + x);
    }
}
