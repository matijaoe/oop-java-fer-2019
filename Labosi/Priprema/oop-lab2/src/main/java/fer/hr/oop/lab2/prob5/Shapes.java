package fer.hr.oop.lab2.prob5;

/**
 *
 * @author matija
 */
public class Shapes {

    private static final int LENGTH = 10;
    private static final int SIZE = 21;

    public static void main(String[] args) {
        for (int i = 0; i < SIZE + 1; i++) {
            switch (i) {
                case 0:
                case 6:
                case 16:
                case 21:
                    System.out.println(getBase());
                    break;
                case 1:
                case 11:
                case 14:
                    System.out.println(getSides("\\", "/"));
                    break;
                case 5:
                case 10:
                case 20:
                    System.out.println(getSides("/", "\\"));
                    break;
                case 2:
                case 12:
                case 15:
                    System.out.println(getSlope(true));
                    break;
                case 4:
                case 9:
                case 18:
                    System.out.println(getSlope(false));
                    break;
                case 7:
                case 13:
                case 17:
                    System.out.println();
                    break;
                default:
                    break;
            }
        }
    }

    public static String getBase() {
        String str = "";
        for (int i = 0; i < LENGTH; i++) {
            if (i == 0 || i == LENGTH - 1) {
                str += "+";
            } else {
                str += "-";
            }
        }
        return str;
    }

    public static String getSecondaryBase() {
        String str = "";
        for (int i = 0; i < LENGTH; i++) {
            if (i >= 2 && i <= LENGTH - 3) {
                str += "_";
            } else {
                str += " ";
            }
        }
        return str;
    }

    public static String getSides(String first, String second) {
        String str = "";
        for (int i = 0; i < LENGTH; i++) {
            if (i == 0) {
                str += first;
            } else if (i == LENGTH - 1) {
                str += second;
            } else {
                str += " ";
            }
        }
        return str;
    }

    public static String getSlope(boolean isUp) {
        String str = "";

        if (isUp) {
            for (int i = 0; i < LENGTH; i++) {
                if (i == 1) {
                    str += "\\";
                } else if (i == LENGTH - 2) {
                    str += "/";
                } else if (i >= 2 && i <= LENGTH - 3) {
                    str += "_";
                } else {
                    str += " ";
                }
            }
        } else {
            str += getSecondaryBase();
            str += "\n";
            for (int i = 0; i < LENGTH; i++) {
                if (i == 1) {
                    str += "/";
                } else if (i == LENGTH - 2) {
                    str += "\\";
                } else {
                    str += " ";
                }
            }
        }
        return str;
    }
}
