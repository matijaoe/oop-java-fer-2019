package zad2;

import java.util.Iterator;
import java.util.LinkedList;

public class MyNumber implements Iterable<Integer> {

    private LinkedList<Integer> list = new LinkedList<>();
    private int x;

    public MyNumber(int x) {
        this.x = x;
        int y = Math.abs(x);
        do {
            list.addFirst(y % 10);
            y = y / 10;
        }
        while (y > 0);
    }

    @Override
    public Iterator<Integer> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        return String.valueOf(x);
    }
}
