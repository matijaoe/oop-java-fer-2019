package triple;

/**
 *
 * @author Matija
 */
class Triangle extends Triple<Number> {

    private Number a, b, c;

    public Triangle(Number a, Number b, Number c) {
        super(a, b, c);
    }

    public double perimeter() {
        double strA = (double) this.a;
        double strB = (double) this.b;
        double strC = (double) this.c;

        return strA + strB + strC;

    }

    public static void main(String[] args) {

        Triangle t = new Triangle(4, 2, 7);
        System.out.println(t.perimeter());
    }
}
