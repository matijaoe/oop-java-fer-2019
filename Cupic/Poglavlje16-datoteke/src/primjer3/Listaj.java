package primjer3;

import java.io.File;

/**
 * Rekurzivni ispis sadržaja
 */
public class Listaj {

    public static void main(String[] args) {
        // primjer argumenta: C:\Intel
        if (args.length != 1) {
            System.err.println("Krivi poziv!");
            System.exit(0);
        }

        File dir = new File(args[0]);
        rekurzivnoListaj(dir);
    }

    private static void rekurzivnoListaj(File dir) {
        System.out.println(dir);
        File[] djeca = dir.listFiles();

        if (djeca == null) {
            return;
        }

        for (File f : djeca) {
            if (f.isFile()) {
                System.out.println(f);
            } else if (f.isDirectory()) {
                rekurzivnoListaj(f);
            } 
        }
    }
}
