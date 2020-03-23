package hr.fer.zad3;

import hr.fer.zad1.*;

/**
 *
 * @author Matija
 */
public class Lion extends Animal implements MakeSound {

    @Override
    public void introduceYourself() {
        System.out.println("I am a lion.");
    }

    @Override
    public void makeSound() {
        System.out.println("The lion roars.");
    }
}
