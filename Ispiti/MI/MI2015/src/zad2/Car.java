package zad2;

public class Car {

    private boolean isLocked = false;
    private String type;

    public Car(String type) {
        this.type = type;
    }

    public Part createLight(int serialNum) {
        return new CarLight(this, serialNum);
    }

    public static class CarLight extends Part {

        private boolean isLightsOn = false;
        private Car car;

        public CarLight(Car car, int serialNum) {
            super(serialNum);
            this.car = car;
        }

        @Override
        public void powerUp() {
            if (!car.isLocked) {
                this.isLightsOn = true;
                System.out.println("Lights on!");
            }
        }

        public boolean getLightsOn() {
            return this.isLightsOn;
        }

        public void setLightsOn(boolean val) {
            this.isLightsOn = val;
        }
    }
}
