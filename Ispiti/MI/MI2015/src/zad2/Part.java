package zad2;

public abstract class Part {

    public Integer serialNum;

    public abstract void powerUp();

    public Part(Integer serialNum) {
        System.out.println("Part created!");
        this.serialNum = serialNum;
    }

    @Override
    public String toString() {
        return this.serialNum.toString();
    }
}
