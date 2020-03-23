package hr.fer.oop.lab2.vjezba;

import java.util.Scanner;

/**
 *
 * @author Matija
 */
public class AreaAndBand {

    private static double[] coordinatesX = new double[4];
    private static double[] coordinatesY = new double[4];
    private static double ax, ay, bx, by, cx, cy, dx, dy;

    private static Point a;
    private static Point b;
    private static Point c;
    private static Point d;

    public static void main(String[] args) {
        setPoints();
        if (!checkIfRectangle()) {
            System.out.println("Entered points do not make a rectangle.");
            System.exit(1);
        } else {
            System.out.println("You entered a rectangle!");
        }
        System.out.println("Area: " + getArea());
        System.out.println("Band " + getBand());
    }

    public static void setPoints() {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            System.out.println("Enter x and y coordinates: ");
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            coordinatesX[i] = x;
            coordinatesY[i] = y;
        }
        ax = coordinatesX[0];
        ay = coordinatesY[0];
        bx = coordinatesX[1];
        by = coordinatesY[1];
        cx = coordinatesX[2];
        cy = coordinatesY[2];
        dx = coordinatesX[3];
        dy = coordinatesY[3];

        Point a = new Point(ax, ay);
        Point b = new Point(bx, by);
        Point c = new Point(cx, cy);
        Point d = new Point(dx, dy);

    }

    public static double getDistance(Point first, Point second) {
        double distanceX, distanceY;
        distanceX = Math.abs(first.getX() - second.getX());
        distanceY = Math.abs(first.getY() - second.getY());
        return distanceX + distanceY;
    }

    public static double getArea() {
        double distanceAB = getDistance(a, b);
        double distanceBC = getDistance(b, c);

        return distanceAB * distanceBC;
    }

    public static double getBand() {
        double distanceAB = getDistance(a, b);
        double distanceCD = getDistance(c, d);

        return 2 * (distanceAB + distanceCD);
    }

    public static void mirrorY() {
        a.setY(-a.getY());
        b.setY(-b.getY());
        c.setY(-c.getY());
        d.setY(-d.getY());

    }

    public static boolean checkIfRectangle() {
        double firstDistance = getDistance(a, b);
        double secondDistance = getDistance(c, d);

        return Math.abs(firstDistance - secondDistance) < (1E-15);
    }
}
