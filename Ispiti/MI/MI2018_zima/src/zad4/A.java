package zad4;

public class A implements D {

    private int x, y;

    public A(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
//NA CRTE NADOPISATI DIO KOJI NEDOSTAJE (ILI STAVITI CRTICU AKO NIŠTA NE NEDOSTAJE)

    protected void setX(int x) {
        this.x = x;
    }
    //todo

    protected void setY(int y) {
        this.y = y;
    }

    @Override
    public String values() {
        return String.format("X = %d, Y = %d", x, y);
    }

    @Override
    public void rotate() {
        int temp = this.x;
        this.x = this.y;
        this.y = temp;
    }
}
