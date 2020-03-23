package ziv_carstvo;

public class Duplikati implements ISlicice {

    private SimpleHashtable<Slicica, Integer> duplikati;

    public Duplikati() {
        this.duplikati = new SimpleHashtable<Slicica, Integer>();
    }

    @Override
    public int size() {
        return duplikati.size();
    }

    @Override
    public boolean isFull() {
        if (duplikati.size() >= SimpleHashtable.DEFAULT_CAPACITY) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isEmpty() {
        if (duplikati.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean add(Slicica s) {
        if (!duplikati.containsKey(s)) {
            duplikati.put(s, 1);
            return true;
        } else {
            for (int i = 0; i <= SimpleHashtable.DEFAULT_CAPACITY; i++) {
                if (duplikati.get(s) == i) {
                    duplikati.put(s, i + 1);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean remove(Slicica s) {
        return false;
    }

    @Override
    public boolean contains(Slicica s) {
        if (duplikati.containsKey(s)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void print() {
        System.out.println(duplikati.toString());
    }
}
