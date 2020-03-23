package hr.fer.zad2;

import hr.fer.zad1.Animal;

/**
 *
 * @author Matija
 */
public abstract class SeaAnimal extends Animal {

    public abstract void wayOfMovement();

    @Override
    public final void introduceYourself() {
        System.out.println("I am a see animal. I cannot introduce myself.");
    }
}
