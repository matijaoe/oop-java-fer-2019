package hr.fer.oop.lab2.prob1;

import java.util.Locale;
import java.util.Scanner;

/**
 * This program calculates rectangle's area and perimeter. The rectangle
 * parameters can be obtained either through command line as program arguments
 * or through keyboard while the program is running. If there is any number of
 * arguments from the command line, and if it's not two, an error message is
 * printed and the program stops running, else the program reads from keyboard
 * until the user inputs a non-negative width and height value.
 *
 * @author matija
 *
 */
public class Rectangle {

    private static double width, height, area, perimeter;

    public static void main(String[] args) {

        if (args.length != 0) {
            if (args.length != 2) {
                System.err.println("Invalid number of argumnets was provided.");
                return;
            }

            width = Double.parseDouble(args[0]);
            height = Double.parseDouble(args[1]);

        } else {
            Scanner sc = new Scanner(System.in);

            while (width == 0f) {
                System.out.println("Please provide width: ");
                width = getInputValue("width", sc.nextLine().trim());
            }
            while (height == 0f) {
                System.out.println("Please provide height: ");
                height = getInputValue("height", sc.nextLine().trim());
            }
        }

        area = getArea(width, height);
        perimeter = getPerimeter(width, height);

        System.out.format(Locale.ROOT,
                "You have specified a rectangle of "
                + "width %2.1f and height %2.1f. Its Area is %2.1f and its "
                + "perimeter is %2.1f.\n",
                width, height, area, perimeter);

    }

    public static double getInputValue(String param, String input) {
        if (input.isEmpty()) {
            System.out.println("The input must not be blank.");
            return 0;
        }
        double value = Double.parseDouble(input);

        if (value < 0) {
            System.err.println("The " + param + " must not be negative.");
            return 0;
        }
        return value;

    }

    public static double getArea(double width, double height) {
        return width * height;
    }

    public static double getPerimeter(double width, double height) {
        return 2 * (width + height);
    }
}
