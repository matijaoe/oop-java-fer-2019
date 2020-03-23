package hr.fer.oop.lab2.prob2;

/**
 *
 * @author Matija
 */
public class Roots2 {

    private static double real, imaginary;
    private static int root;
    private static double angle, radius;

    public Roots2(double real, double imaginary, int root) {
        Roots2.real = real;
        Roots2.imaginary = imaginary;
        Roots2.root = root;

        Roots2.angle = Math.atan2(Roots2.imaginary, Roots2.real);
        Roots2.radius = Math.sqrt(Math.pow(Roots2.real, 2)
                + Math.pow(Roots2.imaginary, 2));
    }

    public static void main(String[] args) {

        /*if (root < 1) {
            System.err.println("Root cat't be less than 1.");
            System.exit(1);
        }*/
        Roots2 r1 = new Roots2(Double.parseDouble(args[0]),
                Double.parseDouble(args[1]),
                Integer.parseInt(args[2]));

        r1.printRoots();

    }

    public void printRoots() {
        System.out.printf("You requested calculation of %d. roots. Solutions are:\n", root);

        for (int k = 0; k < root; k++) {

            double rootedRadius = Math.pow(Roots2.radius, 1 / Roots2.root);

            double re = rootedRadius * Math.cos((Roots2.angle + 2 * k * Math.PI) / Roots2.root);
            double im = rootedRadius * Math.sin((Roots2.angle + 2 * k * Math.PI) / Roots2.root);

            String imPrefix = im > 0 ? "+" : "-";

            System.out.println(String.format("%1$d) %2$d " + imPrefix + "% 3$di", k + 1, Math.round(re), Math.round(im)));

        }

    }

}
