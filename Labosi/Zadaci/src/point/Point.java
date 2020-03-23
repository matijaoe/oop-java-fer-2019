package point;

/**
 *
 * @author Matija
 */
public class Point {

    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public static double distanceTo(Point a, Point b) {
        return Math.pow((Math.pow((a.getX() - b.getX()), 2))
                + (Math.pow((a.getY() - b.getY()), 2)), 0.5);
    }
}
