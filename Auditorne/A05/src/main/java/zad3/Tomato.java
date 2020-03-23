package hr.fer.zad3;

/**
 *
 * @author Matija
 */
public class Tomato extends Plant {

    public Tomato(int requiredWaterAmount) {
        super.requiredWaterAmount = requiredWaterAmount;
    }

    @Override
    public void water(int waterAmount) {
        if (super.watered) {
            System.out.println("The tomato has already been wataered enough!");
        } else {
            System.out.println("Using the sprinkler for watering the tomato...");
        }

        super.collectedWater += waterAmount;

        if (super.collectedWater >= requiredWaterAmount) {
            super.watered = true;
            System.out.println("The tomato has been watered properly.");
        }
    }
}
