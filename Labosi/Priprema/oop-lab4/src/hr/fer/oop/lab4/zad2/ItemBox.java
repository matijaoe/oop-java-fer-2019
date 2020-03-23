package hr.fer.oop.lab4.zad2;

import hr.fer.oop.inheritance_polymorphism.Item;
import hr.fer.oop.inheritance_polymorphism.*;
import java.time.LocalDate;

/**
 *
 * @author Matija
 */
public class ItemBox<T extends Item> extends SimpleArrayList<T> {

    public void getPerishables() {
        // iterates over the itemBox
        for (int i = 0; i < size; i++) {
            T item = this.get(i);
            // checks if item is perishable (has a best before date)
            if (item instanceof IPerishable) {
                // checks if the date is expired
                if (((IPerishable) item).getBestBefore().isBefore(LocalDate.now())) {
                    System.out.println("\t- " + item.getSku() + " - " + item.getName());
                }
            }
        }
    }

}
