package hr.fer.zad5;

/**
 *
 * @author Matija
 */
public class Animal {

    private AnimalType type;

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public void introduceYourself() {
        System.out.println("I am an animal.");
    }
}
