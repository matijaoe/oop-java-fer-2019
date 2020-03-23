package hr.fer.zad4;

/**
 *
 * @author Matija
 */
public class Main {

    public static void main(String[] args) {

        Octopus o = new Octopus();
        o.printSpecies();

        SeaAnimal o2 = new Octopus();
        o2.printSpecies();

        Fish f = new Fish();
        f.printSpecies();
    }
}
