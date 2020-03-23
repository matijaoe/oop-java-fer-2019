package zad3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Crow {
    private String name;
    private int yearsOfService;
    private boolean isLordCommander;
    private boolean isAlive;
    private Order order;

    public static enum Order {STEWARD, BUILDER, RANGER}

    public Crow(String name, int yearsOfService, boolean isLordCommander,
                boolean isAlive, Order order) {
        this.name = name;
        this.yearsOfService = yearsOfService;
        this.isLordCommander = isLordCommander;
        this.isAlive = isAlive;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    public boolean isLordCommander() {
        return isLordCommander;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public Order getOrder() {
        return order;
    }

    public static Collection<Crow> allCrows() {
        return new ArrayList<Crow>(
                Arrays.asList(new Crow[]{
                        new Crow("Eddison Tollett", 6, false, true, Order.STEWARD),
                        new Crow("Jon Snow", 4, false, true, Order.STEWARD),
                        new Crow("Samwell Tarly", 3, false, true, Order.STEWARD),
                        new Crow("Aemon Targaryen", 100, false, false, Order.STEWARD),
                        new Crow("Jeor Mormont", 21, true, false, Order.STEWARD),
                        new Crow("Benjen Stark", 22, false, false, Order.RANGER),
                        new Crow("Qhorin Halfhand", 30, false, false, Order.RANGER)
                }));
    }

    /*
     * returned Predicate is true if the crow is a member of the order of stewards
     */
    public static Predicate<Crow> isSteward() {
        return p -> p.getOrder().equals(Order.STEWARD);
    }

    /*
     * returned Predicate is true if the crow has more than 5 years of service
     */
    public static Predicate<Crow> isSeasoned() {
        return p -> p.getYearsOfService() > 5;
    }

    /*
     * returned Predicate is true if the crow is alive or named "Benjen Stark",
     * false otherwise
     */
    public static Predicate<Crow> isActive() {
        return p -> p.isAlive || p.getName().equals("Benjen Stark");
    }

    /*
     * Creates a collection of seasoned and active crows
     */
    public static Collection<Crow> seasonedActiveCrows() {
        return Crow.allCrows()
                .stream().filter(isSeasoned().and(isActive())).collect(Collectors.toList());

        //ili:
        //return Crow.allCrows()
        //      .stream().filter(isSeasoned()).filter(isActive()).collect(Collectors.<Crow>toList());


    }

    public static void printFilteredCrows() {
        new Thread(() -> {
                    for (Crow c : seasonedActiveCrows()) {
                        System.out.println(c.getName());
                    }
                }
        ).start();
    }

    public static void main(String[] args) {
        printFilteredCrows();
    }
}