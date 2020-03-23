package zad1;

import zad1.polimorfizam.Item;

/**
 *
 * @author Matija
 */
public class ItemBox<T extends Item> extends Box<T> {

    public double boxValue() {
        double sum = 0;

        for (T item : this.getItems()) {
            sum += item.getNetSalePrice();
        }

        return sum;

    }
}
