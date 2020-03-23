package hr.fer.oop.equals_hash;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
public class DohvatZaposlenika {

    public static void main(String[] args) {

        List<Zaposlenik> lista = new ArrayList<>();

        Zaposlenik prvi = new Zaposlenik("1", "Pero", "Perić");
        lista.add(prvi);
        lista.add(new Zaposlenik("2", "Agata", "Agić"));
        lista.add(new Zaposlenik("3", "Ivana", "Ivić"));

        for (Zaposlenik zaposlenik : lista) {
            System.out.println(zaposlenik);
        }

        Zaposlenik trazeni = new Zaposlenik("1", "Pero", "Perić");

        boolean postoji = lista.contains(prvi);
        System.out.println("Zaposlenik " + prvi + " postoji: " + postoji);

        postoji = lista.contains(trazeni);
        System.out.println("Zaposlenik " + trazeni + " postoji: " + postoji);

        int pozicija = lista.indexOf(prvi);
        System.out.println("Zaposlenik " + prvi + " - pozicija: " + pozicija);

        pozicija = lista.indexOf(trazeni);
        System.out.println("Zaposlenik " + trazeni + " - pozicija: " + pozicija);
    }
}
