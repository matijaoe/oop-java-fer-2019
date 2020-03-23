package zad2;

import java.util.Arrays;

public class Bankar {

    public static void pohlepnoGrabljenje() {
        char[] gimme = new char[Integer.MAX_VALUE];
        Arrays.fill(gimme, '$');
        System.out.println("Uspjeh!");
    }

    public static void main(String[] args) {

        try {
            pohlepnoGrabljenje();

        } catch (Error ex) {
            System.err.println("Ha! Uhvacen na djelu!\n\t" + ex.getMessage());
        }

    }
}
