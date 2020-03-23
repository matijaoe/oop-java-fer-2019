package zad4;

/**
 *
 * @author Matija
 */
public class B extends A {

    private int z;

    public B(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public String values() {
        return super.values() + " Z = " + z;
    }

    public int getZ() {
        return this.z;
    }

    @Override
    public void rotate() {
        int tempX = this.getX();
        // rotating
        this.setX(this.getY());
        this.setY(z);
        this.z = tempX;

    }

}
