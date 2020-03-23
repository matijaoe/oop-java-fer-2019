package hr.fer.zad4;

/**
 *
 * @author Matija
 */
public class Fish extends SeaAnimal {

    public Fish() {
        super(SeaSpecies.FISH);
    }

    @Override
    public void wayOfMovement() {
        System.out.println("The fish uses fins to swim.");

    }
}
