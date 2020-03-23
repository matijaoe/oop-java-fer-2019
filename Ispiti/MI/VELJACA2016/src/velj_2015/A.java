package velj_2015;

import java.io.Closeable;
import java.io.IOException;

public class A implements Closeable {

    private int x;

    public A(int x) {
        this.x = x;
    }

    @Override
    public void close() throws IOException {
        System.out.println("close " + x);
    }
}
