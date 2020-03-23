package hr.fer.zad5;

import hr.fer.zad3.MakeSound;

/**
 *
 * @author Matija
 */
public class Lion extends Animal implements MakeSound {

    public Lion() {
        this.setType(AnimalType.EARTH);
    }

    @Override
    public void introduceYourself() {
        System.out.println("I am a lion.");
    }

    @Override
    public void makeSound() {
        System.out.println("The lion roars.");
    }
}
