package ziv_carstvo;

import java.util.ArrayList;

public class Paketic implements ISlicice {

    private ArrayList<Slicica> paketic;

    public Paketic() {
        this.paketic = new ArrayList<Slicica>();
        for (int i = 0; i < 5; i++) {
            paketic.add(new Slicica());
        }
    }

    @Override
    public int size() {
        return paketic.size();
    }

    @Override
    public boolean isFull() {
        if (paketic.size() == 5) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isEmpty() {
        if (paketic.size() == 0) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean add(Slicica s) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean remove(Slicica s) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean contains(Slicica s) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void print() {
        System.out.println(paketic.toString());

    }

    public Slicica takeOne() {
        if (paketic.isEmpty()) {
            throw new IllegalStateException("Paketic je prazan");
        }
        Slicica povratna = paketic.get(paketic.size() - 1);
        paketic.remove(povratna);
        return povratna;
    }
}
