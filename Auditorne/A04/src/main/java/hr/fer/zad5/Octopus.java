package hr.fer.zad5;

import hr.fer.zad4.*;

/**
 *
 * @author Matija
 */
public class Octopus extends SeaAnimal {

    public Octopus() {
        super(SeaSpecies.CEPHALOPOD);
    }

    @Override
    public void wayOfMovement() {
        System.out.println("Octopus uses jet propulsion to swim.");
    }
}
