package hr.fer.zad2;

import hr.fer.zad1.Animal;

/**
 *
 * @author Matija
 */
public class Main {

    public static void main(String[] args) {

        Animal a = new Octopus();
        a.introduceYourself();

        //primjetite da se ne moze koristiti a.wayOfMovement()
        SeaAnimal b = new Octopus();
        b.introduceYourself();
        b.wayOfMovement();

        Fish c = new Fish();
        c.introduceYourself();
        c.wayOfMovement();
    }
}
