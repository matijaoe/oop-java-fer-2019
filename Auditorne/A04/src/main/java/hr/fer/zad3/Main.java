package hr.fer.zad3;

/**
 *
 * @author Matija
 */
public class Main {

    public static void main(String[] args) {

        Duck d = new Duck();
        d.introduceYourself();
        d.makeSound();

        Lion l = new Lion();
        l.introduceYourself();
        l.makeSound();
    }
}
