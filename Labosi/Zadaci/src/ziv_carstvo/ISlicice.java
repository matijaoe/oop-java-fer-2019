package ziv_carstvo;

import ziv_carstvo.Slicica;

/**
 *
 * @author Matija
 */
public interface ISlicice {

    public int size();

    public boolean isFull();

    public boolean isEmpty();

    public boolean add(Slicica s);

    public boolean remove(Slicica s);

    public boolean contains(Slicica s);

    public void print();
}
