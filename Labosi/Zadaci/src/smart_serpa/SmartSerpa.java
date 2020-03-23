package smart_serpa;

/**
 *
 * @author Matija
 */
public class SmartSerpa implements CoffeeMaker {

    private int coldWater;
    private int hotWater;
    private int coffee;
    private Integer i;

    public SmartSerpa() {
    }

    @Override
    public void addWater(int water) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void heatWater() {
        if (getWaterAmount() > 0) {

        }
    }

    @Override
    public void addCoffee(int coffeeSpoonNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int pourCoffee(int requestedCupsNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getWaterAmount() {
        return this.coldWater + this.hotWater;
    }

    @Override
    public int getCoffeeSize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isWaterHeated() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
