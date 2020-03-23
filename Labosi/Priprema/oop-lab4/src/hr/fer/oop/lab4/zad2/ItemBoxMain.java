package hr.fer.oop.lab4.zad2;

import hr.fer.oop.inheritance_polymorphism.Beverage;
import hr.fer.oop.inheritance_polymorphism.*;
import java.time.LocalDate;

/**
 *
 * @author Matija
 */
public class ItemBoxMain {

    public static void main(String[] args) {

        ItemBox<Item> itemList = new ItemBox<>();

        Food sushi = new Food("058", "Sushi", 45, LocalDate.of(2019, 4, 28));
        Food chocolate = new Food("069", "Milka", 10, LocalDate.of(2021, 10, 12));
        Food chips = new Food("074", "Lays", 18, LocalDate.of(2015, 10, 1));
        Beverage soda = new Beverage("111", "Fanta", 8, 2);
        Beverage beer = new Beverage("133", "Ožujsko", 12, 8);
        Milk milk1 = new Milk("081", "zBregov mlijeko", 10, 2, MilkType.COW, LocalDate.of(2020, 2, 1));
        Milk milk2 = new Milk("082", "Dukat mlijeko", 14, 1, MilkType.GOAT, LocalDate.of(2020, 1, 25));
        Milk milk3 = new Milk("083", "Veronika mlijeko", 8, 3, MilkType.GOAT, LocalDate.of(2016, 5, 26));
        Cloth shirt = new Cloth("245", "H&M T-shirt", 30, 25);

        itemList.add(sushi);
        itemList.add(chocolate);
        itemList.add(chips);
        itemList.add(soda);
        itemList.add(beer);
        itemList.add(milk1);
        itemList.add(milk2);
        itemList.add(milk3);
        itemList.add(shirt);

        System.out.println("\nItems with expired 'Best Before' dates:");
        itemList.getPerishables();

    }

}
