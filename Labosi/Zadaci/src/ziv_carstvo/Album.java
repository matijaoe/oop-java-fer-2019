package ziv_carstvo;

import ziv_carstvo.ISlicice;
import ziv_carstvo.Slicica;
import java.util.HashMap;

public class Album implements ISlicice {

    private HashMap<Integer, String> album;
    private int size;

    public Album(int size) {
        this.album = new HashMap<>();
        this.size = size;
    }

    @Override
    public int size() {
        return album.size();
    }

    @Override
    public boolean isFull() {
        if (album.size() >= size) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (album.size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean add(Slicica s) {
        if (album.size() >= size) {
            throw new IllegalStateException("Album is full.");
        } else if (album.containsKey(s.getRbr())) {
            return false;
        } else {
            album.put(s.getRbr(), s.getNaziv());
            return true;
        }
    }

    @Override
    public boolean remove(Slicica s) {
        if (album.containsKey(s.getRbr())) {
            album.remove(s.getRbr());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(Slicica s) {
        if (album.containsKey(s.getRbr())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void print() {
        for (int i : album.keySet()) {
            System.out.println(i + album.get(i));
        }
    }
}
