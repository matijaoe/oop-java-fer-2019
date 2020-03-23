package hr.fer.zad4;

import hr.fer.zad1.Animal;

/**
 *
 * @author Matija
 */
public abstract class SeaAnimal extends Animal {

    private SeaSpecies species;

    public SeaAnimal(SeaSpecies species) {
        this.species = species;
    }

    public abstract void wayOfMovement();

    public void printSpecies() {
        System.out.println(this.species);
    }

    @Override
    public final void introduceYourself() {
        System.out.println(
                "I am a sea animal. I cannot introduce myself.");
    }
}
