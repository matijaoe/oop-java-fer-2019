package point;

/**
 *
 * @author Matija
 */
public abstract class Shape {

    private Point center;

    public Shape(Point center) {
        this.center = center;
    }

    public Point getCenter() {
        return center;
    }

    public abstract boolean contains(Point p);

    public abstract boolean boundingBox();

}
