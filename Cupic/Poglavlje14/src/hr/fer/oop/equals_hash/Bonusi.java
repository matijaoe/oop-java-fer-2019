package hr.fer.oop.equals_hash;

import java.util.HashMap;
import java.util.Map;

public class Bonusi {

    public static void main(String[] args) {

        Map<Zaposlenik, Double> bonusi = new HashMap<>();


        Zaposlenik prvi = new Zaposlenik("1", "Pero", "Perić");
        bonusi.put(prvi, 100.0);
        bonusi.put(new Zaposlenik("2", "Agata", "Agić"), 200.0);
        bonusi.put(new Zaposlenik("3", "Ivana", "Ivić"), 300.0);

        for (Zaposlenik zap : bonusi.keySet()) {
            System.out.printf("Zaposlenik %s ima bonus %f\n",
                    zap.toString(), bonusi.get(zap));
        }

        System.out.println("-----------------------------------------------------");

        Zaposlenik trazeni = new Zaposlenik("1", "Pero", "Perić");

        System.out.printf("Zaposlenik %s ima bonus %f\n",
                prvi.toString(), bonusi.get(prvi));


        System.out.printf("Zaposlenik %s ima bonus %f\n",
                trazeni.toString(), bonusi.get(trazeni));

    }
}
