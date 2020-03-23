package zad1;

public class BaseClass {

    private final String message1 = "message1";
    private static final String message2 = "message2";

    public String getMessage() {
        return message1;
    }

    public static String getStaticMessage() {
        return message2;
    }

}

class ExtendedClass extends BaseClass {

    private final String message3 = "message3";
    private static final String message4 = "message4";

    @Override
    public String getMessage() {
        return message3;
    }

    public static String getStaticMessage() {
        return message4;
    }

    public static void main(String[] args) {
        ExtendedClass ec = new ExtendedClass();
        System.out.println(ec.getMessage()); // message3
        System.out.println(ec.getStaticMessage()); // message4
        BaseClass bc = ec;
        System.out.println(bc.getMessage()); // message3
        System.out.println(bc.getStaticMessage()); // message2
    }
}
